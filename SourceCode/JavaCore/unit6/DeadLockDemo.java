
public class DeadLockDemo extends Thread{
    private Object lock1;
    private Object lock2;

    public DeadLockDemo(Object lock1, Object lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public synchronized void run() {
        // synchronized(lock1){
            {
            System.out.println(Thread.currentThread().getName()+": Holding" + lock1 + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": Waiting for " + lock2 + "...");
            // synchronized(lock2){
                {
            System.out.println(Thread.currentThread().getName() + "------>" + lock1 + ":" + lock2 + "...");
        }}
    }
}
