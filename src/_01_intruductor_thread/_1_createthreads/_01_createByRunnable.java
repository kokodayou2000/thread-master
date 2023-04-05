package _01_intruductor_thread._1_createthreads;

public class _01_createByRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" create by runnable");
    }

    public static void main(String[] args) {
        _01_createByRunnable runnable = new _01_createByRunnable();

        new Thread(runnable).start();

        System.out.println(Thread.currentThread().getName()+"  thread");
    }
}
