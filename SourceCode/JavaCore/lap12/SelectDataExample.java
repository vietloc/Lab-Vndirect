import java.io.File;
import java.sql.*;

public class SelectDataExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        Connection connection = null;
        Statement statement;
        ResultSet rs = null;
        try {
            File file = new File("./sampledb");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby: " + file.getAbsolutePath() + "; create = true");
            statement = connection.createStatement();

            rs = statement.executeQuery("select * from student");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt(3);
                
                System.out.println(id + "\t" + name + "\t"+ age);
            }
        } finally {
            rs.close();
            connection.close();
        }
    }
}
