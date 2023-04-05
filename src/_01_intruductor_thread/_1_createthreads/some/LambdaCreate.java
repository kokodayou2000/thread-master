package _01_intruductor_thread._1_createthreads.some;

public class LambdaCreate {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" ");
        }).start();
    }
}
