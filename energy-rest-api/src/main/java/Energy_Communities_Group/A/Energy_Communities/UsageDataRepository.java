package Energy_Communities_Group.A.Energy_Communities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsageDataRepository extends JpaRepository<UsageData, Long> {
    List<UsageData> findByHourBetweenOrderByHourAsc(LocalDateTime start, LocalDateTime end);
}