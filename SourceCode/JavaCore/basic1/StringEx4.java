public class StringEx4{
	public static void main(String[] args) {
        byte[] forString = {99, -58, -80, -31, -69, -101, 112, 44, 32, 104, 105, -31, -70, -65, 112, 44, 32, 103, 105, -31, -70, -65, 116};
        try {
            System.out.println(new String(forString, "utf-8"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
