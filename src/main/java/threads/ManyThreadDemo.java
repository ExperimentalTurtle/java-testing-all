package threads;

public class ManyThreadDemo {
    public static void main(String[] args) {
        Runnable logic = () -> {
            int sum = 1;
            for (int i = 1; i < 100_000; i++) {
                if (i % 20_000 == 0) {
                    System.out.println(Thread.currentThread().getName() + " -> I = " + i);
                }
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + " -> Sum = " + sum);
        };

        Thread th1 = new Thread(logic, "Another thread 1");
        Thread th2 = new Thread(logic, "Another thread 2");
        th1.setDaemon(true);
        th2.setDaemon(true);
        th1.setPriority(Thread.MAX_PRIORITY);

        // start thread not code
        th1.start();
        th2.start();

        try {
//            th1.join(5);
            Thread.sleep(10);
        } catch (InterruptedException ignored) {}

        System.out.println("Main method has done working");
    }
}
