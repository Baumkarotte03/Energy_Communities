package org.example.usageservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UsageDataRepository extends JpaRepository<org.example.usageservice.UsageData, Long> {
    Optional<org.example.usageservice.UsageData> findByHour(LocalDateTime hour);
}
