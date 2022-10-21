import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CharaterExample2 {
    private static AtomicInteger countDigit(String value) {
        
        AtomicInteger counter = new AtomicInteger(0);
        
        IntStream stream = value.chars();
        stream.forEach(c->{
            if(Character.isDigit(c)) counter.incrementAndGet();
        });
    
        return counter;
    
    }
    public static void main(String[] args) {
        System.out.println("There are " + countDigit(args[0]) + " digits in the text.");
    }
}
