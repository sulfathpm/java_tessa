import java.util.*;
class Stud{
    int rollno;
    String name;
    float mark;
    public Stud(){
        this.rollno=0;
        this.name="unknown";
        this.mark=50;
    }
    public Stud(int rollno,String name,float mark){
        this.rollno=rollno;
        this.name=name;
        this.mark=mark;
    }
    public Stud(Stud other){
        this.rollno=other.rollno;
        this.name=other.name;
        this.mark=other.mark;
    }
}

class Student{
    public static void main(String args[]){
        Stud s[]=new Stud[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){ 
                s[i]=new Stud();
                System.out.println("Enter rollno,name,mark ("+(i+1)+"):");
                s[i].rollno=sc.nextInt();
                s[i].name=sc.next();
                s[i].mark=sc.nextFloat();
        }
        System.out.println("Total number of students:"+n);
        sortRank(s,n);
        System.out.println("Rank\tRoll no\tName\tMark");
        for(int i=0;i<n;i++){

            System.out.println((i+1)+".\t "+s[i].rollno+"\t"+s[i].name+"\t"+s[i].mark);
        }
    }
    public static void sortRank(Stud s[],int n){
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(s[i].mark<s[j].mark){
                        Stud t=s[i];
                        s[i]=s[j];
                        s[j]=t;
                    }
                }
            }
    }
}