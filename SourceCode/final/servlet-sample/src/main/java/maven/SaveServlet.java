package maven;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.Writer;
//import java.sql.*;
//import static java.sql.DriverManager.getConnection;
////import static jdk.internal.net.http.Http2ClientImpl.getParameter;
//
//@WebServlet(value = "/save" , name="save")
//
//public class SaveServlet extends HttpServlet {
//    Connection connection = null;
//    Statement statement = null;
//
//    public void init(ServletConfig config) {
//        try {
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//            try {
//                connection = getConnection("jdbc:derby:C:/servlet-sample/userdb; create = true");
//                statement = connection.createStatement();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            DatabaseMetaData dmd = connection.getMetaData();
//            ResultSet rs = dmd.getTables(null, null, null, new String[]{"TABLE"});
//
//            if(rs.next() && "hanoi_user".compareTo(rs.getString("TABLE_NAME"))==0){
//                return;
//            }
//            statement.execute("create  table  hanoi_user(username varchar(500), password varchar(500), email varchar(1000))");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String user = req.getParameter("username");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
//
//        String sql = "insert into hanoi_user" + "(username, password, email) values"
//                + "('" + user + "','" + password + "','" + email + "')";
//
//        try{
//            statement.execute(sql);
////            RequestDispatcher dispatcher = req.getRequestDispatcher("register.html");
//            RequestDispatcher dispatcher = req.getRequestDispatcher("view-users.jsp");
//
//            dispatcher.forward(req, resp);
//        } catch (Exception e){
//            e.printStackTrace(resp.getWriter());
//        }
////        dispatcher.forward(req,resp);
//    }
//
//    @Override
//    public void destroy() {
//        try {
//            getConnection("jdbc:derby:C:/Servlet-sample/userdb;shutdown=true");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write("dmm");
//    }
//}
import maven.ConnectionSQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.*;

@WebServlet(value = "/save", name = "register")
public class SaveServlet extends HttpServlet {
    private Connection connection;
    private Statement statement;
    @Override
    public void init() throws ServletException {
        File file = new File("./user_db");

        try {
            connection = ConnectionSQL.getSingeltonPatern().getConnection();
            statement= connection.createStatement();
            DatabaseMetaData dmd = connection.getMetaData();
            ResultSet rs = dmd.getTables(null,null,null,new String[]{"TABLE"});
            if (rs.next() && rs.getString("TABLE_NAME").compareTo("HANOI_USER") == 0) return;
            statement.executeUpdate("create table hanoi_user(username varchar(500) , password varchar(500), email varchar(1000))");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("./user_db");
        String user = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        System.out.println(file.getAbsolutePath());
        String sql = "INSERT INTO hanoi_user(username, password, email) values('"+user+"','"+password+"','"+email+"')";
        try {
            statement.execute(sql);
//            resp.getWriter().write("Register Successfull");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view-users.jsp");

            dispatcher.forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace(resp.getWriter());
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String username = req.getParameter("username");
        if (action==null || username==null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view-users.jsp");
            dispatcher.forward(req,resp);
        }else{

            if (action.compareTo("del")==0){
                String sql = "delete from hanoi_user where username = '"+username+"'";
                try {
                    Statement statement1 = connection.createStatement();
                    statement1.execute(sql);
                    statement1.close();

                    RequestDispatcher dispatcher = req.getRequestDispatcher("/view-users.jsp");
                    dispatcher.forward(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}