package org.example.machineCoding.parkingLot.parkingLotAssignment.services;

import org.example.machineCoding.parkingLot.parkingLotAssignment.exceptions.InvalidGateException;
import org.example.machineCoding.parkingLot.parkingLotAssignment.exceptions.TicketNotFoundException;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.AdditionalService;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Gate;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Invoice;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Ticket;
import org.example.machineCoding.parkingLot.parkingLotAssignment.respositories.GateRepository;
import org.example.machineCoding.parkingLot.parkingLotAssignment.respositories.InvoiceRepository;
import org.example.machineCoding.parkingLot.parkingLotAssignment.respositories.TicketRepository;
import org.example.machineCoding.parkingLot.parkingLotAssignment.strategies.pricing.PricingStrategy;
import org.example.machineCoding.parkingLot.parkingLotAssignment.strategies.pricing.PricingStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class InvoiceServiceImpl implements InvoiceService{

    private TicketRepository ticketRepository;
    private PricingStrategyFactory pricingStrategyFactory;

    private GateRepository gateRepository;
    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(TicketRepository ticketRepository, PricingStrategyFactory pricingStrategyFactory, GateRepository gateRepository, InvoiceRepository invoiceRepository) {
        this.ticketRepository = ticketRepository;
        this.pricingStrategyFactory = pricingStrategyFactory;
        this.gateRepository = gateRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice createInvoice(long ticketId, long gateId) throws TicketNotFoundException, InvalidGateException {
        Optional<Ticket> ticketOptional = ticketRepository.getTicketById(ticketId);

        if(ticketOptional.isEmpty()){
            throw new TicketNotFoundException("Ticket not found");
        }
        Ticket ticket = ticketOptional.get();
        Optional<Gate> optionalGate = this.gateRepository.findById(gateId);
        if(optionalGate.isEmpty()){
            throw new InvalidGateException("Invalid gate id");
        }
        Date exitTime = new Date();
        PricingStrategy pricingStrategy = pricingStrategyFactory.getPricingStrategy(exitTime);
        double costIncurredForParking = pricingStrategy.calculateAmount(ticket.getEntryTime(), exitTime, ticket.getVehicle().getVehicleType());
        double costIncurredForAdditionalServices = 0;
        for(AdditionalService additionalService: ticket.getAdditionalServices()){
            costIncurredForAdditionalServices += additionalService.getCost();
        }
        double totalCost = costIncurredForParking + costIncurredForAdditionalServices;
        Gate gate = optionalGate.get();
        Invoice invoice = new Invoice();
        invoice.setTicket(ticket);
        invoice.setGate(gate);
        invoice.setExitTime(exitTime);
        invoice.setAmount(totalCost);
        invoice = this.invoiceRepository.save(invoice);
        return invoice;
    }
}

