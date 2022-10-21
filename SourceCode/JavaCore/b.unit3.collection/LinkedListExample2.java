import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample2 {
    public static void main(String[] args) {
        //khoi tao doi tuong
        List<String> list = new LinkedList<String>(Arrays.asList(args));
        
        //in ra value trong list
        list.forEach(value -> {
            System.out.println(value);
        });
    }
}
