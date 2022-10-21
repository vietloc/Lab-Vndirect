import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public class BookMapper extends DefaultHandler {
    private List<Book> list;
    private Book book;

    public  BookMapper(List<Book> list){
        this.list = list;
    }

    private String lastElementName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("book".equals(qName)){
            book = new Book();
            book.setPage(Integer.parseInt(attributes.getValue("page")));
//            book.setPrice(Float.parseFloat(attributes.getValue("price")));
            list.add(book);
        }else {
            lastElementName = qName;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);

        //in ra author
//        if("author".equals(lastElementName)){
//            System.out.println("----- >" +value);
//        }
        if(value.trim().isEmpty()){
            return;
        }
        switch (lastElementName){
            case "author":
                book.setAuthor(value);
                break;
            default:
                break;
        }
    }
}
