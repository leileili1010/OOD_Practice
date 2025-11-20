public abstract class Vehicle {
    protected VehicleType type;
    protected int requiredSpots;

    public VehicleType getType() {
        return type;
    }

    public int getRequiredSpots() {
        return requiredSpots;
    }
}
