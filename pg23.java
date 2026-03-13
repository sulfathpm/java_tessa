class ThreadA extends Thread{
    public void run(){
        System.out.println("Squares of numbers from 1 to 10:");
        try{
            for(int i=1;i<=10;i++){
                System.out.println(i+"*"+i+"="+(i*i));
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ThreadB implements Runnable{
    public void run(){
        System.out.println("cubes of numbers from 1 to 10 :");
        try{
            for(int i=1;i<=10;i++){
                System.out.println("cube("+i+") = "+Math.pow(i,3));
                Thread.sleep(700);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class pg23 {
    public static void main(String[] args) throws InterruptedException{
        ThreadA a=new ThreadA();
        // Thread b = new Thread(new ThreadB());
        ThreadB t=new ThreadB();
        Thread b=new Thread(t);
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println("execution has completed");
    }
}
