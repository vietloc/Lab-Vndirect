import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuantifiersRegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("t{2,5}\\S+(\\S+)(.*)",Pattern.UNICODE_CHARACTER_CLASS);
        
        String text = "toi2 hoc java";
        Matcher matcher = pattern.matcher(text);
        System.out.println(text + " ---> "+matcher.matches());
        
        text = "cau hoc java";
        matcher = pattern.matcher(text);
        System.out.println(text + " ---> "+matcher.matches());

        text = "botoi hoc java";
        matcher = pattern.matcher(text);
        System.out.println(text + " ---> "+matcher.matches());
    }
}
