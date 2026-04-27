package Energy_Communities_Group.A.Energy_Communities;

import org.springframework.stereotype.Repository;

@Repository
public class CurrentPercentageRepository {

    private CurrentPercentage current;

    public CurrentPercentageRepository() {
        this.current = new CurrentPercentage("2026-04-25T14:00:00", 100, 5.25);
    }

    public CurrentPercentage findCurrent() {
        return current;
    }

    public CurrentPercentage newCurrent(CurrentPercentage currentpercentage) {
        this.current = currentpercentage;
        return this.current;
    }
}