import org.xml.sax.*;
import org.xml.sax.helpers.ParserAdapter;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class BookMapperTest {
    public static void main(String[] args) throws IOException, SAXException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        List<Book> list = new ArrayList<>();
        BookMapper mapper = new BookMapper(list);
        parser.setContentHandler(new XMLFilterStripper(mapper));
        InputStream stream = ElementCounter.class.getResource("Books.xml").openStream();
        parser.parse(new InputSource(stream));
        System.out.println("found ---> " + list.size());
        list.forEach(book -> System.out.println(book));
        parser.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {

            }

            @Override
            public void error(SAXParseException exception) throws SAXException {

            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("1=======> " + exception.getMessage());
            }
        });
    }
}
