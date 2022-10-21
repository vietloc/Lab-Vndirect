import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MessageFormatExample {
    public static void main(String[] args) {
        Locale locale = new Locale("vi","VN");
        DateFormat dateFormat = new SimpleDateFormat(
            "EEEEE, dd MMMMM yyyy",locale);

        String message = MessageFormat.format(
            "Hello {0}! Today is {1}.",args[0],
            dateFormat.format(Calendar.getInstance().getTime())
        );

        System.out.println(message);
    }
}
