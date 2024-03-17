package org.example.machineCoding.restaurentMgmtSystem.adapters;

import org.example.machineCoding.restaurentMgmtSystem.libraries.razorpay.RazorpayApi;
import org.example.machineCoding.restaurentMgmtSystem.libraries.razorpay.RazorpayPaymentResponse;
import org.example.machineCoding.restaurentMgmtSystem.models.Payment;
import org.example.machineCoding.restaurentMgmtSystem.models.PaymentStatus;

public class RazorpayAdaptor {
    public class RazorpayAdapter implements PaymentGatewayAdapter{
        private RazorpayApi razorpayApi;

        public RazorpayAdapter(RazorpayApi razorpayApi) {
            this.razorpayApi = razorpayApi;
        }

        @Override
        public Payment makePayment(long billId, double amount) {
            RazorpayPaymentResponse razorpayPaymentResponse = razorpayApi.processPayment(billId, amount);
            Payment payment = new Payment();
            payment.setTxnId(razorpayPaymentResponse.getTransactionId());
            payment.setPaymentStatus(PaymentStatus.valueOf(razorpayPaymentResponse.getPaymentStatus()));
            payment.setBillId(billId);
            return payment;
        }
    }
}
