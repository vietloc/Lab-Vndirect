import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class ObjectReaderExample {
    public static void main(String[] args) throws Exception{
        ObjectInputStream input = null;
        File folder = new File("C:\\Temp");
        input = new ObjectInputStream(new FileInputStream(new File(folder, "my_object")));

        Object obj = input.readObject();
        Method method = obj.getClass().getMethod("run", new Class[0]);
        method.invoke(obj, new Object[0]);

    }
}
