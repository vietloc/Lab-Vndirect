import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
        List<Integer>listOfIntegers = new ArrayList<Integer>(Arrays.asList(4,7,1,3,8,9,2,6,10));

        Comparator<Integer>comparator = Integer::compareTo;

        //sap xep
        Collections.sort(listOfIntegers,comparator);

        listOfIntegers.stream().filter(v->v>5).forEach(v->{
            System.out.println(v);
        });

        Collector<Integer,?,IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);
        IntSummaryStatistics summaryStatistics = listOfIntegers.stream().collect(collector);

        System.out.println("Total = " + summaryStatistics.getSum());
        System.out.println("Overage = " + summaryStatistics.getAverage());

        Consumer<Integer>myConsumer = n ->{
            System.out.println("user input value = " + n);
            if(n < 5){
                System.out.println("Invalid value!");
                return;
            }
            listOfIntegers.add(n);
            System.out.println("values: ");
            listOfIntegers.forEach(x-> System.out.println(x + "-"));
        };
        myConsumer.accept(4);

        Scanner scanner = new Scanner(System.in);
        
        // while(true){
        //     System.out.println("Please input a number: ");
        //     int value = scanner.nextInt();
        //     myConsumer.accept(value);
        //     System.out.println();
        // }

        Predicate<Integer> tester = v-> v>5;
        Consumer<Integer> myConsumer2 = n -> listOfIntegers.add(n);
        while(true){
            System.out.println("Please input a number: ");
            int value = scanner.nextInt();
            if(value<0) break;
            if(tester.test(value)) myConsumer2.accept(value);
            listOfIntegers.forEach(x->System.out.print(x + "-"));
        }

        
    }
}
