
public class ExeceptionDemo {

    public static void main(String[] args) {
        System.out.println("Start");
        int arr[] = new int[5]; // Mảng chỉ có 1 phần tử
        try {
            for (int i = 0; i < 8; i++) { // Chạy đến i=2 sẽ bị lỗi
                System.out.println("srr["+i+"] = " + arr[i]);
            }

        } catch (Exception ex) {
            System.err.println("Lỗi : " + ex.getMessage());
        } 

        System.out.println("End");
    }
}