package thread;

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(new PrintNames(1), "Anna");
        Thread t2 = new Thread(new PrintNames(2), "Lidia");
        Thread t3 = new Thread(new PrintNames(0), "Vazgen");

        t2.start();
        t1.start();
        t3.start();
    }
}