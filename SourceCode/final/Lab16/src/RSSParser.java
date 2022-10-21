import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.stream.IntStream;

public class RSSParser {
    public static void extract(Document doc){
        NodeList channels = doc.getElementsByTagName("channel");
        for(int i =0; i < channels.getLength(); i++){
            Document chapter = (Document) channels.item(i).getOwnerDocument();
            NodeList items = chapter.getElementsByTagName("item");

            IntStream.range(0, items.getLength()).forEach(idx->{
                System.out.println(items.item(idx).getTextContent());
            });
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docbuilder = dbfactory.newDocumentBuilder();
        Document doc = docbuilder.parse("https://vnexpress.net/rss/tin-moi-nhat.rss");
        extract(doc);
    }
}
