import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class WatchFolderExample {
    public static void watch(Path path){
        FileSystem fs = path.getFileSystem();
        try(WatchService service = fs.newWatchService()) {
            path.register(service, ENTRY_CREATE);
            while(true){
                WatchKey key = service.take();

                if(!key.reset()){
                    break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Temp");
        watch(path);
    }
}
