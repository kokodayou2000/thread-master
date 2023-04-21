package tools;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class _01_ReentLock {
    //可重入锁
    public void sleep1S(int i){
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void l1(){
        for (int i = 0; i < 4; i++) {
            sleep1S(1);
            System.out.println(i);
            if (i == 2){
                l2();
            }
        }
    }
    public synchronized void l2() {
        System.out.println("get inner Lock");
        sleep1S(Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

        _01_ReentLock lock = new _01_ReentLock();

        new Thread(lock::l1).start();
//        lock.sleep1S();
//        new Thread(lock::l2).start();

    }


}
