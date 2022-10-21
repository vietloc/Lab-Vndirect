import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTset {
    static void explore (Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        Class<? extends Object> clazz = obj.getClass();
        System.out.println("clazz name: "+clazz.getName());

        Field field = clazz.getDeclaredField("TOTAL");

        //cap quyen truy cap vao bien private
        field.setAccessible(true);
        // System.out.println("total value is "+field.get(obj));
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        
        // modifiersField .setAccessible(true);
        // //xoa di chu final
        // modifiersField.setInt(field, field.getModifiers()&~Modifier.FINAL);
        // field.set(obj, 23);
        // System.out.println("modified value of the total field is  "+ field.get(obj));

        try {
            Method method = clazz.getDeclaredMethod("getTotal", new Class[]{});
            method.setAccessible(true);
            System.out.println("mothod return value = " +method.invoke(obj, new Object[0]));
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        field.set(obj, 25);
        System.out.println("total value is 2 "+ field.get(obj));

        try {
            Method method = clazz.getDeclaredMethod("getTotal", new Class[]{int.class});
            method.setAccessible(true);
            System.out.println("mothod return value = " +method.invoke(obj, new Object[]{5}));
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {
        TotalCalculator obj = new TotalCalculator();
        explore(obj);
    }
}
class TotalCalculator {
    // private int TOTAL = 3;

    //ham goi
    // private int getTotal(){
    //     return TOTAL;
    // }

    // //ham cong
    // private int getTotal(int value){
    //     return TOTAL + value;
    // }

    private final static int TOTAL =3;

    public long getTotal(short value){
        return TOTAL + value;
    }
}
