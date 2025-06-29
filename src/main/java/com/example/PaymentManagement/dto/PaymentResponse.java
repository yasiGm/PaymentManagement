package com.example.PaymentManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private Long id;
    private String recipient;
    private String currency;
    private String description;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}
