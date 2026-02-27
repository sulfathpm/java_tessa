import java.util.*;
interface showable {
    public void show();
}
class Person{
    String name,gender,phn;
    Person(){
        System.out.println("enter name,gender,phn?");
        Scanner sc=new Scanner(System.in);
        name=sc.next();
        sc.nextLine();
        gender=sc.next();
        sc.nextLine();
        phn=sc.nextLine();
    } 
}

class Student extends Person{
    String course;
    int score;
    Student(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter course ,score?");
        course=sc.nextLine();
        score=sc.nextInt();
    }
}

class Pgstudent extends Student implements showable{
    String rarea,guide;
    int rank;
    Pgstudent(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter rarea,guide?");
        rarea=sc.nextLine();
        guide=sc.nextLine();
        
    }
    public void show(){
            System.out.println("Rank:"+rank+" Name :"+name+" Course : "+course+" score:"+score+" research-area:"+rarea);
        }
}

public class pg13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of pg students:");
        int n=sc.nextInt();
        Pgstudent p[]=new Pgstudent[n];
        for(int i=0;i<n;i++){
        System.out.println("\nStudent "+(i+1)+":");
        p[i]=new Pgstudent();    
    }
    for (int i = 0; i < n; i++) {
        for (int j = i+1; j < n; j++) {
            if(p[i].score<p[j].score){
                Pgstudent temp=p[i];
                p[i]=p[j];
                p[j]=temp;
            }
        }
    }
    for(int i=0;i<n;i++){
        p[i].rank=i+1;
    }
    System.out.println("Sorted by score : ");
    for (int i = 0; i < n; i++) {
        p[i].show();
    }
    for (int i = 0; i < n; i++) {
        for (int j = i+1; j < n; j++) {
            if(p[i].rarea.compareToIgnoreCase(p[j].rarea)>0){
                Pgstudent temp=p[j];
                p[j]=p[i];
                p[i]=temp;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        p[i].rank = i + 1;
    }
    System.out.println("Sorted by research area : ");
    for (int i = 0; i < n; i++) {
        p[i].show();
    }
    }
}
