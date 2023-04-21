package _01_intruductor_thread._1_createthreads;

public class _02_createByThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+" create by thread");
    }

    public static void main(String[] args) {
        new _02_createByThread().start();
        System.out.println(Thread.currentThread().getName()+ " thread");
    }

}
