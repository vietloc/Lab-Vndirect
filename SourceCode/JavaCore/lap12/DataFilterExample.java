import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.File;
import java.sql.SQLException;

public class DataFilterExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        File file = new File("./sampledb");
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        FilteredRowSet filteredRowSet = RowSetProvider.newFactory().createFilteredRowSet();
        filteredRowSet.setUrl("jdbc:derby:" + file);

        filteredRowSet.setCommand("select * from student");
        filteredRowSet.setFilter(new DataFilter());
        filteredRowSet.execute();

        System.out.println("ID\tName\t\tAge");
        while (filteredRowSet.next()){
            System.out.println(filteredRowSet.getString("id")+"\t"+filteredRowSet.getString("name")+"\t"+ filteredRowSet.getInt("age"));
        }
    }
}
