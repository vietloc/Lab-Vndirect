import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.List;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("C:\\Temp");
        // if(file.isDirectory()){
        //     System.out.println("This is folder!");
        // }else{
        //     System.out.println("This is file!");
        // }
        System.out.println("This is "+ (file.isFile()? "file" : "folder") + "!");

        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f.getName());
        }
    }
}
