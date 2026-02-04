import java.util.*;

class Animals{
    private String species;
    protected int age;
    protected float weight;
    String color;
   
    Animals(){
        Scanner sc=new Scanner(System.in);
        System.out.println("species,age,weight?");
        species=sc.next();
        age=sc.nextInt();
        weight=sc.nextFloat();
    }

    Animals(String species,int age,float weight){
        this.species=species;
        this.age=age;
        this.weight=weight;
    }

    Animals(Animals other){
        this.species=other.species;
        this.age=other.age;
        this.weight=other.weight;
    }

    void display(){
        System.out.println("species : "+species+"\nage:"+age+"\nweight : "+weight);
    }
}

class Dog extends Animals{
    String breed,name,owner;
    Dog(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Breed ,name,owner?");
        breed=sc.next();
        name=sc.next();
        owner=sc.next();
    }
    void display(){
        System.out.println("breed :"+breed+"\nname: "+name+"\nowner : "+owner);
        super.display();
    }

}

class Cat extends Animals{
    String name,eyeColor;
    float tailLength;
    Cat(){
        System.out.println("Name,eyeclr,tail length?");
        Scanner sc=new Scanner(System.in);
        name=sc.next();
        eyeColor=sc.next();
        tailLength=sc.nextFloat();
    }
    void display(){
        System.out.println("name:"+name+"\neye color:"+eyeColor+"\ntail length: "+tailLength);
        super.display();
    }
}

public class pg7{
    public static void main(String[] args) {
        Animals a;
        a=new Dog();
        a.display();
        a=new Cat();
        a.display();
    }
}