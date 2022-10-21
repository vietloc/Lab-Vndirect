import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class DbFunction {
    public static void getAge(String name, int[] ages) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        try{
            File file = new File("./sampledb");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby: " + file.getAbsolutePath()+"; create = true");
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select max(age) from student where name like '%" +name +"%'");
            ages[0] = rs.next()?rs.getInt(1):-1;
        } finally {
            connection.close();
        }
        }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int[] ages =new int[1];
        getAge("Thi Z", ages);
        System.out.print(ages[0]);
    }
}
