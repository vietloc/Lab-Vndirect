package maven;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener()

public class SimpleServletListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("\n\n ServletContextListener destroyed\n\n");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        File file = new File("./userdb");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection connection = DriverManager.getConnection("jdbc:derby: " + file.getAbsolutePath() + "; create = true");
            System.out.println("\n\nServletContextListener started\n\n");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

