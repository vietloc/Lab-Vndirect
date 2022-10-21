package edu.java.spring;

import edu.java.spring.controller.Student;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "clazz")
public class JavaClazz {
    private List<Student> students;

    public JavaClazz(List<Student> students) {
        this.students = students;
    }

    @XmlElements(@XmlElement(name = "student", type = Student.class))
    public List<Student> getStudents(){
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
