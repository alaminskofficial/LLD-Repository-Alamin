package org.example.machineCoding.parkingLot.parkingLotAssignment.dtos;

public class GenerateInvoiceRequestDto {
        private long ticketId;
        private long gateId;

        public long getTicketId() {
            return ticketId;
        }

        public void setTicketId(long ticketId) {
            this.ticketId = ticketId;
        }

        public long getGateId() {
            return gateId;
        }

        public void setGateId(long gateId) {
            this.gateId = gateId;
        }
}
