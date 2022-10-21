package maven;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(value = "/upload", name = "upload-servlet")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        String appPath = request.getServletContext().getRealPath("");
        File folder = new File(appPath, "temp");
        if(!folder.exists()){
            folder.mkdir();
        }
        response.getWriter().println("---------"+appPath);

        request.getParts().forEach(part ->{
            String name = extractFileName(part);
        });
        for(Part part : request.getParts()){
            String name = extractFileName(part);
            byte[] buff = new byte[4 * 1204];
            int read = -1;
            FileOutputStream outputStream = new FileOutputStream(new File(folder, name));
            try{
                InputStream inputStream = part.getInputStream();
                while ((read = inputStream.read(buff)) !=-1){
                    outputStream.write(read);
                }
            } finally {
                outputStream.close();
            }
        }
        for (Part part : request.getParts()) {
            Collection<String> headers = part.getHeaderNames();
            headers.forEach(header -> {

                try {
                    response.getWriter().println(header + " : " + part.getHeader(header));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        response.getWriter().print("Upload has been done successfully!");
    }

    private String extractFileName(Part part) {
        String content = part.getHeader("content-disposition");
        Pattern pattern = Pattern.compile(".*filename\\=\"(.*)\".*");
        Matcher matcher = pattern.matcher(content);

        return matcher.matches()? matcher.group(1) : "unknown";
    }
}
