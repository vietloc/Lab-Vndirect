public class MathExample {
    public static void main(String[] args) {
        int i = 4,j = -8;
        double x = 47.1, y = 1.79;

        System.out.println("|"+j+"| is "+ Math.abs(j));
        System.out.println("|"+x+"| is "+ Math.abs(x));

        System.out.println(x + "is approximately " + Math.round(x));
        System.out.println("The ceiling of " + i + "is " + Math.ceil(i));
        System.out.println("The ceiling of " + y + "is " + Math.ceil(y));
        System.out.println("The floor of " + x + "is " + Math.floor(x));
        System.out.println("min(" + x + "," + y + ") is "+ Math.min(x, y));

    }
}
