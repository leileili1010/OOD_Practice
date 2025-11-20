import java.util.*;

public class Row {
    private List<Spot> spots;

    public Row(List<Spot> spots) {
        this.spots = spots;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public List<Spot> findConsecutiveSpots(Vehicle v) {
        int need = v.getRequiredSpots();
        List<Spot> temp = new ArrayList<>();

        for (Spot s : spots) {
            if (s.isAvailable() && s.canFitVehicle(v)) {
                temp.add(s);
                if (temp.size() == need) return temp; // Found!
            } else {
                temp.clear(); // reset consecutive search
            }
        }
        return null; // no match in this row
    }
}
