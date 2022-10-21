import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StringSwitchStatement {
    public static void main(String[] args) {
        Locale locale = new Locale("vi","VN");
        DateFormat dateFormat = new SimpleDateFormat(
            "EEEEE, dd MMMMM yyyy",locale);
        Calendar calendar = Calendar.getInstance();
        System.out.println(dateFormat.format(calendar.getTime()));
    
        StringSwitchStatement statement = new StringSwitchStatement();
        System.out.println("Today is : " + statement.getTypeOfDay(calendar));
    }

    String getTypeOfDay(Calendar calendar){
        
        String type = calendar.getDisplayName(
            //locale : ngôn ngữ cho biểu diễn chuỗi.dayofweef: trường
            Calendar.MONTH, Calendar.SHORT, new Locale("vi"));
            switch (type) {
                case "1":
                    return "th 1";
                case "Th 2":
                    return "Start of work week";
                case "Th 3":
                    return "th3";
                case "Th 4":
                    return "Midweek";
                case "Th 5":
                    return "Th5";
                case "Th 6":
                    return "End of work week";
                case "Th 7":
                    return "th 7";
                case "Th 8":
                    return "Thang 8";
                case "thg 9":
                    return "Thang 9";
                case "Th 10":
                    return "Thng 10";
                case "Th 11":
                    return "Weekend";
                case "Th 12":
                    return "Weekend";
            }
                return "Unknown";
            }
}
