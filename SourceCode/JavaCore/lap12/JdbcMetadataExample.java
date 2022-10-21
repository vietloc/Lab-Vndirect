import java.io.File;
import java.sql.*;

public class JdbcMetadataExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = null;
//        Statement statement =null;
        try{
            //setup driver
            File file = new File("./sampledb");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            //creat connection
            connection = DriverManager.getConnection("jdbc:derby: " + file.getAbsolutePath()+"; create = true");
//            statement = connection.createStatement();
            DatabaseMetaData metaData =connection.getMetaData();

            System.out.println("db version " + metaData.getDatabaseMajorVersion());
            System.out.println("driver name "+ metaData.getDriverName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
