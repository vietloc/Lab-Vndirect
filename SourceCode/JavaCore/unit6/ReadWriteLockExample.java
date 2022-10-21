import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        HashMap<String, String> map = new HashMap<>();

        ReadWriteLock lock = new ReentrantReadWriteLock();
        // executor.submit(() -> {
            
        //     lock.writeLock().lock();
            
        //     try {
        //         System.out.println("Start writing");
        //         map.put("foo", "bar");
        //         // try {
        //         //     TimeUnit.SECONDS.sleep(2);
                    
        //         // } catch (InterruptedException e) {
                    
        //         //     e.printStackTrace();
        //         // }
        //     } finally{
                
        //         lock.writeLock().unlock();
        //         System.out.println("end writing");
        //         System.out.println(map);
        //     }
        // });
        map.put("foo", "bar");
        Runnable readTask = ()->{
            
            lock.writeLock().lock();
            System.out.println("Start reading");
            try{

                System.out.println(map.get("foo"));
            }finally{
                
                System.out.println("end reading");
                System.out.println("end reading1");
                System.out.println("end reading2");
                lock.writeLock().unlock();
            }
        };
        
        executor.submit(readTask);
        executor.submit(readTask);
        executor.shutdownNow();
    }
}
