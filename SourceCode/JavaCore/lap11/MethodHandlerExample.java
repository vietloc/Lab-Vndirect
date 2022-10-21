import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandles.Lookup;

public class MethodHandlerExample {
    public static void main(String[] args) throws Throwable {
        Lookup loockup = MethodHandles.lookup();
        MethodHandle mh = loockup.findVirtual(TotalCalculator.class, "getTotal", MethodType.methodType(long.class,short.class));
        TotalCalculator obj = new TotalCalculator();
        System.out.println(mh.invoke(obj,(short)23));

        // MethodHandle mh2 = loockup.findStatic(TotalCalculator.class, "calculate", MethodType.methodType(String.class));
        // System.out.println((String)mh2.invokeExact());
        obj = new TotalCalculator();
        mh = loockup.findSetter(TotalCalculator.class, "TOTAL", int.class);
        mh.invoke(obj,15);
        mh = loockup.findVirtual(TotalCalculator.class, "getTotal", MethodType.methodType(long.class,short.class));
        System.out.println(mh.invoke(obj,(short)23));
        mh = MethodHandles.insertArguments(mh, 1, (short)10);
        System.out.printf("total = %d " ,mh.invoke(obj));
    }
}
class TotalCalculator {

    int TOTAL =3;

    public long getTotal(short value){
        return TOTAL + value;
    }
}
