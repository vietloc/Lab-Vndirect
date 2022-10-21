import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class WritePathExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Temp\\hanoijava2.txt");
        try {
            BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("utf8"),CREATE,APPEND);
            for(int i =0; i < 10; i++){
                writer.write("Nguyên văn " + i + "\r\n");
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
