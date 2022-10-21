import java.io.File;
import java.sql.*;

public class UpdateDataExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;


        try {
            File file = new File("./sampledb");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby: " + file.getAbsolutePath() + "; create = true");

            PreparedStatement statement = connection.prepareStatement("UPDATE Student SET Name = ? WHERE ID = ?");
            statement.setString(1,"Le Thi Z");
            statement.setInt(2, 2);
            statement.executeUpdate();
        } finally {
            connection.close();
        }
    }
}
