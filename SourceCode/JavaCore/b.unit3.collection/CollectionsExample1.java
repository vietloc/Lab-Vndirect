import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.InternalFrameAdapter;

public class CollectionsExample1 {
    public static void main(String[] args) {
        Short[]values = {1,2,4,5,6,7,8,9};

        List<Short>list = new LinkedList<Short>();

        //nhet item values vao list
        Collections.addAll(list, values);

        //Dao nguoc chuoi
        // Collections.reverse(list);

        //SapXep
        Collections.sort(list);

        list.toArray(values);
        for(int i = 0; i < list.size();i++){
            System.out.println(values[i] + " , ");
        }

        Integer t =9;
        System.out.println("Vi tri thu" + Collections.binarySearch(list, t.shortValue()));

    }
}
