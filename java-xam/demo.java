import java.util.Scanner;
import vehicle.Vehicle;
import car.Car;
import electric.electricCar;

public class demo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter max number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        Vehicle[] v = new Vehicle[n];
        int count = 0;

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Car");
            System.out.println("2. Add Electric Car");
            System.out.println("3. Display Vehicles");
            System.out.println("4. Total Vehicles");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    if (count < n) {
                        System.out.print("Enter brand: ");
                        String brand = sc.nextLine();

                        System.out.print("Enter model: ");
                        String model = sc.nextLine();

                        System.out.print("Enter number of doors: ");
                        int doors = sc.nextInt();
                        sc.nextLine();

                        v[count++] = new Car(brand, model, doors);
                        System.out.println("Car added!");
                    } else {
                        System.out.println("Array is full!");
                    }
                    break;

                case 2:
                    if (count < n) {
                        System.out.print("Enter brand: ");
                        String brand = sc.nextLine();

                        System.out.print("Enter model: ");
                        String model = sc.nextLine();

                        System.out.print("Enter battery capacity: ");
                        int battery = sc.nextInt();
                        sc.nextLine();

                        v[count++] = new electricCar(brand, model, battery);
                        System.out.println("Electric Car added!");
                    } else {
                        System.out.println("Array is full!");
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No vehicles to display!");
                    } else {
                        System.out.println("\n--- Vehicle Details ---");
                        for (int i = 0; i < count; i++) {
                            v[i].display(); // polymorphism
                        }
                    }
                    break;

                case 4:
                    System.out.println("Total vehicles created: " + Vehicle.vehicleCount);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
}