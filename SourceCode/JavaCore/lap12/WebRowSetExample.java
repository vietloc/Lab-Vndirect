import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class WebRowSetExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Connection connection = null;
        Statement statement = null;
        try{
            File file = new File("./sampledb");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby: " + file.getAbsolutePath()+"; create = true");
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from student");

            file = new File("output.xml");
            FileWriter writer = new FileWriter(file);
            WebRowSet webRowSet = RowSetProvider.newFactory().createWebRowSet();
            webRowSet.writeXml(rs, writer);

            Desktop.getDesktop().open(file);
        } finally {
            statement.close();
            connection.close();
        }
    }
}
