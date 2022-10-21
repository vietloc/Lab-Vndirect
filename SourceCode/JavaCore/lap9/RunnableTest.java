public class RunnableTest {
    public static void main(String[] args) {
        // Runnable runnable = new Runnable() {

        //     @Override
        //     public void run() {
        //         // TODO Auto-generated method stub
        //         System.out.println(Thread.currentThread().getName()+"say hello Java class!");
        //     }           
        // };

        //==Cach 1===
        // new Thread(runnable).start();
        // Runnable runnable = ()->{
        //     System.out.println(Thread.currentThread().getName()+"say hello java class");
        // };
        // new Thread(runnable).start();
        
        //==Cach 2===
        // new Thread(()->{
        //     System.out.println(Thread.currentThread().getName()+"say hello java class");
        // }).start();

        //==Cach 3===
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"say hello java class");
            System.out.println("1+1= " + (1+1));
        }).start();
    }
}
