import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;

import javax.xml.transform.Source;

public class CopingAndMovingExample {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("C:\\Temp\\hanoijava.txt");
        Path target = Paths.get("C:\\Temp4\\hanoijava.txt");
        //copy file sang target
        // Files.copy(source, target, REPLACE_EXISTING);
        //xoafile ben target
        // Files.delete(target);
        Files.createLink(target, source);
    }
}
