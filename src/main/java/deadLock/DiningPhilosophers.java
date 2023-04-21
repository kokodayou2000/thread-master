package deadLock;

import java.util.Formatter;
import java.util.Random;

//哲学家就餐问题
public class DiningPhilosophers {
    public static class Philosophers implements Runnable{
        private Object leftChopstick;
        private Object rightChopstick;

        public Philosophers(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }
        @Override
        public void run() {
            while (true){
                //思考
                doAction("思考");
                synchronized (leftChopstick){
                    //拿去左边筷子
                    doAction("拿左边的筷子");
                    synchronized (rightChopstick){
                        //拿去右边筷子
                        doAction("拿右边的筷子");
                        //吃饭
                        doAction("吃饭");
                    }
                    doAction("放下右边的筷子");
                }
                doAction("放下了所有筷子");
            }

        }
        Random random = new Random(10);
        private void doAction(String action)  {
            System.out.println(Thread.currentThread().getName()+" " +action);
            try {
                Thread.sleep((long) (random.nextDouble()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Philosophers[] philosophers = new Philosophers[5];
        Object[] chopsticks = new Object[philosophers.length];
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] =  new Object();
        }
        for (int i = 0; i < philosophers.length; i++) {
            Object leftChopstick = chopsticks[i];
            Object rightChopstick;
            //第五个哲学家右边的筷子是第一个哲学家的
            if (i == 4){
                rightChopstick = chopsticks[0];
            }else {
                rightChopstick = chopsticks[i+1];
            }
            //交换顺序策略
            if (i == 4){
                philosophers[i] = new Philosophers(rightChopstick, leftChopstick);
            }else{
                philosophers[i] = new Philosophers(leftChopstick, rightChopstick);
            }
        }
        for (int i = 0; i < philosophers.length; i++) {
            new Thread(philosophers[i],String.format("第%d哲学家",i+1)).start();
        }


    }
}
