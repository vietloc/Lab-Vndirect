public class Student {
    private int id;

    private int age;

    public String name;

    public Student(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Student(String name,int age){
        id = (int) (Math.random()*1000);
        this.age = age;
        this.name = name;
    }

    public String toString(){
        return id + ":"+name+":"+age;
    }

}
