package com.example.finance.dto;

import com.example.finance.enums.TransactionCategory;
import com.example.finance.enums.TransactionType;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransactionDTO {
    private Long id;
    private LocalDate date;
    private String description;
    private TransactionType type;
    private TransactionCategory category;
    private BigDecimal amount;
    private String notes;
}