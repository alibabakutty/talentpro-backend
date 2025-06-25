package com.example.talentpro.mapper;

import com.example.talentpro.dto.LedgerTransactionsDto;
import com.example.talentpro.entity.LedgerTransactions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LedgerTransactionsMapper {
    LedgerTransactions toEntity(LedgerTransactionsDto ledgerTransactionsDto);

    LedgerTransactionsDto toDto(LedgerTransactions ledgerTransactions);
}
