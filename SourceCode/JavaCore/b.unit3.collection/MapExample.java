import java.security.Key;
import java.security.KeyStore.Entry;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import javax.swing.text.Keymap;

public class MapExample {
    public static void main(String[] args) {
        //khoi tai doi tuong
        Map<Integer, String> map = new Hashtable<Integer, String>();
        
        //chen key va value vao map
        map.put(3, "Nguyen Van A");
        map.put(12, "Nguyen Van B");
        map.put(22, "Nguyen Van C");
        map.put(51, "Nguyen Van L");
        map.put(4, "Nguyen Van X");
        
        System.out.println(map.get(3));


        map.put(3, "Nguyen Thi A");
        System.out.println(map.get(3));

        //entrySet trả về giá trị cặp key-value
        Set<Map.Entry<Integer, String>> set = map.entrySet(); 
        System.out.println(set);
        

    }
}
