import java.util.Scanner;

class geometry{
    void area(int l,int b){
        System.out.println("area of rectangle : "+(l*b));
    }

    void area(int a){
        System.out.println("area of square : "+(a*a));
    }
    void area(double r){
        System.out.println("area of circle : "+(2*3.14*r));
    }
}

public class geometry1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length and breadth");
        int l=sc.nextInt();
        int b=sc.nextInt();
        geometry g=new geometry();
        g.area(l, b);
        System.out.println("Enter length of square : ");
        int x=sc.nextInt();
        g.area(x);
        System.out.println("Enter radius of circle : ");
        double r=sc.nextDouble();
        g.area(r);
    }
}
