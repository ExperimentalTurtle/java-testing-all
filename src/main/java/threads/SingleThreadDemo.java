package threads;

public class SingleThreadDemo {
    public static void main(String[] args) {
        Thread th = new Thread(new MyRunnableThread(), "Another thread");
        // start thread not code
        th.start();


        int sum = 1;
        for (int i = 1; i < 13; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + " -> Sum = " + sum);
    }
}
