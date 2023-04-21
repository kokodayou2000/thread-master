package deadLock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDeadLock implements Runnable{
    static Lock l1 = new ReentrantLock();
    static Lock l2 = new ReentrantLock();

    boolean flag = true;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (flag){
                try {
                    Thread.sleep(new Random().nextInt(20));
                    if (l1.tryLock(800, TimeUnit.MILLISECONDS)) {
                        Thread.sleep(new Random().nextInt(20));
                        if (l2.tryLock(800, TimeUnit.MILLISECONDS)) {
                            Thread.sleep(new Random().nextInt(20));
                            System.out.println("线程一获取到了两把锁");
                            l2.unlock();
                            l1.unlock();
                            break;
                        }else{
                            System.out.println("线程2获取锁失败，已重试");
                            l1.unlock();
                        }
                    }else{
                        System.out.println("线程1获取锁失败，已重试");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                try {
                    Thread.sleep(new Random().nextInt(20));
                    if (l2.tryLock(800, TimeUnit.MILLISECONDS)) {
                        Thread.sleep(new Random().nextInt(20));
                        if (l1.tryLock(800, TimeUnit.MILLISECONDS)) {
                            Thread.sleep(new Random().nextInt(20));
                            System.out.println("线程一获取到了两把锁");
                            l1.unlock();
                            l2.unlock();
                            break;
                        }else{
                            System.out.println("线程1获取锁失败，已重试");
                            l2.unlock();
                        }
                    }else{
                        System.out.println("线程2获取锁失败，已重试");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        TryLockDeadLock r1 = new TryLockDeadLock();
        TryLockDeadLock r2 = new TryLockDeadLock();
        r1.flag = true;
        r2.flag = false;
        new Thread(r1).start();
        new Thread(r2).start();


    }
}
