package question1;

public class _01_singleton {
    //饿汉
    private static final Object INSTANCE = new Object();

    private _01_singleton(){}

    public Object getInstance(){
        return INSTANCE;
    }

}
