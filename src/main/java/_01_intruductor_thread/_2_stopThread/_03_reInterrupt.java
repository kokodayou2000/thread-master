package _01_intruductor_thread._2_stopThread;

import java.sql.Time;

public class _03_reInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("中断执行了");
                    break;
                }
                reInterrupt();
            }

        });

        thread.start(); //execute
        Thread.sleep(1000);
        thread.interrupt(); //interrupt
    }

    private static void reInterrupt() {
        try {
            Thread.sleep(1000); //sleep状态下中断会抛出异常
        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt(); //再次执行中断
            throw new RuntimeException(e);
        }

    }
}
