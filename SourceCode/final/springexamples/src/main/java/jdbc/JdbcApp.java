package jdbc;


import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcApp {

    private final static Logger LOGGER = Logger.getLogger(JdbcApp.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
        LOGGER.info(" created bean" +jdbc);
        jdbc.insert("Vu Van D", 12);
        jdbc.insert("Nguyen Thi D", 8);
        jdbc.insert("Truong Van A", 22);
        jdbc.insert("Le Thi D", 16);
        LOGGER.info("Total students is " + jdbc.totalRecord());
        jdbc.updateAgeByName("Tran Van B",24);
        jdbc.deleteAgeByName("Le Thi D");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tran Thi A", 17));
        students.add(new Student("Le Van L", 20));
        students.add(new Student("Phan Thi Z", 25));

        int[] values = jdbc.add(students);
        for (int i=0; i < values.length; i++){
            LOGGER.info("add record "+ i + " : " + (values[i] == 0 ? "failed" : "success"));
        }

        LOGGER.info("Total students is " + jdbc.totalRecord());
        jdbc.save("Tran Thi A", "23");
        jdbc.loadStudent("").forEach(student -> LOGGER.info(student));
    }
}
