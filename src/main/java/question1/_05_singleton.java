package question1;

public class _05_singleton {
    private static Object INSTANCE;

    private _05_singleton(){}

    public static Object getInstance(){
        return Inner.INSTANCE;
    }
    private static class Inner{
        private static Object INSTANCE = new Object();
    }


}
