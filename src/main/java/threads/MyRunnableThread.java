package threads;

public class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 100_100; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + " -> Sum = " + sum);
    }
}
