package question1;

public class _04_singleton {
    //双重检查需要保证可见性和禁止重排序，因为java在创建对象的过程中会有很多步骤
    //1.在内存中创建，2.初始化数据，3.将对象指向内存
    //如果先执行1再执行3,就可能将未初始化的值交给对方
    private volatile static Object INSTANCE;


    private _04_singleton(){}

    public static Object getInstance(){
        if (INSTANCE == null){
            synchronized (_04_singleton.class){
                if (INSTANCE == null){
                    INSTANCE = new Object();
                }
            }
        }
        return INSTANCE;
    }


}
