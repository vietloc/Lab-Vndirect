public class DeadLockTest {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        DeadLockDemo thread1 = new DeadLockDemo(obj1, obj2);
        DeadLockDemo thread2 = new DeadLockDemo(obj2, obj1);
        
        thread1.start();
        thread2.start();
    }
}
