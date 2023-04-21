package deadLock;

/**
 * jps
 * jstack pid
 */
public class DeadLock_Demo {
    private static Object lockA = new Object();
    private static Object lockB = new Object();


    public static void main(String[] args) {
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
    }

}
