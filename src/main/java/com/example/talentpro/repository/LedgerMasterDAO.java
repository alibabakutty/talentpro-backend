package com.example.talentpro.repository;

import com.example.talentpro.entity.LedgerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface LedgerMasterDAO extends JpaRepository<LedgerMaster, Long> {
    boolean existsByLedgerTime(LocalDateTime ledgerTime);
    Optional<LedgerMaster> findByLedgerTime(LocalDateTime ledgerTime);
}
