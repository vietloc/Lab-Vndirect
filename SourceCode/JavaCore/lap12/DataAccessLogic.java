import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessLogic {
    private  final  static Logger logger = Logger.getLogger(DataAccessLogic.class.getName());
    Connection connection = null;
    CachedRowSet rowSet;

    public DataAccessLogic() throws ClassNotFoundException, SQLException {
        //setup driver
        File file = new File("./sampledb");
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        this.connection = DriverManager.getConnection("jdbc:derby: " + file.getAbsolutePath()+"; create = true");

        rowSet = RowSetProvider.newFactory().createCachedRowSet();
        rowSet.setCommand("select * from student");
        rowSet.execute(connection);
    }

    public void Disconnect() throws SQLException {
        try{
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e){
            logger.log(Level.WARNING, e.toString());
        }
    }

    //10 tên 1 trang
    int pageSize = 10;

    List<String>loadNames(int page) throws SQLException {
        List<String> names = new ArrayList<>();
        rowSet.setPageSize(pageSize);
        int start = (page - 1) * pageSize +1;
        if(!rowSet.absolute(start)){
            return names;
        }
        rowSet.previous();
        while (rowSet.next()){
            names.add(rowSet.getString("name"));
            if(names.size()>=pageSize){
                break;
            }
        }
        return names;
    }
    public int numberOfPage() throws SQLException {
        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(*) from student");
            if(!rs.next()){
                return  0;
            }
            int total = rs.getInt(1);
            int totalPage =total/pageSize;
            if(total%pageSize != 0){
                totalPage++;
            }
            return totalPage;
        } finally {
            statement.close();
        }
    }

}
