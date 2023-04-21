package question1;

public enum  _06_singleton {
    INSTANCE;
    private _06_singleton(){}
    private Object data;

    public void setData(Object data){
        this.data = data;
    }

    public Object getData(){
        return data;
    }

}
