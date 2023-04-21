package deadLock;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class LiveLock {
    @Data
    @AllArgsConstructor
    static class Spoon{
        private Diner owner;

        public synchronized void use(){
            System.out.printf("%s 吃饭",owner.name);
        }
    }
    @AllArgsConstructor
    @Data
    static class Diner{
        private String name;
        private boolean isHungry;
        public void eatWith(Spoon spoon,Diner spouse){
            while (isHungry){
                if (spoon.owner != this){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    continue;
                }
                if (spouse.isHungry){
                    System.out.println(name+" 对方先吃饭");
                    //讲勺子塞给对方
                    spoon.setOwner(spouse);
                    continue;
                }
                spoon.use();
                isHungry =false;
                System.out.println(name + " 用餐完毕");
                spoon.setOwner(spouse);

            }
        }
    }

    public static void main(String[] args) {
        Diner p1 = new Diner("p1",true);
        Diner p2 = new Diner("p2",true);
        //先把勺子给某个人
        Spoon spoon = new Spoon(p1);
        new Thread(()->{
            p1.eatWith(spoon,p2);
        }).start();
        new Thread(()->{
            p2.eatWith(spoon,p1);
        }).start();

    }
}
