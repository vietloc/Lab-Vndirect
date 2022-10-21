import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PossessiveQuantifiersRegexExample {
    public static void main(String[] args) {
        String text = "va";
        Pattern pattern = Pattern.compile(".*+va",Pattern.UNICODE_CHARACTER_CLASS);

        Matcher matcher = pattern.matcher(text);
        
        System.out.println("possessive----> "+matcher.find());
    }
}
