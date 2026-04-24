package Energy_Communities_Group.A.Energy_Communities;

public class CurrentPercentage {
    private String hour;
    private double community_depleted;
    private double grid_portion;

    public CurrentPercentage(double grid_portion, double community_depleted, String hour) {
        this.grid_portion = grid_portion;
        this.community_depleted = community_depleted;
        this.hour = hour;
    }
}
