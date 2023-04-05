package _01_intruductor_thread._2_stopThread;

import java.sql.SQLOutput;

public class _04_getInterruptFlag {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {

            }
        });

        t1.start();
        t1.interrupt();

        //t1 的中断位
        System.out.println("t1 interrupted "+t1.isInterrupted());
        //实际上是获取main的，那个线程执行的就是那个线程的中断位
        System.out.println("main interrupt "+t1.interrupted());
        // 也是main的
        System.out.println("main interrupt "+Thread.interrupted());
        //t1 的中断位
        System.out.println("t1 interrupted "+t1.isInterrupted());

    }

}
