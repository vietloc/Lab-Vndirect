public class SystemExample {
    public static void main(String[] args) {
        System.out.println("JAVA_HOME = " + System.getProperty("java.home"));
        System.setProperty("java.home","C:\\program Files\\Java\\jre19");
        System.out.println("JAVA_HOME = " + System.getProperty("java.home"));
        System.out.println("User = "+System.getProperty("user.name"));
    }
}
