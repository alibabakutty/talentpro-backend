package com.example.talentpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ledger_master")
public class LedgerMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ledger_date")
    private LocalDateTime ledgerTime;

    @Column(name = "total_debit_amount")
    private BigDecimal totalDebitAmount;

    @Column(name = "total_credit_amount")
    private BigDecimal totalCreditAmount;

    @Column(name = "total_cost_center_amount_debit")
    private BigDecimal totalCostCenterAmountDebit;

    @Column(name = "total_cost_center_amount_credit")
    private BigDecimal totalCostCenterAmountCredit;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "transaction_id")
    private List<LedgerTransactions> ledgerTransactions;
}
