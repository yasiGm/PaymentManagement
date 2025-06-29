package com.example.PaymentManagement.controller;
import com.example.PaymentManagement.dto.PaymentResponse;
import com.example.PaymentManagement.mapper.PaymentMapper;

        import com.example.PaymentManagement.dto.PaymentRequest;
        import com.example.PaymentManagement.entity.Payment;
        import com.example.PaymentManagement.service.PaymentService;
        import jakarta.validation.Valid;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.http.HttpStatus;

        import java.util.List;

@RestController
@RequestMapping("/api/payments")

public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController (PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        Payment payment = Payment.builder()
                .amount(paymentRequest.getAmount())
                .currency(paymentRequest.getCurrency())
                .recipient(paymentRequest.getRecipient())
                .description(paymentRequest.getDescription())
                .build();

        Payment saved = paymentService.createPayment(payment);
        PaymentResponse response = PaymentMapper.mapToResponse(saved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



    @GetMapping
    public ResponseEntity<List<PaymentResponse>> getAllPayments(){
        List<Payment> payments = paymentService.getAllPayments();
        List<PaymentResponse> paymentResponses = payments.stream()
                .map(PaymentMapper::mapToResponse)
                .toList();
        return ResponseEntity.ok(paymentResponses);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        PaymentResponse paymentResponse = PaymentMapper.mapToResponse(payment);
        return ResponseEntity.ok(paymentResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok("Payment with ID " + id + " has been deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponse> updatePayment(
            @PathVariable Long id,
            @Valid @RequestBody PaymentRequest paymentRequest) {
        Payment existingPayment = paymentService.getPaymentById(id);
        existingPayment.setAmount(paymentRequest.getAmount());
        existingPayment.setCurrency(paymentRequest.getCurrency());
        existingPayment.setRecipient(paymentRequest.getRecipient());
        existingPayment.setDescription(paymentRequest.getDescription());
        Payment updatedPayment = paymentService.createPayment(existingPayment);
        PaymentResponse response = PaymentMapper.mapToResponse(updatedPayment);

        return ResponseEntity.ok(response);
    }

}

