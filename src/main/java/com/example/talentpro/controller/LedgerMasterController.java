package com.example.talentpro.controller;

import com.example.talentpro.dto.LedgerMasterDto;
import com.example.talentpro.service.LedgerMasterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/ledgerMasterApi")
public class LedgerMasterController {

    private final LedgerMasterService ledgerMasterService;

    // Constructor Injection
    public LedgerMasterController(LedgerMasterService ledgerMasterService){
        this.ledgerMasterService = ledgerMasterService;
    }

    // BUILD ADD Master REST API
    @PostMapping("/addLedger")
    public ResponseEntity<LedgerMasterDto> createLedgerMaster(@Valid @RequestBody LedgerMasterDto ledgerMasterDto){
        LedgerMasterDto saveLedgerMaster = ledgerMasterService.createLedgerMaster(ledgerMasterDto);
        return new ResponseEntity<>(saveLedgerMaster, HttpStatus.CREATED);
    }

    // Build GET Master
    @GetMapping("/displayLedger/{ledgerTime}")
    public ResponseEntity<LedgerMasterDto> getLedgerByLedgerDate(@PathVariable LocalDateTime ledgerTime){
        Optional<LedgerMasterDto> ledgerMaster = Optional.ofNullable(ledgerMasterService.getLedgerMaster(ledgerTime));
        return ledgerMaster.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Build Get All Masters Rest Api
    @GetMapping("/allLedgers")
    public ResponseEntity<List<LedgerMasterDto>> getAllLedgers(){
        List<LedgerMasterDto> ledgerMasterDtos = ledgerMasterService.getAllLedgerMaster();
        return new ResponseEntity<>(ledgerMasterDtos, HttpStatus.OK);
    }

    // Build Update Master Rest Api
    @PutMapping("/alterLedgerMaster/{ledgerTime}")
    public ResponseEntity<LedgerMasterDto> updateLedgerMaster(@PathVariable LocalDateTime ledgerTime, @RequestBody LedgerMasterDto updateLedgerMaster){
        LedgerMasterDto updatedLedger = ledgerMasterService.updateLedgerMaster(ledgerTime, updateLedgerMaster);
        return ResponseEntity.ok(updatedLedger);
    }

    // Build Delete Ledger Master Rest Api
    @DeleteMapping("/deleteLedger/{id}")
    public ResponseEntity<Void> deleteLedgerMaster(@PathVariable Long id){
        ledgerMasterService.deleteByLedgerMaster(id);
        return ResponseEntity.noContent().build();
    }
}
