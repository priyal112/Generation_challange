import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DriversManagerTest {

    @Test
    public void testAddPassenger() {
        DriversManager manager = new DriversManager();
        Passenger passenger = new Passenger("P001", "John Doe");
        manager.addPassenger(passenger);
        assertEquals(passenger, manager.getPassenger("P001"));
    }

    @Test
    public void testAddDriver() {
        DriversManager manager = new DriversManager();
        Driver driver = new Driver("D001", "Jane Smith", 0.1);
        manager.addDriver(driver);
        assertEquals(driver, manager.getDriver("D001"));
    }

    @Test
    public void testStartTrip() {
        DriversManager manager = new DriversManager();
        Passenger passenger = new Passenger("P001", "John Doe");
        Driver driver = new Driver("D001", "Jane Smith", 0.1);
        manager.addPassenger(passenger);
        manager.addDriver(driver);

        manager.startTrip("P001", "D001");

        assertTrue(passenger.isInTrip());
        assertFalse(driver.isAvailable());
    }

    @Test
    public void testEndTrip() {
        DriversManager manager = new DriversManager();
        Passenger passenger = new Passenger("P001", "John Doe");
        Driver driver = new Driver("D001", "Jane Smith", 0.1);
        manager.addPassenger(passenger);
        manager.addDriver(driver);

        manager.startTrip("P001", "D001");
        manager.endTrip("P001", "D001", 10.0); // Assuming distance traveled is 10.0

        assertFalse(passenger.isInTrip());
        assertTrue(driver.isAvailable());
        assertEquals(1.0, driver.getTotalDistanceTraveled(), 0.0001); // Assuming driver's fee is 0.1 per unit distance
        assertEquals(1.0, driver.getBalance(), 0.0001);
    }

    @Test
    public void testFindNextAvailableDriver() {
        DriversManager manager = new DriversManager();
        Driver driver1 = new Driver("D001", "Jane Smith", 0.1);
        Driver driver2 = new Driver("D002", "John Doe", 0.1);
        Driver driver3 = new Driver("D003", "Alice Johnson", 0.1);
        manager.addDriver(driver1);
        manager.addDriver(driver2);
        manager.addDriver(driver3);

        assertEquals("D001", manager.findNextAvailableDriver());

        manager.startTrip("P001", "D001");
        manager.endTrip("P001", "D001", 10.0);

        assertEquals("D002", manager.findNextAvailableDriver());
    }
}
