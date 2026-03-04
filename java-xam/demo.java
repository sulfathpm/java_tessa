import vehicle.vehicle;
import car.car;
import electric.electricCar;
public class demo {
    public static void main(String[] args) {
        car c1=new car("totyota","corolla",4);
        electricCar e1=new electricCar("tesla","model 3",75);
        c1.dispaly();
        e1.dispaly();
        System.out.println("total vehiucle created:"+vehicle.vehicleCount);
    }
}
