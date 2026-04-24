package Energy_Communities_Group.A.Energy_Communities;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsageDataRepository {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private final Map<String, UsageData> usageData;

    public UsageDataRepository() {
        this.usageData = new LinkedHashMap<>();
        newUsage(new UsageData("2026-04-25T14:00:00", 18.050, 18.020, 1.056));
        newUsage(new UsageData("2026-04-25T13:00:00", 15.015, 14.033, 2.049));
        newUsage(new UsageData("2026-04-25T12:00:00", 20.100, 19.500, 0.876));
        newUsage(new UsageData("2026-04-25T11:00:00", 22.300, 20.100, 0.500));
        newUsage(new UsageData("2026-04-25T10:00:00", 19.800, 18.200, 1.200));
        newUsage(new UsageData("2026-04-24T14:00:00", 16.500, 15.800, 2.300));
        newUsage(new UsageData("2026-04-24T13:00:00", 10.000, 9.500, 1.300));
        newUsage(new UsageData("2026-04-24T12:00:00", 6.500, 6.300, 1.000));
    }

    public void newUsage(UsageData usagedate) {
        usageData.put(usagedate.getHour(), usagedate);
    }

    public List<UsageData> findAllData() {
        return new ArrayList<>(usageData.values());
    }

    public List<UsageData> findDateRange(String start, String end) {
        LocalDateTime startTime = LocalDateTime.parse(start, FMT);
        LocalDateTime endTime = LocalDateTime.parse(end, FMT);

        return usageData.values().stream()
                .filter(usagedate -> {
                    LocalDateTime hour = LocalDateTime.parse(usagedate.getHour(), FMT);
                    return !hour.isBefore(startTime) && !hour.isAfter(endTime);
                })
                .toList();
    }
}