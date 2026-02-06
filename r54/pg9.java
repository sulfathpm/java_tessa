import java.util.*;
interface Calculate{
    Scanner sc=new Scanner(System.in);
    public void area();
    public void perimter();
}

class Circle implements Calculate{
    
    int radius;
    Circle(){
        System.out.println("Radius ?");
        radius=sc.nextInt();
    }
    public void area(){
        System.out.println("area : "+3.14*radius*radius);
    }
    public void perimter(){
        System.out.println("perimeter : "+3.14*radius*2);
    }
}

class Rectangle implements Calculate{
   int length,width;
    Rectangle(){
        System.out.println("length,width ?");
        length=sc.nextInt();
        width=sc.nextInt();

    }
    public void area(){
        System.out.println("area : "+length*width);
    }
    public void perimter(){
        System.out.println("perimeter : "+(length+width)*2);
    }
}


public class pg9{
    public static void main(String[] args) {
        
    Scanner sc=new Scanner(System.in);
    Calculate c1;
    int ch=1;
    while(ch!=0){
        System.out.println("1. Area and peirmter of circle \n2. Area and perimter of rectrangle\n0.exit\nchoose one.");
        ch=sc.nextInt();
        switch (ch) {
            case 1:
                c1=new Circle();
                c1.area();
                c1.perimter();
                break;
            case 2:
                c1=new Rectangle();
                c1.area();
                c1.perimter();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.print("invalid chopice");
                break;
        }
        }
    }
}
