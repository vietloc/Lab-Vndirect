import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TreeMapExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TreeMap<Integer, String> mapT = new TreeMap<Integer, String>();
        mapT.put(3, "Nguyen Van A");
        mapT.put(1, "Nguyen Van B");
        mapT.put(2, "Nguyen Van C");
        mapT.put(4, "Nguyen Van X");

        Iterator<Map.Entry<Integer, String>> iterator = mapT.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        mapT.descendingKeySet().forEach(key ->
        System.out.println("key = "+ key +" value = " + mapT.get(key)));
        System.out.println("Time Tree: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        HashMap<Integer, String> mapH = new HashMap<Integer, String>();
        mapH.put(3, "Nguyen Van A");
        mapH.put(1, "Nguyen Van B");
        mapH.put(2, "Nguyen Van C");
        mapH.put(4, "Nguyen Van X");

        iterator = mapH.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        mapH.forEach(new BiConsumer<Integer,String>() {
            @Override
            public
            void accept(Integer t, String u){
                System.out.println("key = "+ t +" value = " + mapH.get(t));
            }
        });
        // System.out.println("key = "+ key +" value = " + mapH.get(key)));
        System.out.println("Time Hash: " + (System.currentTimeMillis()-start));
    };
}
