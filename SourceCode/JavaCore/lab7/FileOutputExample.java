import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class FileOutputExample {
    public static void main(String[] args) throws IOException {
        File file = new File("C:"+File.separator+"Temp"+File.separator+"hanoijava.txt");

        // FileOutputStream outputStream = null;
        // try{
        //     outputStream = new FileOutputStream(file);
        //     bytes = "Hello Ha Noi Java Class" to bytes;
        //     outputStream.write(bytes);
        // } finally{
        //     if(outputStream != null){
        //         outputStream.close();
        //     }
        // }

        try(InputStream inputStream = new FileInputStream(file)){
            // byte[] bytes = new byte[16];
            // byte[] bytes = new byte[124];
            // inputStream.read(bytes);
            // System.out.println(new String(bytes));
            byte[] bytes = new byte[4*1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while((read = inputStream.read(bytes))!=-1){
                builder.append(new String(bytes, 0, read));
            }
            System.out.println("[" + builder + "]" +"inputchuoi");
        }
    }
}
