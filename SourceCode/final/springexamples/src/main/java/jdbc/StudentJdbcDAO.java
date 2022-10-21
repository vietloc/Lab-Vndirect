package jdbc;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcDAO {
    public void setUpdateAgeByNameSQL(String updateAgeByNameSQL) {
        this.updateAgeByNameSQL = updateAgeByNameSQL;
    }

    public void setDeleteAgeByNameSQL(String deleteAgeByNameSQL) {
        this.deleteAgeByNameSQL = deleteAgeByNameSQL;
    }

    private final static class StudentRowMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            try{
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                return student;
            } catch (Exception e){
                LOGGER.error(e, e);
                return null;
            }
        }
    }

    private String updateAgeByNameSQL = "update name where age = ?";

    public void updateAgeByName(String name,int age){
        this.jdbcTemplate.update(updateAgeByNameSQL,name,age);
        LOGGER.info("Update Name = " +name + " Age = "+age);
    }

    private String deleteAgeByNameSQL = "delete FROM Student where name = ?";

    public void deleteAgeByName(String name){
        this.jdbcTemplate.update(deleteAgeByNameSQL,name);
        LOGGER.info("Delete name = " + name);
    }

    public List loadStudent(String name){
        return jdbcTemplate.query("SELECT * FROM STUDENT WHERE NAME LIKE '%" +name + "%'", new StudentRowMapper());
    }

    public String getUpdateAgeByNameSQL() {
        return updateAgeByNameSQL;
    }

    public String getDeleteAgeByNameSQL() {
        return deleteAgeByNameSQL;
    }

    public String getInsertQuery() {
        return insertQuery;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    private String insertQuery;

    public void insert(String name, Integer age){
        jdbcTemplate.update(insertQuery, name, age);
        LOGGER.info("Create Record Name = " + name + " Age = "+age);
    }
    private final static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);


    public static Logger getLOGGER() {
        return LOGGER;
    }

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private void createTableIfNotExist() throws SQLException {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "STUDENT", null);
        if(rs.next()){
            LOGGER.info("table " + rs.getString("TABLE_NAME")+" already exists!");
            return;
        }

        jdbcTemplate.execute("CREATE TABLE STUDENT (" + " id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," + " name VARCHAR(1000)," + " age INTEGER)");
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }

    public int totalRecord(){
//        return jdbcTemplate.execute(new StatementCallback<Integer>() {
//            @Override
//            public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
//                ResultSet rs = statement.executeQuery("select count(*) from student");
//                return rs.next() ? rs.getInt(1) : 0;
//            }
//        });
        return jdbcTemplate.execute((Statement statement) ->{
           ResultSet rs = statement.executeQuery("select count(*) from student") ;
           return rs.next()? rs.getInt(1) : 0;
        });
    }
    public int[] add(List<Student> students){
        List<Object[]> batch = new ArrayList<>();

        students.forEach(student -> batch.add(new Object[]{student.getName(),student.getAge()}));
        return jdbcTemplate.batchUpdate(insertQuery,batch);
    }

    @Autowired
    private PlatformTransactionManager transactionManager;

    public void save(Object name, Object age){
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        String countQuery = "SELECT COUNT (*) FROM STUDENT";
        try{
            Integer total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("before save data, total record is " + total);

            String sql = "insert into Student (name, age) values ( ? , ? )";
            jdbcTemplate.update(sql, name, age);

            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("after save data, total record is " + total);

            String countQuery2 = "SELECT COUNT(* FROM STUDENT";
            total = jdbcTemplate.queryForObject(countQuery2, Integer.class);

            transactionManager.commit(status);
        } catch (Exception e){
            //error(e, e);
            transactionManager.rollback(status);

            Integer total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("after rollback, total record is " + total);
            //throw exp
        }
    }

}
