package maven;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/j_security_check", name ="/j_security_check" )


public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("j_username");
        String password = req.getParameter("j_password");
        try{
            req.login(username,password);
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/html");
            RequestDispatcher dispatcher = req.getRequestDispatcher("hello.jsp");
            req.setAttribute("say","Hi Ha Noi!");
            dispatcher.forward(req,resp);
        } catch (Exception e){
            resp.getWriter().write("Sorry! Login failed!");
            e.printStackTrace(resp.getWriter());
        }
    }
}
