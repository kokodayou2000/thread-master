package _01_intruductor_thread._1_createthreads.some;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreateByCallable {
    public static void main(String[] args) throws Exception {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                return "success";
            }
        };

        System.out.println(Executors.newCachedThreadPool().submit(callable).get());


    }
}
