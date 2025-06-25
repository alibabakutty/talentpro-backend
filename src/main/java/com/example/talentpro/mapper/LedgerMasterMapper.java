package com.example.talentpro.mapper;

import com.example.talentpro.dto.LedgerMasterDto;
import com.example.talentpro.entity.LedgerMaster;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {LedgerTransactionsMapper.class})
public interface LedgerMasterMapper {
    // Map from DTo to Entity
    LedgerMaster toEntity(LedgerMasterDto ledgerMasterDto);

    // Map from Entity to Dto
    LedgerMasterDto toDto(LedgerMaster ledgerMaster);

    // update from Dto
    void updateFromDto(LedgerMasterDto dto, @MappingTarget LedgerMaster ledgerMaster);
}
