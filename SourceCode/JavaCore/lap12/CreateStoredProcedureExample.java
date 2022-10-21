import java.io.File;
import java.sql.*;

public class CreateStoredProcedureExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        try{
            File file = new File("./sampledb");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby: " + file.getAbsolutePath()+"; create = true");
            statement = connection.createStatement();

            statement.executeUpdate("CREATE PROCEDURE GETAGE(STREAM_NAME VARCHAR(255), OUT AGE INT)"+" PARAMETER STYLE JAVA READS "+" SQL DATA LANGUAGE JAVA EXTERNAL NAME "+" 'jdbc.DbFunction.getAge' ");
            System.out.print("done");

        } finally {
            connection.close();
        }
    }
}
