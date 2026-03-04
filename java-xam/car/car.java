package car;

import vehicle.Vehicle;

public class Car extends Vehicle {

    private int doors;

    public Car(String make, String model, int doors) {
        super(make, model);
        this.doors = doors;
    }

    public void display() {
        super.display();
        System.out.println("Number of doors: " + doors);
    }
}