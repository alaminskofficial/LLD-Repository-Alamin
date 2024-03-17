package org.example.machineCoding.restaurentMgmtSystem.libraries.paytm;

import java.util.Date;
import java.util.UUID;

public class PaytmApi {
    public PaytmPaymentResponse makePayment(long orderId, double amount){
        // Api calls to make payment
        // Once payment is done, we will get a PaytmPaymentResponse object from Paytm
        PaytmPaymentResponse paytmPaymentResponse = new PaytmPaymentResponse();
        paytmPaymentResponse.setOrderId(Long.toString(orderId));
        paytmPaymentResponse.setPaymentStatus("SUCCESS");
        paytmPaymentResponse.setTxnAmount(amount);
        paytmPaymentResponse.setTxnDate(new Date());
        paytmPaymentResponse.setTxnId(UUID.randomUUID().toString());
        return paytmPaymentResponse;
    }

}
