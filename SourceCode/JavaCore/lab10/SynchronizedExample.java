import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.w3c.dom.ranges.Range;

public class SynchronizedExample{
    static void addData(List<Integer>list){
        IntStream.range(0, 1000).forEach(index ->{
            try{
                list.add(index);
            } catch(Exception exp){
                System.out.println(exp.toString());
            }
        });
    }
    public static void main(String[] args) {
        ArrayList<List<Integer>> values = new ArrayList<List<Integer>>();
        for(int i = 0; i <10; i++){
            ArrayList list = new ArrayList<>();
            new Thread(()-> addData(list)).start();
            new Thread(()-> addData(list)).start();
            values.add(list);
        }

        try {
            Thread.sleep(5*1000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        values.forEach(list->System.out.println("number items of list -----> "+ list.size()));
    }
}
