package Task5;

public class RegisteredStudent {
    private Student student;
    private Course course;

    public RegisteredStudent(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}
