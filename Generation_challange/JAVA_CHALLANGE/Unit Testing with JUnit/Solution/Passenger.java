public class Passenger {
    private final String id;
    private final String name;
    private double fare;
    private boolean isInTrip;

    public Passenger(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public boolean isInTrip() {
        return isInTrip;
    }

    public void startTrip() {
        isInTrip = true;
    }

    public void endTrip() {
        isInTrip = false;
    }
}
