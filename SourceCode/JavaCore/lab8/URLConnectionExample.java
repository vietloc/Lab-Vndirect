import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.sql.Connection;

public class URLConnectionExample {
    public static void main(String[] args) throws IOException {
        String link = "https://google.com.vn";
        URL url = new URL(link);

        URLConnection connection = url.openConnection();
        InputStream stream = connection.getInputStream();

        int read;
        byte[] bytes  = new byte[1000];
        while((read = stream.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, read));
        }
    }
}
