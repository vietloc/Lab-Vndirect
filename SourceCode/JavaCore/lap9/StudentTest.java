
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {
    public static List<Student>filter(List<Student>students,Filter<Student>pred){
        List<Student>list = new ArrayList<Student>();
        // Student[] students = null;
        for(Student s: students){
            if(pred.valid(s)){
                list.add(s);
            }
        }
        return list;       
    }
    public static void main(String[] args) {
        ArrayList students = new ArrayList<>();

        students.add(new Student("Tran Van A",23));
        students.add(new Student("Nguyen Thi B",34));
        students.add(new Student("Nguyen Thi C",15));
        students.add(new Student("Ta Van C", 46));

        // Filter<Student>older = s -> s.getAge()>=30;
        // List filtered = filter(students, older);

        // for(Student student : (List<Student>) filtered){
        //     System.out.println(student);
        // }
        // Stream<Student> stream = students.stream().filter(student->((Student) student).getAge()>=30);
        // stream.forEach(student->System.out.println(student));

        // Collections.sort(students,(Student student1,Student student2)->student1.getAge() - student2.getAge());
        //     students.forEach(student->System.out.println(student));

        Stream<Student>stream = students.stream().sorted((student1, student2)->((Student)student1).getAge()-((Student)student2).getAge());
        System.out.println(stream);
    }
}
