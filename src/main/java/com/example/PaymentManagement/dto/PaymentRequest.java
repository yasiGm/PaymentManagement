package com.example.PaymentManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    @NotBlank
    @Size(min=3,max=50)
    private String recipient;
    @NotBlank
    private String currency;
    @Size(max=100)
    private String description;
    @NotNull
    @Positive
    private BigDecimal amount;

    // Additional fields can be added as needed
}
