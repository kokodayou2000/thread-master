package question1;

import java.util.concurrent.ConcurrentHashMap;

public class _07_singleton {
    //容器的单例模式
    private static ConcurrentHashMap<String,Object> ioc = new ConcurrentHashMap<String,Object>();

    public static Object getInstance(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        synchronized (ioc){
            Object obj = null;
            if (!ioc.contains(className)){
                obj = Class.forName(className).newInstance();
                ioc.put(className,obj);
                return obj;
            }else {
                return ioc.get(obj);
            }

        }

    }

}
