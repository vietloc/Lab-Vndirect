import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileFinderExample {
    static class Finder extends SimpleFileVisitor<Path>{
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            // TODO Auto-generated method stub

            if(matcher.matches(file.getFileName())){
                System.out.println("found: " + file);
            };
            return FileVisitResult.CONTINUE;
        }
    }
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Temp");
        Files.walkFileTree(path, new Finder());
    }
}
