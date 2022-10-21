import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import javax.management.RuntimeErrorException;

public class ExecuteServiceTest {
    public static void main(String[] args) {
        PrintMessage number = new PrintMessage("");
        Callable<Object> value = Executors.callable(number);
        System.out.println("main say hello");

        try {
            value.call();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        System.out.println("main say goodbye");
    }
}
