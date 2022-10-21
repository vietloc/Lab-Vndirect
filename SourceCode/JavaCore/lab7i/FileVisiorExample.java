import java.sql.PseudoColumnUsage;
import java.io.IOException;
// import static java.nio.FileVisitResult.CONTINUE;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisiorExample {
    public static class PrintFiles extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            // TODO Auto-generated method stub
            System.out.println(file + " is file!");
            return FileVisitResult.CONTINUE;

        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            // TODO Auto-generated method stub
            System.out.println(dir + " is directory!");
            return FileVisitResult.CONTINUE;
        }
    }
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Temp");
        Files.walkFileTree(path, new PrintFiles());
    }
}
