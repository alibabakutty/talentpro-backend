package com.example.talentpro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LedgerMasterDto {

    private LocalDateTime ledgerTime;

    private List<LedgerTransactionsDto> ledgerTransactions;
}
