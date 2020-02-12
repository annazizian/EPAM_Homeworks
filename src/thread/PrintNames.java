package thread;

public class PrintNames extends Thread {
    private static int number = 1;
    private int remainder;
    private static final Object lock = new Object();

    PrintNames(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        int PRINT_COUNT = 20;
        while (number < PRINT_COUNT) {
            synchronized (lock) {
                while (number % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName());
                number++;
                lock.notifyAll();
            }
        }
    }
}