import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.plaf.DesktopIconUI;
import java.awt.*;

public class HttpConnectionExample {
    public static void main(String[] args) throws IOException{
        String link = "https://google.com.vn";
        URL url = new URL(link);

        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

        Path path = Paths.get("test.html");
        try(
            InputStream inputStream = connection.getInputStream();
            OutputStream outputStream = Files.newOutputStream(path,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        ){
            int read;
            byte[] bytes = new byte[1000];
            while((read = inputStream.read(bytes)) !=-1){
                outputStream.write(bytes, 0, read);
            }
            // TODO: handle exception
        } finally{
            Desktop.getDesktop().open(path.toFile());
        } 
    }
}
