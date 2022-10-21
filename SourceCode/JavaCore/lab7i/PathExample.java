import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryStream.Filter;

import javax.sound.sampled.Line;

public class PathExample {
    public static void main(String[] args) {
        // Filter<Path> filter = new Filter<Path>() {

        //     @Override
        //     public boolean accept(Path entry) throws IOException {
        //         // TODO Auto-generated method stub
        //         return Files.isDirectory(entry);
        //     }
            
        // };
        Path path = Paths.get("C:\\Temp");
        Path path2 = path.resolve("hanoijava.txt");
        // System.out.println("This is "+ (Files.isDirectory(path)?"folder":"file"+"!"));
        // //ktra duong dan co ton tai khong
        // System.out.println(Files.exists(path));
        Charset charset = Charset.forName("utf8");
        // try{
        //     // DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, filter);
        //     DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, "*.{java,txt}");
        //     directoryStream.forEach(p ->{             
        //         System.out.println(p.getFileName());
        //     });
        // } catch (IOException e) {
        //     // TODO: handle exception
        //     e.printStackTrace();
        // }
        try{
            BufferedReader reader = Files.newBufferedReader(path2, charset);
            String line = null;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }   
}


