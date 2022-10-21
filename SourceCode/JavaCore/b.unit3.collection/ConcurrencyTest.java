import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConcurrencyTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        // collections: luu tru va thac tac toi nhom cac doi tuong
        // collection: root interface
        Collections.addAll(list, 1, 3, 4, 2, 3, 6, 3, 3, 8);

        System.out.println("Before remove: size of list = " + list.size());
        System.out.println("List: " + list);
        // for(int i =0; i < list.size();i++){
        // if(list.get(i) == 3)
        // {
        // System.out.println("Xoa o vi tri" + i);
        // list.remove(i);
        // System.out.println("Khi i = " + i + "Mang hien tai" + list);

        // }
        // }

        // System.out.println("After remove: size of list = " + list.size());

        // list.forEach(v -> {
        //     if (v == 3) {
        //         list.remove(v);
        //     }
        // });

        //remove with iterator:
        // Iterator<Integer> iterator = list.iterator();
        // //while: ktra xem con phan tu tiep theo k
        // while(iterator.hasNext()){
        //     //lay ra gia tri phan tu va so sanh = 3 ?
        //     if(iterator.next() == 3){
        //         //xoa phan tu
        //         iterator.remove();
        //     }
        // }
        // list.removeIf(item -> {return item ==3;});
        
        list.removeAll(Collections.singleton(3));

        System.out.println("After remove: size of list = " + list.size());
        System.out.println("list final = " + list);
    }
}
