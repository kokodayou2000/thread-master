package question1;

public class _03_singleton {
    //hungry
    private static Object INSTANCE;

    private _03_singleton(){}

    public static Object getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new Object();
        }
        return INSTANCE;
    }


}
