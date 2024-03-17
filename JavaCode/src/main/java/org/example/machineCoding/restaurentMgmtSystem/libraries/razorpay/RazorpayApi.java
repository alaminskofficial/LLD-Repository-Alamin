package org.example.machineCoding.restaurentMgmtSystem.libraries.razorpay;

import java.util.Date;
import java.util.UUID;

public class RazorpayApi {
    public RazorpayPaymentResponse processPayment(long orderId, double transactionAmount) {
        // Code to process payment through Razorpay
        // If payment is successful, return RazorpayPaymentResponse object
        RazorpayPaymentResponse razorpayPaymentResponse = new RazorpayPaymentResponse();
        razorpayPaymentResponse.setTransactionId(UUID.randomUUID().toString());
        razorpayPaymentResponse.setPaymentStatus("SUCCESS");
        razorpayPaymentResponse.setOrderId(Long.toString(orderId));
        razorpayPaymentResponse.setTransactionAmount(transactionAmount);
        razorpayPaymentResponse.setTransactionDate(new Date());
        return razorpayPaymentResponse;
    }
}
