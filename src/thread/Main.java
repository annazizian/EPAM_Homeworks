package thread;

public class Main {
    public static void main(String[] args) {

        PrintNames runnable1=new PrintNames(1);
        PrintNames runnable2=new PrintNames(2);
        PrintNames runnable3=new PrintNames(0);

        Thread t1=new Thread(runnable1,"Anna");
        Thread t2=new Thread(runnable2,"Lidia");
        Thread t3=new Thread(runnable3,"Vazgen");

        t1.start();
        t2.start();
        t3.start();
    }
}