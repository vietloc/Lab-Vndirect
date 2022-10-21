import java.util.concurrent.TimeUnit;

public class ThreadNumberTest {
    public static void main(String[] args) throws InterruptedException {
        PrintMessage number = new PrintMessage("minhngu");
        Thread thread = new Thread(number);
        // thread.setName("HaNoi_Thread");
        thread.setName("FSort_Thread1");
        // thread.isDaemon();
        thread.start();
        Thread thread1 = new Thread(number);
        // thread.setName("HaNoi_Thread");
        thread1.setName("FSort_Thread2");
        // thread.isDaemon();
        thread1.start();

        // thread.join();

        // while(thread.isAlive()){
        //     if(number.number %10 == 0){
        //         number.setAlive(false);
        //     }
        //     try {
        //         TimeUnit.SECONDS.sleep(1);
        //     } catch (InterruptedException ex) {
        //      ex.printStackTrace();
        //     }
        // }
        System.out.println("Main Thread say hello");
        System.out.println("Main Thread say goodbye");

    }
}
