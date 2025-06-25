package com.example.talentpro.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LedgerTransactionsDto {

    private Long serialNumber;

    @NotEmpty(message = "Ledger name cannot be empty")
    private String ledgerName;

    private String ledgerGroup;

    private String subGroup;

    private String tallyGroup;

    private BigDecimal debitAmount;

    private BigDecimal creditAmount;

    private String costCategory;

    private String costCenter;

    private BigDecimal costCenterAmountDebit;

    private String costCenterAmountDebitField;


    private BigDecimal costCenterAmountCredit;

    private String costCenterAmountCreditField;
}
