package _01_intruductor_thread._1_createthreads.some;

import java.util.concurrent.*;

public class CreateByTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(5000);
            return 1000;
        }); //new Callable () { Integer call();}

        Thread thread = new Thread(task);
        thread.start();


        System.out.println(task.isDone());
        System.out.println(task.get()); //阻塞
        System.out.println(task.isDone());
    }
}
