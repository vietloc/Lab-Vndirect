import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamArrayExample {
    public static void main(String[] args) {
        Integer [] values = {2, 4, 7, 1, 3, 9, 11, 3};
        // Arrays.sort(values, (Integer o1, Integer o2)->{
        //     return o2 - o1;
        // });

        // for(int i =0; i < values.length;i++){
        //     System.out.println(values[i]);
        // }
        
        Stream<Integer> stream = Arrays.stream(values);

        Optional<Integer>max = stream.max((Integer o1, Integer o2)->{
            return o1-o2;
        });
        System.out.println("gia tri lon nhat = " + max.get());

        // stream.forEach(value->System.out.println(value));

        // Consumer<Integer>c = (Integer value)->{
        //     System.out.println(value);
        // };
        // stream.forEach(c);

        stream = Arrays.stream(values);

        Predicate<Integer>predicate = (Integer value)->{return value > 5;};
        Stream<Integer> older = stream.filter(predicate);
        older.forEach((Integer value)->{System.out.println(value);});
    }
}
