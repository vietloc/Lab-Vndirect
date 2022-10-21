import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.*;

public class TestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String message = "<html><h2>This is the response</h2></html>";
        httpExchange.sendResponseHeaders(200, message.length());
        try {
            OutputStream out = httpExchange.getResponseBody();
            out.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class HttpServerExample {
        public static void main(String[] args) throws IOException {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            HttpHandler testHandler = new TestHandler();
            server.createContext("/test", testHandler);
            server.setExecutor(Executors.newFixedThreadPool(5));
            server.start();
        }
    }
}
