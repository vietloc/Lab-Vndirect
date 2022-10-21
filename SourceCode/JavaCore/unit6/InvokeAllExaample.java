import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class InvokeAllExaample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(1);

        List<CallableSample> callables = Arrays.asList(
                new CallableSample(), new CallableSample(), new CallableSample());
        Stream<Integer> resultStream = null;
        try {
            Stream<Future<Integer>> stream = executor.invokeAll(callables).stream();
            resultStream = stream.map(future -> {
                try {
                    return future.get();
                } catch (InterruptedException | ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return 1;
                }
            });

        } catch (InterruptedException e) {
            // TODO: handle exceptio
            e.printStackTrace();
        }

        Object[] results = resultStream.toArray(Integer[]::new);
        Arrays.stream(results).forEach(System.out::println);
    }
}
