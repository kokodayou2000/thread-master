package tools;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class _04_Phaser {
    //阶段
    //模拟一种行为，这个行为有不同的状态，但是必须每种状态都完成之后，才会进行下一个状态
    static Random random = new Random();
    void sleepS(int i) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(i);
    }
    //天黑请闭眼
    //狼人请睁眼
    //预言家睁眼
    //女巫请睁眼
    //天亮了
    static Wolf wolf = new Wolf();
    public static void main(String[] args) {
        wolf.bulkRegister(6);
        Person[]  p= new Person[6];
        p[0] = new Person("平民");
        p[1] = new Person("平民");
        p[2] = new Person("狼人");
        p[3] = new Person("狼人");
        p[4] = new Person("女巫");
        p[5] = new Person("预言家");
        for (int i = 0; i < 6; i++) {
            new Thread(p[i]).start();
        }
    }
    static class Wolf extends Phaser{
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase){
                case 0:
                    System.out.println("天黑请闭眼 "+registeredParties);
                    return false;
                case 1:
                    System.out.println("狼人请杀人 "+registeredParties);
                    return false;
                case 2:
                    System.out.println("预言家选择角色 "+registeredParties);
                    return false;
                case 3:
                    System.out.println("女巫选择技能 "+registeredParties);
                    return false;
                case 4:
                    System.out.println("天亮了 "+registeredParties);
                    return false;
                default:
                    return true;
            }
        }
    }
    static class Person implements Runnable{
        String name;
        public Person(String name){this.name = name;}

        public void p1(){
            System.out.println(name + " 闭眼了");
            wolf.arriveAndAwaitAdvance();
        }
        public void p2(){
            if (Objects.equals(name, "狼人")){
                System.out.println(name + " 睁眼了");
            }
            wolf.arriveAndAwaitAdvance();
        }
        public void p3(){
            if (Objects.equals(name, "女巫")) {
                System.out.println(name + " 睁眼了");
            }
            wolf.arriveAndAwaitAdvance();
        }
        public void p4(){
            if (Objects.equals(name, "预言家")){
                System.out.println(name + " 睁眼了");
            }
            wolf.arriveAndAwaitAdvance();
        }
        public void p5(){
            System.out.println(name + "天亮了");
            wolf.arriveAndAwaitAdvance();
        }

        @Override
        public void run() {
            p1();
            p2();
            p3();
            p4();
            p5();
        }
    }

}
