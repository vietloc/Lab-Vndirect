import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import javax.net.ssl.HttpsURLConnection;

public class HttpHeaderExample {
    public static void main(String[] args) throws IOException {
        String link = "https://google.com.vn";
        URL url = new URL(link);

        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

        System.out.println("Https method " + connection.getRequestMethod());

        Map<String, List<String>> headers = connection.getHeaderFields();
        BiConsumer<String, List<String>> header = (key, values)->{
            System.out.println("Key: " +key + " Values: "+ values);
        };
        headers.forEach(header);

    }
}
