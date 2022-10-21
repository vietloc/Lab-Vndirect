public class Decoding {
    public static void main(String[] args) {
        int [] values = {120, 105, 110, 32, 99, 104, -61,-96, 111};
        byte[] bytes = new byte[100];

        for(int i = 0; i< values.length;i++){
            bytes[i] = (byte) values[i];
        }
        System.out.println(bytes);
    }
}
