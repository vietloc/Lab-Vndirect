import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.w3c.dom.ranges.Range;

public class CallableSample implements Callable<Integer>{
    //khoi tao doi tuong lock
    //ReentrantLock == synchronized nhung linh hoat hon
    // private Lock lock = new ReentrantLock();

    @Override
    public Integer call(){
        // lock.lock();
        AtomicInteger total = new AtomicInteger(0);
        // IntStream.range(0,10).forEach(number ->{
        //     System.out.println(Thread.currentThread().getName() +" running " + total.addAndGet(number));

        //     Random random = new Random();
        //     LongStream longStream = random.longs(100, 1000);
        //     Long sleep = longStream.findFirst().getAsLong();
        // });
        IntStream.range(0,10).forEach(number ->{
            System.out.println(Thread.currentThread().getName() +" - object " + this + " is running " + total.addAndGet(number));

            Random random = new Random();
            LongStream longStream = random.longs(100, 1000);
            Long sleep = longStream.findFirst().getAsLong();
        });
    
        // lock.unlock();
        return total.get();
    }
}
