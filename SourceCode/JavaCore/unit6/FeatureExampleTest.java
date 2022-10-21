import java.util.concurrent.ExecutionException;
// import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FeatureExampleTest {
    public static void main(String[] args) {
        CallableSample callableSample = new CallableSample();

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future future = executor.submit(callableSample);

        //isDone of future: ktra task hoan thanh k?
        System.out.println("Future Done?" + future.isDone());
        Object result = "";
        try {
            result = future.get(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Future Done?" + future.isDone()+" - result = " + result.toString());

    }
}
