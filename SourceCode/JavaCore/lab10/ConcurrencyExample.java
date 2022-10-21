import java.util.ArrayList;
import java.util.List;

import System.out.println;

public class ConcurrencyExample {
    public static void addData(List list) {
        while(true){
            int random = (int)(Math.random()*100);
            list.add(random);
            System.out.println("add new date "+random);
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    // public static void main(String[] args) throws InterruptedException  {
    //     ArrayList list = new ArrayList<>();
    //     new Thread(()-> addData(list)).start();
    // }
    public static void printData(List list) {
        while(true){
            try {
                System.out.println("============");
                list.forEach(value -> System.out.println("value = "+ value));
                Thread.sleep(80l);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException  {
        ArrayList list = new ArrayList<>();
        new Thread(()-> addData(list)).start();
        new Thread(()->printData(list)).start();
    }
}
