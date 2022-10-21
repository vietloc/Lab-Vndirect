import java.util.Arrays;
import java.util.Comparator;

public class SortArrayExample {
    public static void main(String[] args) {
        
       
        //in ra chuoi vua nhap
        for(int i = 0; i < args.length; i++){ System.out.println(args[i]);}
        Arrays.sort(args);
        // System.out.println(args);
        System.out.println("==========");
//ham sap xep chuoi nguoc lai voi thu tu nhap vao
        Arrays.sort(args, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                return o2.compareTo(o1);
            }
        });
//in ra chuoi vua sap xep
        for(int i = 0; i < args.length; i++){System.out.println(args[i]);}
    }
}
