import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XMLFilterStripper extends DefaultHandler {
    List<Book> list = new ArrayList<>();
    BookMapper mapper = new BookMapper(list);

    public XMLFilterStripper(BookMapper mapper) {
    }

    public String constructor(BookMapper mapper){
        this.mapper = mapper;
        return null;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("booktitle" == qName) return;
        mapper.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        mapper.characters(ch, start, length);
    }
}
