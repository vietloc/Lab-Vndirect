import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool(4);

        CallableSample sample = new CallableSample();
        List<CallableSample> callables = Arrays.asList(sample,sample);

        try {
            executor.invokeAll(callables);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
