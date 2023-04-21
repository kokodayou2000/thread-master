package _01_intruductor_thread._2_stopThread;

/**
 * 在没用sleep的时候停止线程
 */
public class _01_RightWayStopThreadWithoutSleep  implements Runnable{


    @Override
    public void run() {
        Integer num = 0;
        while (num<=Integer.MAX_VALUE / 2){
            if (num % 1000 == 0){
                System.out.println("是1w的倍数 "+num);
            }
            if (Thread.interrupted()){
                System.out.println("is interrupted "+num);
                break;
            }
            num++;
        }
        System.out.println(Thread.currentThread().getName()+" end");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new _01_RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(100); //100ms sleep
        thread.interrupt();

    }
}
