import java.util.ArrayList;

public class CollectionAndIO {
    public String name;
    public int old;

    public CollectionAndIO(String name, int old) {
        this.name = name;
        this.old = old;
    }

    @Override
    public String toString() {
        return this.name + "-" + this.old;
    }
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        
        studentList.add(new Student("Anh", 20));
        studentList.add(new Student("Tốt", 21));
        studentList.add(new Student("Bạn", 19));
        studentList.add(new Student("Lắm", 2));
        
        System.out.println(studentList);
}
}
