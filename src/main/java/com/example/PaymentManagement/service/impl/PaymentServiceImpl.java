package com.example.PaymentManagement.service.impl;

import com.example.PaymentManagement.service.PaymentService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.PaymentManagement.entity.Payment;
import com.example.PaymentManagement.repository.PaymentRepository;


@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }
    @Override
    public void deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Payment not found with id: " + id);
        }
        paymentRepository.deleteById(id);
    }


}
