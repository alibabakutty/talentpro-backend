package com.example.talentpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ledger_transactions")
public class LedgerTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serial_number")
    private Long serialNumber;

    @Column(name = "ledger_name")
    private String ledgerName;

    @Column(name = "ledger_group")
    private String ledgerGroup;

    @Column(name = "sub_group")
    private String subGroup;

    @Column(name = "tally_group")
    private String tallyGroup;

    @Column(name = "debit_amount")
    private BigDecimal debitAmount;

    @Column(name = "credit_amount")
    private BigDecimal creditAmount;

    @Column(name = "cost_category")
    private String costCategory;

    @Column(name = "cost_center")
    private String costCenter;

    @Column(name = "cost_center_amount_debit")
    private BigDecimal costCenterAmountDebit;

    @Column(name = "cost_center_amount_debit_field")
    private String costCenterAmountDebitField;


    @Column(name = "cost_center_amount_credit")
    private BigDecimal costCenterAmountCredit;

    @Column(name = "cost_center_amount_credit_field")
    private String costCenterAmountCreditField;
}
