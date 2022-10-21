import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        //Set la in ra cac phan tu k trung lap
        //TreeSet: co sap sap
        //hashSet: k sx va nhah hon treeset
        //LinkedHashSet in ra theo thu tu nhap vao
        long start = System.currentTimeMillis();
        Set<Integer>numbersT = new TreeSet<Integer>();
        numbersT.add(22);
        numbersT.add(14);
        numbersT.add(8);
        numbersT.add(22);
        numbersT.add(3);
        numbersT.add(12);
        numbersT.add(1);
    
        System.out.println("Size of set: " + numbersT.size());
        System.out.println(numbersT);
        System.out.println("time numberT = " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        Set<Integer>numbersH = new HashSet<Integer>();
        numbersH.add(22);
        numbersH.add(14);
        numbersH.add(8);
        numbersH.add(22);
        numbersH.add(3);
        numbersH.add(12);
        numbersH.add(1);
        System.out.println("Size of set: " + numbersH.size());
        System.out.println(numbersH);
        System.out.println("time numberT = " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        Set<Integer>numbersS = new LinkedHashSet<Integer>();
        numbersS.add(22);
        numbersS.add(14);
        numbersS.add(8);
        numbersS.add(22);
        numbersS.add(3);
        numbersS.add(12);
        numbersS.add(1);
        System.out.println("Size of set: " + numbersS.size());
        System.out.println(numbersS);
        System.out.println("time numberT = " + (System.currentTimeMillis() - start));
    }   
}
