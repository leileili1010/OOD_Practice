import java.util.*;

public class Level {
    private List<Row> rows;
    private int availableCount;

    public Level(List<Row> rows) {
        this.rows = rows;

        // Set level reference for each spot
        for (Row row : rows) {
            for (Spot s : row.getSpots()) {
                s.setLevel(this);
            }
        }

        this.availableCount = countInitialAvailable();
    }

    private int countInitialAvailable() {
        int count = 0;
        for (Row row : rows) {
            for (Spot s : row.getSpots()) {
                if (s.isAvailable()) count++;
            }
        }
        return count;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void updateAvailableCount(int diff) {
        this.availableCount += diff;
    }

    public List<Spot> findSpotsForVehicle(Vehicle v) {
        for (Row row : rows) {
            List<Spot> spots = row.findConsecutiveSpots(v);
            if (spots != null) return spots;
        }
        return null;
    }
}
