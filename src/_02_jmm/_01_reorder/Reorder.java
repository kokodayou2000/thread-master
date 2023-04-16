package _02_jmm._01_reorder;

/**
 * 指令重排序
 */
public class Reorder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        while (true) {
            x=0;
            y=0;
            a=0;
            b=0;

            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            if (x == 0 && y == 0){
                System.out.println("x = " + x+" y = " +y);

                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000);

    }

}
