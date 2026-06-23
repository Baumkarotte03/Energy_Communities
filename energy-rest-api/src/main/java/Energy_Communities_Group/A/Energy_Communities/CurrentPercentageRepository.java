package Energy_Communities_Group.A.Energy_Communities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentPercentageRepository extends JpaRepository<CurrentPercentage, Long> {
    CurrentPercentage findTopByOrderByHourDesc();
}