import java.util.Scanner;

class Person{
    int age;
    String name,gender,address;
    Person(){
        Scanner sc=new Scanner(System.in);
        System.out.println("name,gender,age,address?");
        name=sc.next();
        gender=sc.next();
        age=sc.nextInt();
        address=sc.next();
    }
    void displayPerson(){
        System.out.println("name: "+name+"\ngemder : "+gender+"\nage: "+age+"address: "+address);
    }
}

class Employee extends Person{
    int empid,salary;
    String company_name,qualification;
    Employee(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Empid,company name,qualification,salary ? ");
        empid=sc.nextInt();
        salary=sc.nextInt();
        company_name=sc.next();
        qualification=sc.next();
    }
    void displayEmployee(){
        System.out.println("Emp id:"+empid+"\ncompany name:"+company_name+"qualification :"+qualification+"");
    }
}

public class pg9 {
    public static void main(String[] args) {
        
    }
}
