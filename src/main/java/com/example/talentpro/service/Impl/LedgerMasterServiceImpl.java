package com.example.talentpro.service.Impl;

import com.example.talentpro.dto.LedgerMasterDto;
import com.example.talentpro.entity.LedgerMaster;
import com.example.talentpro.mapper.LedgerMasterMapper;
import com.example.talentpro.repository.LedgerMasterDAO;
import com.example.talentpro.service.LedgerMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LedgerMasterServiceImpl implements LedgerMasterService {
    private final LedgerMasterDAO ledgerMasterDAO;
    private final LedgerMasterMapper ledgerMasterMapper;

    @Override
    public LedgerMasterDto createLedgerMaster(LedgerMasterDto ledgerMasterDto){
        // check for duplicate entry
        if (ledgerMasterDAO.existsByLedgerTime(ledgerMasterDto.getLedgerTime())) {
            throw new DuplicateKeyException("Duplicate entry for unique field:" + ledgerMasterDto.getLedgerTime());
        }

        // Map DTO to Entity
        LedgerMaster ledgerMaster = ledgerMasterMapper.toEntity(ledgerMasterDto);
        // Save Entity
        LedgerMaster saveLedger = ledgerMasterDAO.save(ledgerMaster);
        // Map saved Entity to DTO and return
        return ledgerMasterMapper.toDto(saveLedger);
    }

    @Override
    public LedgerMasterDto getLedgerMaster(LocalDateTime ledgerTime){
        LedgerMaster ledgerMaster = ledgerMasterDAO.findByLedgerTime(ledgerTime)
                .orElseThrow(() -> new ResolutionException("Ledger is not found with this date:" + ledgerTime));
        // Map Entity to DTo and Return
        return ledgerMasterMapper.toDto(ledgerMaster);
    }

    @Override
    public List<LedgerMasterDto> getAllLedgerMaster(){
        // Find all entities
        List<LedgerMaster> ledgerMasters = ledgerMasterDAO.findAll();
        // Map each Entity to DTO and return as list
        return ledgerMasters.stream().map(ledgerMasterMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public LedgerMasterDto updateLedgerMaster(LocalDateTime ledgerTime, LedgerMasterDto updateLedger){
        LedgerMaster existingLedger = ledgerMasterDAO.findByLedgerTime(ledgerTime)
                .orElseThrow(() -> new ResolutionException("Ledger is not found with this date:" + ledgerTime));
        // Map update fields from DTO to the existing entity
        ledgerMasterMapper.updateFromDto(updateLedger, existingLedger);

        // save the updated entity back to DTO and return
        LedgerMaster updatedLedger = ledgerMasterDAO.save(existingLedger);
        // Convert updated entity back to DTO and return
        return ledgerMasterMapper.toDto(updatedLedger);
    }

    @Override
    public void deleteByLedgerMaster(Long id){
        LedgerMaster ledgerMaster = ledgerMasterDAO.findById(id)
                .orElseThrow(() -> new ResolutionException("Leger name not found with this id:" + id));
        ledgerMasterDAO.delete(ledgerMaster);
    }
}
