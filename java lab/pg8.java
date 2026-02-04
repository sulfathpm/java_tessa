import java.util.Scanner;

class Vehicle{
    String Model,Company;
    Vehicle(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Model,Company?");
        Model=sc.next();
        Company=sc.next();
    }
    void display(){
        System.out.println("Model;"+Model+"\nCompany:"+Company);
    }
}

class Car extends Vehicle{
    String fuelType;
    int no_of_doors;
    Car(){
        Scanner sc=new Scanner(System.in);
        System.out.println("no of doors,fuel type?");
        no_of_doors=sc.nextInt();
        fuelType=sc.next();
    }
    void display(){
        super.display();
        System.out.println("No of doors : "+no_of_doors+"\nfuel type: "+fuelType);

    }
}

class Electric extends Vehicle {
    int batteryCapactiy;
    Electric(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Battery capacity ? ");
        batteryCapactiy=sc.nextInt();
    }
    void display(){
        super.display();
        System.out.println("Batter capacity : "+batteryCapactiy);
    }
}

public class pg8 {
    public static void main(String[] args) {
        Vehicle v;
        v=new Car();
        v.display();
        v=new Electric();
        v.display();
    }
}
