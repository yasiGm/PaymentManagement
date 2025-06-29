package com.example.PaymentManagement.entity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Payment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(nullable = false)
    private BigDecimal amount;
@Column(nullable = false)
    private String currency;
@Column(nullable = false)
    private String recipient;
@Column(nullable = true)
    private String description;
@Column(nullable = false)
    private LocalDateTime timestamp= LocalDateTime.now();

}
