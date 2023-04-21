package tools;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class _05_CyclicBarrier {
    public static void main(String[] args) {
        //需求：有1000个线程，每个线程有一个自己的随机数，需要每10个线程记录其随机数之和
        //一共打印10个结果，每个结果都是10个随机数之和
        //cycleBarrier无法做到
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,()->{
            System.out.println("end");
        });

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                int nextInt = new Random().nextInt(100);
                int res = 0;
                for (int j = 0; j < nextInt; j++) {
                    res+=j;
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }


    }
}
