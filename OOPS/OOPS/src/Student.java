import java.util.Arrays;

public class Student {
    public static void main(String[] args) {
        Student1 student1 = new Student1(1, "omkar", 9.6f);
        Student1 student2 = student1;
        System.out.println(student2.name);
    }
}

/**
 * Student
 */
class Student1 {
    int rno;
    String name;
    float marks;


    public Student1(int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    public static void main(String[] args) {
        Student1 foo = new Student1(1, "sf", 2.2f);
        System.out.println(foo.getClass().getName());
    }
    
}