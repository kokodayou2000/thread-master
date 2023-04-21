package deadLock;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadLock_ThreadMXBean {
    private static Object lockA = new Object();
    private static Object lockB = new Object();


    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (true){
                synchronized (lockA){
                    System.out.println("我得到了LockA，我想要获取B");
                    synchronized (lockB){
                        System.out.println("我得到A又得到了B");
                    }
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                synchronized (lockB){
                    System.out.println("我得到了LockB，我想要获取A");
                    synchronized (lockA){
                        System.out.println("我得到B又得到了A");
                    }
                }
            }
        }).start();

        Thread.sleep(1000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        //获取陷入死锁的线程
        for (long deadlockedThread : deadlockedThreads) {
            //通过id获取实例
            ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThread);
            System.out.println("获取死锁名称： "+threadInfo.getThreadName());


        }



    }

}
