import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        //khoi tao list
        List<String>list = new ArrayList<String>();
        //add phan tu vao list
        Collections.addAll(list, args);

        //in ra cac phan tu trong list
        for(int i = 0; i < list.size();i++){
            System.out.println("Element at " + i + " is " + list.get(i));
        };
    }
}
