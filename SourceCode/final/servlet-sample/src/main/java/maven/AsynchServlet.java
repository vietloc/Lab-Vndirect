package maven;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@WebServlet(urlPatterns = "/synch", asyncSupported = true)
public class AsynchServlet extends HttpServlet {
//    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext context = req.startAsync();
        context.setTimeout(60 * 1000);
        context.start(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        Thread.sleep(3*1000l);
                        Writer writer = context.getResponse().getWriter();

                        URL obj = new URL("https://www.google.com.vn");
                        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                        con.setRequestMethod("GET");
                        con.addRequestProperty("Accept-Encoding", "gzip");
                        BufferedReader reader = new BufferedReader(new InputStreamReader((con.getInputStream())));

                        String line;
                        while ((line = reader.readLine())!=null){
                            writer.write(line);
                        }
                        context.complete();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Writer writer = null;
                    writer = context.getResponse().getWriter();
                    writer.write("Hello Async");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                context.complete();
            }
        });
    }
//    private byte[] zipFiles(File directory, String[] files) throws IOException {
//        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
//             ZipOutputStream zos = new ZipOutputStream(baos)) {
//            byte[] bytes = new byte[2048];
//
//            for (String fileName : files) {
//                String path = directory.getPath() +
//                        AsynchServlet.FILE_SEPARATOR + fileName;
//                try (FileInputStream fis = new FileInputStream(path);
//                     BufferedInputStream bis = new BufferedInputStream(fis)) {
//
//                    zos.putNextEntry(new ZipEntry(fileName));
//
//                    int bytesRead;
//                    while ((bytesRead = bis.read(bytes)) != -1) {
//                        zos.write(bytes, 0, bytesRead);
//                    }
//                    zos.closeEntry();
//                }
//            }
//
//            zos.close();
//            return baos.toByteArray();
//        }
//    }
}