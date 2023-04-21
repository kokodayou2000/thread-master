package _02_jmm._01_reorder;

public class Join_demo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t2");

        t1.start();
        t2.start();
        Thread.sleep(400);
        t1.join();
        t2.join();


    }
}
