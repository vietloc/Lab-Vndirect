import java.io.File;
import java.sql.*;

public class TransactionExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try{
            File file = new File("./sampledb");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby: " + file.getAbsolutePath()+"; create = true");
            statement = connection.createStatement();

            connection.setAutoCommit(false);
            for(int i = 0; i < 10; i++){
                String name = "Tran Van "+i;
                int age = 10 + i;
                statement.executeUpdate("insert into student (name, age) values " + "('"+name+"',"+age+")");
            }
        } finally {
            connection.rollback();
            connection.setAutoCommit(true);
            rs = statement.executeQuery("select count(*) from student");
            if(rs.next()){
                System.out.println("total records = "+rs.getInt(1));
        }
            connection.close();

        }
    }
}
