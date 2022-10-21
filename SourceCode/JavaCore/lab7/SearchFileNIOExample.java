import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SearchFileNIOExample {
    Charset charset = Charset.forName("utf-8");
    Pattern pattern = Pattern.compile("s\\S", Pattern.CASE_INSENSITIVE);

    File file = new File("C:\\Temp\\io_sample2.txt");
    FileInputStream stream = new FileInputStream(file);
    FileChannel channel = stream.getChannel();
    ByteBuffer bytes = channel.map(FileChannel.MapMode.READ_ONLY,0,channel.size());
    CharBuffer chars = charset.decode(bytes);
    Matcher matcher = pattern.matcher(chars);

    if(matcher.find()){
        System.out.println("Found at "+ Integer.toString(matcher.start()));
        System.out.println("Value '" + chars.subSequence(0 , 10) +"'");
    }else{
        System.out.println("Not Found");
    }
}
