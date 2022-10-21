import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StringSwtichStatement2 {
    private static final int DATE = 0;
    static String getTypeOfDay(Calendar calendar){
        String type = calendar.getDisplayName(
            Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("vi"));
            switch (type) {
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
                case "CN":
                    return "Weekend";
            }
                return "Unknown";
            }
    public static void main(String[] args) {
        StringSwtichStatement2 statement = new StringSwtichStatement2();
        Calendar calendar = Calendar.getInstance();
        System.out.println("Today is " + StringSwtichStatement2.getTypeOfDay(calendar));
        calendar.set(Calendar.DATE, calendar.get(DATE) +1);
        System.out.println("Tomorow is " + getTypeOfDay(calendar));
    }
}