import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnotationTest {
    public static void main(String[] args) {
        Method[] methods = TotalCalculator.class.getDeclaredMethods();
        TotalCalculator obj = new TotalCalculator();

        Arrays.stream(methods).forEach(method -> {
            Test test = method.getAnnotation(Test.class);
            if(test == null) return;

            System.out.println("test method " + method.getName());
            try {
                System.out.println(method.invoke(obj, new Object[]{test.value()}));
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
}
