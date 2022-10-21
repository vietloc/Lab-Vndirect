import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;

public class ElementCounter extends DefaultHandler {
    private int counter = 0;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(" start element -----" +qName);
        //dem so book
        if("book".equals(qName)) counter++;
    }
    //in ra so book
    @Override
    public void endDocument() throws SAXException {
        //in ra so book tim thay
        System.out.println("Found " + counter + " book elements in the document!");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        ContentHandler handler = new ElementCounter();
        parser.setContentHandler(handler);
        InputStream stream = ElementCounter.class.getResource("Books.xml").openStream();
        parser.parse(new InputSource(stream));
        System.out.println("done");
    }

    //lay ra du lieu
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(" text data = | " + new String(ch, start, length) + "|");
    }
}
