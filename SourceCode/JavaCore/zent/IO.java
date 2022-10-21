import java.util.Scanner;

public class IO {

    void input() {
        // System.out.println("1 - Xem danh sách nhân viên \n 2- Thêm mới 1 nhân viên
        // \n3- Xóa 1 nhân viên truyền vào mã nhân viên\n4- Chỉnh sửa 1 nhân viên truyền
        // vào mã nhân viên\n5- Tìm kiếm nhân viên dựa vào mã nhân viên/email/sdt\n6-
        // Thoát");
        // System.out.println("Chon so:");
        // Scanner ip = new Scanner(System.in);
        // int so = ip.nextInt();
        // switch(so){
        // case 1:
        // System.out.println("1");
        // break;
        // case 2:
        // System.out.println("2");
        // case 3:

        // case 4:

        // case 5:

        // case 6:
        // }
        // System.out.println("Nhap vao MSV: ");
        // Scanner msv = new Scanner(System.in);
        // int maSV = msv.nextInt();

        // System.out.println("Nhap vao Ten SV: ");
        // Scanner nameSV = new Scanner(System.in);
        // String tenSV = nameSV.nextLine();

        // System.out.println("Nhap vao tuoi: ");
        // Scanner old = new Scanner(System.in);
        // int tuoi = old.nextInt();

        // System.out.println("===============");

        // System.out.println("Profile Student import : ");
        // System.out.println("MSV: "+ maSV + "Ten SV: "+ tenSV + "Tuoi: "+ tuoi);

        // System.out.println("Nhap vao a = ");
        // Scanner ia = new Scanner(System.in);
        // int a = ia.nextInt();

        // System.out.println("Nhap vao b = ");
        // Scanner ib = new Scanner(System.in);
        // int b = ib.nextInt();

        // // System.out.println("Tong a+b= " +(a+b));
        // // System.out.println("Hieu a-b= " +(a-b));
        // // System.out.println("Thuong a/b= " +(a/b));
        // // System.out.println("Tich a*b= " +(a*b));
        // // System.out.println("So du a%b= " +(a%b));

        // if(a>b){
        // System.out.println(a + "lon hon");
        // }else{
        // System.out.println(b + "lon hon");
        // }
        // Scanner input = new Scanner(System.in);
        // int n;
        // int soNguyen;
        // int sum = 0;

        // do{
        // System.out.print("Nhập số phần tử n: ");
        // n = input.nextInt();
        // if(n<=0){
        // System.out.println("Số phần tử phải > = 0.");
        // }
        // }while(n<=0);

        // int i = 1;
        // while (i <= n) {
        // do {
        // System.out.print("Nhập số nguyên thứ " + i + " : ");
        // soNguyen = input.nextInt();

        // if (soNguyen <= 0) {
        // System.out.println("Bạn phải nhập số nguyên dương");
        // }
        // } while (soNguyen <= 0);

        // if (soNguyen % 4 == 0 || ((soNguyen / 100) % 10) == 3) {
        // sum = sum + soNguyen;
        // }
        // i++;
        // }
        // System.out.println("Tổng là: " + sum);
        Scanner input = new Scanner(System.in);
        // int sum = 0;

        // System.out.println("Nhap vao M = ");
        // int m = input.nextInt();

        // System.out.println("Nhap vao N <= M, N = ");
        // int n = input.nextInt();

        // while (n > m) {
        // System.out.println("N phai <= M");
        // System.out.println("Nhap vao N <= M, N = ");
        // n = input.nextInt();
        // }

        // System.out.println("Nhap vao K = ");
        // int k = input.nextInt();

        // for (int i = n+1; i < m; i++) {
        // if(i%k ==0){
        // sum += i;
        // }
        // }
        // System.out.println("Tong cac so trong khoang tu n-m chia het cho k la: "+
        // sum);

        // System.out.print("Nhap vao n = ");
        // int n = input.nextInt();
        // int i = 1;
        // int soNguyen;
        // int soNguyenAm = 0;
        // int soNguyenDuong = 0;
        // int so0 = 0;
        // while (i <= n) {
        //     System.out.print("So thu" + i + " la: ");
        //     soNguyen = input.nextInt();

        //     if (soNguyen < 0) {
        //         soNguyenAm++;
        //     }
        //     if (soNguyen > 0) {
        //         soNguyenDuong++;
        //     }
        //     so0 = n - soNguyenAm - soNguyenDuong;
        //     i++;
        // }

        

        // System.out.println("So so nguyen am nhap vao la: " + soNguyenAm);
        // System.out.println("So so nguyen duong nhap vao la: " + soNguyenDuong);

        // System.out.println("So so 0 nhap vao la: " + so0);

        System.out.print("Nhap vao a = ");
        int a = input.nextInt();
        
        System.out.print("Nhap vao b = ");
        int b = input.nextInt();

        System.out.print("Nhap vao c = ");
        int c = input.nextInt();
        
        float kq = a;
        System.out.println("phuong trinh bac 2: "+a+"x^2+ "+b+"x "+ c +" = " + kq);

    }
}