package Energy_Communities_Group.A.Energy_Communities;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnergyController {

    private final CurrentPercentageRepository percentageRepository;
    private final UsageDataRepository usageDataRepository;

    public EnergyController(CurrentPercentageRepository percentageRepository, UsageDataRepository usageDataRepository) {
        this.percentageRepository = percentageRepository;
        this.usageDataRepository  = usageDataRepository;
    }

    @GetMapping("/energy/current")
    public CurrentPercentage getCurrent() {
        return percentageRepository.findCurrent();
    }

    @GetMapping("/energy/historical")
    public List<UsageData> getHistorical(@RequestParam String start, @RequestParam String end) {
        return usageDataRepository.findDateRange(start, end);
    }
}
