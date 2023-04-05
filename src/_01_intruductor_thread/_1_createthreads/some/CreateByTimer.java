package _01_intruductor_thread._1_createthreads.some;

import java.util.Timer;
import java.util.TimerTask;

public class CreateByTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //1s执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }
}
