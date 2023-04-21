package _02_jmm._01_reorder;

public class Volatile_Demo {
    volatile static boolean flag = true;
    public static void main(String[] args) {

        while (true){

            Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                flag = !flag;
            }
            });
            t1.start();
            System.out.println(flag);
        }
    }
}
