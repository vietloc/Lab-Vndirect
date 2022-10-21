public class MathExam30 {
    public static void main(String[] args) {
        System.out.println("Pi is: "+Math.PI);
        double angle=45.0*2.0*Math.PI/360.0;
        System.out.println("Cos("+angle+") is "+Math.cos(angle));
        double value=0.707;
        System.out.println("acos("+value+") is"+Math.acos(value));
        System.out.println("exp(0.0) is "+Math.exp(0.0));
        System.out.println("log(10.0) is "+Math.log(10.0));
        System.out.println("pow(2.0,2.0) is "+Math.pow(2.0, 2.0));
        System.out.println("Here's one random number "+Math.random());
    }
}
