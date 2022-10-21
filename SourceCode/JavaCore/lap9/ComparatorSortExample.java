import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSortExample {
    public static void main(String[] args) {
        Integer[] values = {12, 345, 55, 7, 9,12,9};

        Arrays.sort(values, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2 - o1;
            }           
        });

        for(Integer ele : values){
            System.out.print(ele + ",");
        }
    }
}
