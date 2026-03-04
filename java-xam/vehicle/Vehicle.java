package vehicle;

public class Vehicle implements Displayable {

    protected String make, model;
    public static int vehicleCount = 0;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
        vehicleCount++;
    }

    public static int getVehicleCount() {
        return vehicleCount;
    }

    public void display() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
    }
}