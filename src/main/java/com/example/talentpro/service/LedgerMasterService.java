package com.example.talentpro.service;


import com.example.talentpro.dto.LedgerMasterDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface LedgerMasterService {

    LedgerMasterDto createLedgerMaster(LedgerMasterDto ledgerMasterDto);

    LedgerMasterDto getLedgerMaster(LocalDateTime ledgerTime);

    List<LedgerMasterDto> getAllLedgerMaster();

    LedgerMasterDto updateLedgerMaster(LocalDateTime ledgerTime, LedgerMasterDto updateLedger);

    void deleteByLedgerMaster(Long id);
}
