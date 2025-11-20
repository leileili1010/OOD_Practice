public class Spot {
    private int id;
    private SpotType type;
    private boolean available = true;
    private Level level;

    public Spot(int id, SpotType type) {
        this.id = id;
        this.type = type;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isAvailable() {
        return available;
    }

    public SpotType getType() {
        return type;
    }

    public boolean canFitVehicle(Vehicle v) {
        if (v.getType() == VehicleType.MOTORCYCLE) return type == SpotType.MEDIUM || type == SpotType.SMALL;

        if (v.getType() == VehicleType.CAR) {
            return type == SpotType.MEDIUM || type == SpotType.SMALL;
        }

        if (v.getType() == VehicleType.BUS) {
            return type == SpotType.LARGE;
        }

        return false;
    }

    public void takeSpot() {
        available = false;
        level.updateAvailableCount(-1);
    }

    public void leaveSpot() {
        available = true;
        level.updateAvailableCount(+1);
    }
}
