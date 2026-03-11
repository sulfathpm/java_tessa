import java.util.Scanner;

class NegException extends Exception{
    public NegException(String message){
        super(message);
    }
}
class sample{
   public static void CheckNeg(int x) throws NegException{
    if(x<0){
        throw new NegException("Negative number not allowed");
    }
}
}
public class pg21 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int count=0;
        System.out.println("n?");
        int n=sc.nextInt();            
        int x[]=new int[n];
        System.out.println("Elements?");
        for(int i=0;i<n;i++){
            x[i] = sc.nextInt();
           try{
            sample.CheckNeg(x[i]);
            sum=sum+x[i];
            count++;
           }
           catch(NegException e){
            System.out.println("Exception :"+e.getMessage());
           }
            
        }
        System.out.println("average is: "+(sum/count));
    }
}
