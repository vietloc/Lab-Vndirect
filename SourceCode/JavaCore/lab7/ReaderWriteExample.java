import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.Desktop;


public class ReaderWriteExample {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Temp\\hanoijava.txt");

        //filewriter: ghi du lieu theo dinh dang ki tu
        //khac voi fileoutputstream: vi outputstream phai convert sang mang byte
        // try(FileWriter writer = new FileWriter(file)) {
        //     writer.write("Tran\r Thi a");
        //     writer.write("\r\n");
        //     writer.write("Tran Thi B");
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
        // Desktop.getDesktop().open(file);

        FileReader reader = null;

        reader = new FileReader(file);
        char[] buffer = new char[4*1024];
        int read = -1;
        StringBuilder builder = new StringBuilder();
        while((read = reader.read(buffer))!=-1){
            builder.append(buffer, 0, read);
        }
        System.out.println(builder);

    }
    
}
