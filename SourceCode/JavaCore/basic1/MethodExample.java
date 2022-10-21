
public class MethodExample {
    private static int add(int ... values){
        int total = 0;
        for(int Element : values){
            total += Element;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Sum: " + add(4,7,5,12,6,9));
    }
}
