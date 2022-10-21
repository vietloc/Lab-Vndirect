import java.io.File;

public class SizeExample1 {
    private static long getSize(File file){
        
        if(file.isFile()){
            return file.length();
        }
        File[] files = file.listFiles();
        int dodai =0;
        for(int  i=0; i< files.length;i++){
            if(files[i].isDirectory()){
                dodai+= getSize(files[i]);
                continue;
            }
            dodai += files[i].length();
        }
        return dodai;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Temp");
        System.out.println("Size: "+getSize(file)/(1024*1024)+"MB");
    }
}
