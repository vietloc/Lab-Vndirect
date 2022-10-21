import java.util.regex.Matcher;//cung cap co so cua bieu thuc chinh quy
import java.util.regex.Pattern;//cung cap co so cua bieu thuc chinh quy

import javax.xml.stream.events.EndDocument;

//regex: bieu thuc chinh quy
public class RegexPatternExample {
    public static void main(String[] args) {
        //Lớp Pattern: Là một đối tượng mẫu được biên dịch
        // từ một biểu thức chính quy, không có constructor public

        //So khớp với 1 hoac nhieu ký tự là chữ số, viết tắt của [0-9]
        Pattern pattern = Pattern.compile("\\d+");

        String text = "123 + 1 bang 124";

        //Lớp Matcher: Là một phương tiện để so khớp chuỗi dữ liệu đầu vào với
        // đối tượng Pattern đã được tạo trước, không có constructor public
        Matcher matcher = pattern.matcher(text);

        int start = 0;
        while(matcher.find(start)){
            start = matcher.start();
            int end = matcher.end();
            System.out.println("number: " + text.substring(start,end));
            start = end;
        }
        //ktra xem chuoi co ton tai chu so?
        System.out.println(matcher.find());

        //vi tri bat dau va ket thuc
        System.out.println("start = " + matcher.start() + "-end " + matcher.end());

        //gia tri
        System.out.println("value = "+text.substring(matcher.start(),matcher.end()));
    }
}
