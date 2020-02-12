package thread;

public class PrintNames extends Thread {
    public final int PRINT_COUNT = 20;
    static int number = 1;
    int remainder;
    static final Object lock = new Object();

    PrintNames(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_COUNT - 1) {
            synchronized (lock) {
                while (number % 3 != remainder) { // wait for numbers other than remainder
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