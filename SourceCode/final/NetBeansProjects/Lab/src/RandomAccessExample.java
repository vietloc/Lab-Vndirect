/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AD
 */
import java.awt.Desktop;
import java.io.File;
import java.io.RandomAccessFile;
public class RandomAccessExample {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Temp\\hanoijava.txt");

        try(RandomAccessFile randomAccess = new RandomAccessFile(file, "rw")){
            //tao luong tep truy cap ngau nhien
            randomAccess.seek(9);
            byte[] bytes = new byte[4*102];
            int read = randomAccess.read(bytes);
            System.out.println(new String(bytes,0,read,"utf8"));

            randomAccess.seek(file.length());
            randomAccess.write("\r\n".getBytes());
            randomAccess.writeChars("Hello Co Can");

        } catch(Exception e){
            System.out.println(e);
        }
        Desktop.getDesktop().open(file);

    }
}
