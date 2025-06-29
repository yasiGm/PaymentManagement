package com.example.PaymentManagement.mapper;

import com.example.PaymentManagement.dto.PaymentResponse;
import com.example.PaymentManagement.entity.Payment;
public class PaymentMapper {
    public static PaymentResponse mapToResponse(Payment payment){
        return new PaymentResponse(
                payment.getId(),
                payment.getRecipient(),
                payment.getCurrency(),
                payment.getDescription(),
                payment.getAmount(),
                payment.getTimestamp()
        );
    }
}
