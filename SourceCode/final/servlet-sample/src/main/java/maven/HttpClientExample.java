package maven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClientExample {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
//        try {
//            URL url = new URL("http://localhost:8080/html");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            con.addRequestProperty("Accept-Encoding","gzip");
//
//            int responseCode = con.getResponseCode();
//            System.out.println("Response Code : " + responseCode);
//
//            reader = new BufferedReader(new InputStreamReader((con.getInputStream())));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } finally {
//            if (reader != null) {
//                reader.close();
//            }
//        }

            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    URL obj = null;
                    try {
                        obj = new URL("http://localhost:8080/synch");
                        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                        con.setRequestMethod("GET");
                        con.addRequestProperty("Accept-Encoding", "gzip");
                        BufferedReader reader = new BufferedReader(new InputStreamReader((con.getInputStream())));

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    executor.shutdown();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
    }

}
