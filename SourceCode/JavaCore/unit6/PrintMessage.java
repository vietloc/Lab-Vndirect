import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintMessage implements Runnable {

    private String message;

    public Integer number = 1;
    private boolean alive = true;

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public PrintMessage(String ms) {
        this.message = ms;
    }

    @Override
    //public synchronized void //chay 1 thread

    //chay // 2 thread
    public void run() {
        String[] elements = message.split(" ");
        // Arrays.stream(elements).forEach(ele ->{
        // System.out.println(Thread.currentThread().getName()+" print "+ele);
        // // try {
        // // TimeUnit.SECONDS.sleep(1);
        // // } catch (InterruptedException ex) {
        // //
        // java.util.logging.Logger.getLogger(PrintMessage.class.getName()).log(java.util.logging.Level.SEVERE,
        // null, ex);
        // // }
        // try {
        // Thread.sleep((int)(Math.random()*3)*1000);
        // } catch (InterruptedException ex) {
        // ex.printStackTrace();
        // }
        // });

        // Thread current = Thread.currentThread();
        // while(alive){
        // number++;
        // System.out.println(current.getName()+ "Number is\""+ number + "\"");
        // try {
        // Thread.sleep(800);
        // } catch (InterruptedException ex) {
        // ex.printStackTrace();
        // }
        // }
        // System.out.println(current.getName()+"is stoped!");

        Thread current = Thread.currentThread();
        // while(number<10){
        // number++;
        // System.out.println(current.getName()+ "Number is\""+ number + "\"");
        // try {
        // Thread.sleep(300);
        // } catch (InterruptedException ex) {
        // ex.printStackTrace();
        // }
        // }
        // System.out.println(current.getName()+"is stoped!");

        // synchronized(number){
            // while(number<30){
            //     number++;
            //     System.out.println(current.getName()+ "Number is\""+ number + "\"");
            //     try {
            //     Thread.sleep(300);
            //     } catch (InterruptedException ex) {
            //     ex.printStackTrace();
            //     }
            //     }
        // }
        while(true){
            number++;
            System.out.println(current.getName()+ "Number is\""+ number + "\"");
            try {
            Thread.sleep(300);
            } catch (InterruptedException ex) {
            ex.printStackTrace();
            }if(number%10 == 0)break;
            }
            System.out.println(current.getName()+"is stoped!");

    }
}
