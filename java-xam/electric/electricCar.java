package electric;

import vehicle.Vehicle;

public class electricCar extends Vehicle {

    private double batteryCapacity;

    public electricCar(String make, String model, double batteryCapacity) {
        super(make, model);
        this.batteryCapacity = batteryCapacity;
    }

    public void display() {
        super.display();
        System.out.println("Battery capacity: " + batteryCapacity);
    }
}