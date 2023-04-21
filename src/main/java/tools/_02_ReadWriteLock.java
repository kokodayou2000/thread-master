package tools;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class _02_ReadWriteLock {
    //读写锁
    //当执行读命令的时候，可以多线程执行
    //当执行写命令的时候，只能单线程执行

    static ReadWriteLock readWriteLock =  new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    static String value = "init";


    //每次执行读命令会花费 0.5S，每次执行写命令会花费1s
    //当要执行7次读命令，3次写命令的时候，能优化多少秒?
    //先执行2次读，在执行2次写 ，执行5次读，执行1次写
    public static void read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(500);
            System.out.println("read success "+value);
            lock.unlock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(Lock lock,String v){
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write success value = "+value);
            lock.unlock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(()->read(readLock)).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(()->write(writeLock,"value ")).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(()->read(readLock)).start();
        }

        new Thread(()->write(writeLock,"end")).start();




    }
}
