import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeExample {
    public static long getSize(File file){
        if(file.isFile()){
            return file.length();
        }
        AtomicLong dodai = 0;
        Arrays.stream(file.list()).forEach(f ->{
            dodai.getAndSet(dodai.longValue())+(f.isDirectory ? getSize(f):f.length());
        });
        return dodai.longValue();
    }

    public static void main(String[] args) {
        File file = new File("C:\\Temp");
        System.out.println("Size: "+getSize(file)/(1024*1024)+"MB");
    }
}
