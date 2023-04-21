package _02_jmm._01_reorder;


import sun.misc.Contended;

/**
 * 可见性
 */

public class FieldVisibility {

    int a = 1;
    int b = 2;

    private void change(){
        a = 3;
        b = a; //b = 3; 都行
    }

    private void print(){
        if (a == 1 && b == 3 ){
            System.out.println("a = "+ a+ " b = "+b);

        }
    }
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            FieldVisibility visibility = new FieldVisibility();
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                visibility.change();
            }).start();
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                visibility.print();

            }).start();


        }

    }

}
