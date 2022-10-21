import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.IntStream;

public class DataAccessTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DataAccessLogic data = new DataAccessLogic();
        System.out.println("Page 1:");
        List<String> names = data.loadNames(1);
//        System.out.println("Page 2:");
//        names = data.loadNames(2);
        names.forEach(System.out::println);
        System.out.println("total page = " + data.numberOfPage());

        IntStream.range(1,data.numberOfPage()+1).forEach(page ->{
            System.out.println("================ " + page);
            List<String> namesz = null;
            try {
                namesz = data.loadNames(page);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println(namesz);
        });
    }
}
