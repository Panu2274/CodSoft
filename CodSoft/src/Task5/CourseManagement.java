package Task5;

import java.util.ArrayList;
import java.util.List;

public class CourseManagement {
    private List<RegisteredStudent> registeredStudents = new ArrayList<>();


    public Course register(Course course, Student student) {
        
        for (RegisteredStudent regStudent : registeredStudents) {
            if (regStudent.getStudent().getStudentID() == student.getStudentID() &&
                regStudent.getCourse().getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
                System.out.println("Student " + student.getName() + " is already registered for " + course.getTitle() + ".");
                return course;
            }
        }

        
        if (course.getCapacity() > 0) {
            registeredStudents.add(new RegisteredStudent(student, course));
            course.setCapacity(course.getCapacity() - 1); // Decrease available seats
            System.out.println("Student " + student.getName() + " registered for " + course.getTitle() + ".");
        } else {
            System.out.println("Registration failed. Course " + course.getTitle() + " is full.");
        }
        return course;
    }

    
    public void dropCourse(String courseCode, Student student) {
        boolean found = false;

        for (RegisteredStudent regStudent : registeredStudents) {
            if (regStudent.getStudent().getStudentID() == student.getStudentID() &&
                regStudent.getCourse().getCourseCode().equalsIgnoreCase(courseCode)) {
                
                registeredStudents.remove(regStudent);
                regStudent.getCourse().setCapacity(regStudent.getCourse().getCapacity() + 1); // Increase available seats
                System.out.println("Student " + student.getName() + " dropped from " + regStudent.getCourse().getTitle() + ".");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student " + student.getName() + " is not registered for the course " + courseCode + ".");
        }
    }

    
    public static void displayCourses(List<Course> courses) {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-40s   | %-70s | %-10s | %-15s|\n", "Course Code", "Title", "Description", "Capacity", "Schedule");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Course course : courses) {
            System.out.printf("%-10s  | %-42s | %-70s | %-10d | %-15s|\n", 
                course.getCourseCode(), 
                course.getTitle(), 
                course.getDescription(), 
                course.getCapacity(), 
                course.getSchedule());
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    
    public void displayRegisteredStudents(String courseCode) {
        System.out.println("Students registered for course: " + courseCode);
        System.out.println("---------------------------------------------");
        System.out.printf("%-10s | %-30s |\n", "Student ID", "Name");
        System.out.println("---------------------------------------------");

        for (RegisteredStudent regStudent : registeredStudents) {
            if (regStudent.getCourse().getCourseCode().equalsIgnoreCase(courseCode)) {
                System.out.printf("%-10d | %-30s |\n", regStudent.getStudent().getStudentID(), regStudent.getStudent().getName());
            }
        }
        System.out.println("---------------------------------------------");
    }
}
