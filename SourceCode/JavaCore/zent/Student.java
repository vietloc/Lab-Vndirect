import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    public String name;
    public int old;

    public Student(String name, int old) {
        this.name = name;
        this.old = old;       
    }

    @Override
    public String toString() {
        return this.name + "-" + this.old;
    }
    public static Comparator<Student> compare = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return (o1.name).compareTo(o2.name);
        }
    };
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        
        studentList.add(new Student("Anh", 20));
        studentList.add(new Student("Tốt", 21));
        studentList.add(new Student("Bạn", 19));
        studentList.add(new Student("Lắm", 2));
        
        System.out.println(studentList);
        Collections.sort(studentList,Student.compare);
        
        System.out.println("List sau sắp xếp: " + studentList);
}
}
