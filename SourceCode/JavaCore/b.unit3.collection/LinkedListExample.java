import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        //khoi tao doi tuong list
        List<String> list = new LinkedList<String>();

        //ghi du lieu nhap vao list
        for(String ele : args){
            list.add(ele);
        }

        //iterator duyet cac phan tu trong list va gan vao doi tuong
        Iterator<String>iterator = list.iterator();

        //in ra cac phan tu
        while(iterator.hasNext()){
            System.out.println("===> " + iterator.next());
        };
    }
}
