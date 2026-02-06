import java.util.*;
interface measurable{
    Scanner sc=new Scanner(System.in);
    public void volume();
}
interface printable{
    Scanner sc=new Scanner(System.in);
    public void display();
}

class Rectangle {
    public double length,width;
    
}

class Cuboid extends Rectangle implements printable,measurable{
    int height;

    public void display(){
        System.out.println("length : "+length+"\nwidth: "+width+"\nHeigth : "+height);
    }
    public void volume(){
        System.out.println("Volume : "+length*height*width);
    }
}

public class pg10{
    public static void main(String[] args) {
        
    }
}