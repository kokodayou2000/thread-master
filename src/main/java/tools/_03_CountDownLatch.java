package tools;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class _03_CountDownLatch {
    //使用10个，每个线程计算!10000
    public static void main(String[] args) throws InterruptedException {
        useCountDownLatch();
    }
    volatile static Integer result = 0;

    public static void useCountDownLatch() throws InterruptedException {
        Thread[] threads = new Thread[10];
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(()->{
                int nextInt = new Random().nextInt(10000);
                int res = 0;
                for (int j = 0; j < nextInt; j++) {
                   res+=j;
                }
                synchronized (_03_CountDownLatch.class){
                    result += res;
                }
                countDownLatch.countDown();
                System.out.println("随机数是："+nextInt+" !nextInt = "+res);
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        //当前线程等待
        countDownLatch.await();


        System.out.println("end ");
        System.out.println("result = "+result);
    }


}
