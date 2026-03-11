import java.util.Scanner;

class OutOfStockException extends RuntimeException{
    public OutOfStockException(String message){
        super(message);
    }
}
class product{
    int stockq;
    String prod_name;
    product(int stockq,String prod_name){
        this.stockq = stockq;
        this.prod_name = prod_name;
    }
    void purchase(int quantity){
        if(quantity<=0){
            throw new IllegalArgumentException("quantity must be positive");
        }
        if(quantity>stockq){
            throw new OutOfStockException("Choose a lsser quantity");
        }
        stockq=stockq-quantity;
        System.out.println("purchase successful\nRem stck :"+stockq);
    }
}
public class pg22 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter prod name?");
        String name=sc.nextLine();
        System.out.println("Enter stock quantity?");        
        int stock=sc.nextInt();
        product p=new product(stock, name);
        System.out.println("Enter the purchase quautiy?");
        int q=sc.nextInt();
        try{
            p.purchase(q);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch(OutOfStockException e){
            System.out.println(e.getMessage());
        }
    }
}
