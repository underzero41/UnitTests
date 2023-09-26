package seminars.second.hw;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car = new Car("Toyota", "Camry", 1994 );
    Motorcycle motorcycle = new Motorcycle("Yamaha", "RBZ", 1993);
    @Test
    void carInstanceIsVehicleInstance(){
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void carHasFourWheels() {
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void motorcycleHasTwoWheels() {
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    public void carTestDriveSetsSpeedTo60() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    public void motorcycleTestDriveSetsSpeedTo75() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    public void carParkSetsSpeedToZero() {
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    public void motorcycleParkSetsSpeedToZero() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}