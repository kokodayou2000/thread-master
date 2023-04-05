package _01_intruductor_thread._2_stopThread;

import javax.swing.plaf.TableHeaderUI;

/**
 * 在有sleep的时候停止线程
 */
public class _02_RightWayStopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int num = 0;
            while (num < 300 ){
                if (num % 100 == 0){
                    System.out.println(num);
                }
                if (Thread.interrupted()){
                    System.out.println("interrupt");
                    break;
                }
                num++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        );
        thread.start();
        Thread.sleep(200); //会在中断的时候，执行interrupt
        thread.interrupt(); //清除标记位


    }
}
