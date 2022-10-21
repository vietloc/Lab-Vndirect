import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;

public class ParseDOMDemo {

    public static void print(Node node){
        short type = node.getNodeType();
        if(type == Node.COMMENT_NODE || type == Node.PROCESSING_INSTRUCTION_NODE) return;

        System.out.println(node.getNodeName() + ":" + node.getNodeValue());

        NodeList list = node.getChildNodes();
        for(int i =0; i < list.getLength();i++){
            System.out.println(list.item(i));
        }

        NamedNodeMap attributes = node.getAttributes();
        if(attributes!=null){
            for(int i=0;i<attributes.getLength();i++){
                System.out.println("attribute: "+ attributes.item(i).getNodeName()+":"+attributes.item(i).getNodeValue());
            }
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbbuilder = dbfactory.newDocumentBuilder();
        InputStream stream = ElementCounter.class.getResource("Books.xml").openStream();
        Document doc = dbbuilder.parse(stream);
//        System.out.println(doc.getNodeName() + " : "+doc.getChildNodes().item(1).getTextContent());
//
        NodeList list = doc.getChildNodes().item(1).getChildNodes().item(1).getChildNodes();
        IntStream.range(0,list.getLength()).forEach(idx ->{
            System.out.println(list.item(idx).getNodeName() + ":" + list.item(idx).getAttributes());
        });
        print(list.item(1));
    }
}
