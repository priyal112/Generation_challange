public class Driver {
    private final String id;
    private final String name;
    private final double fee;
    private double balance;
    private boolean isAvailable;
    private double totalDistanceTraveled;

    public Driver(String id, String name, double fee) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFee() {
        return fee;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void startTrip() {
        isAvailable = false;
    }

    public void endTrip(double distanceTraveled) {
        isAvailable = true;
        double tripFare = fee * distanceTraveled;
        balance += tripFare;
        totalDistanceTraveled += distanceTraveled;
    }

    public double getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }
}
