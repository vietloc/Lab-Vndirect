import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupRegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\w+) (\\S+)(\\S+)(.*)",Pattern.UNICODE_CHARACTER_CLASS);
        String text = "tôi hocjava@ l@";
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println(matcher.group(4));

    }
}
