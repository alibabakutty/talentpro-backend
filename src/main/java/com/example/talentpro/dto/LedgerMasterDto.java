package com.example.talentpro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LedgerMasterDto {

    private LocalDateTime ledgerTime;

    private BigDecimal totalDebitAmount;

    private BigDecimal totalCreditAmount;

    private BigDecimal totalCostCenterAmountDebit;

    private BigDecimal totalCostCenterAmountCredit;

    private List<LedgerTransactionsDto> ledgerTransactions;
}
