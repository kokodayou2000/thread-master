package question1;

public class _02_singleton {
    //懒汉2
    private static final Object INSTANCE;
    static {
        INSTANCE = new Object();
    }
    private _02_singleton(){}

    public Object getInstance(){
        return INSTANCE;
    }

}
