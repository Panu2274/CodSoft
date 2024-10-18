package Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

    	System.out.println("*** Course Registration System ***");
        try (Scanner sc = new Scanner(System.in)) {

            CourseManagement cm = new CourseManagement();
            List<Course> courseList = new ArrayList<>();
            List<Student> studentList = new ArrayList<>();


            Course c1 = new Course();
            c1.setCourseCode("CS101");
            c1.setTitle("Introduction to Computer Science");
            c1.setDescription("Learn the basics of programming");
            c1.setSchedule("Mon/Wed 10-12");
            c1.setCapacity(5);
            courseList.add(c1);

            Course c2 = new Course();
            c2.setCourseCode("CS102");
            c2.setTitle("Data Structures");
            c2.setDescription("Study data organization and storage");
            c2.setSchedule("Tue/Fri 10-12");
            c2.setCapacity(3);
            courseList.add(c2);

            
         
            Course c3 = new Course();
            c3.setCourseCode("CS103");
            c3.setTitle("Algorithms");
            c3.setDescription("Study of algorithms and their complexities");
            c3.setSchedule("Mon/Wed 14-16");
            c3.setCapacity(4);
            courseList.add(c3);

            
            Course c4 = new Course();
            c4.setCourseCode("CS104");
            c4.setTitle("Operating Systems");
            c4.setDescription("Learn about modern operating systems and process management");
            c4.setSchedule("Tue/Thu 10-12");
            c4.setCapacity(5);
            courseList.add(c4);

            
            Course c5 = new Course();
            c5.setCourseCode("CS105");
            c5.setTitle("Database Management Systems");
            c5.setDescription("Introduction to relational databases and SQL");
            c5.setSchedule("Wed/Fri 12-14");
            c5.setCapacity(6);
            courseList.add(c5);

          
            Course c6 = new Course();
            c6.setCourseCode("CS106");
            c6.setTitle("Computer Networks");
            c6.setDescription("Fundamentals of data communication and networking protocols");
            c6.setSchedule("Mon/Wed 16-18");
            c6.setCapacity(3);
            courseList.add(c6);

            Course c7 = new Course();
            c7.setCourseCode("CS107");
            c7.setTitle("Artificial Intelligence");
            c7.setDescription("Introduction to AI concepts and machine learning techniques");
            c7.setSchedule("Tue/Thu 14-16");
            c7.setCapacity(5);
            courseList.add(c7);


            
            Student s1 = new Student();
            s1.setStudentID(101);
            s1.setName("Alice Smith");
            studentList.add(s1);

            Student s2 = new Student();
            s2.setStudentID(102);
            s2.setName("Bob Johnson");
            studentList.add(s2);

            Student s3 = new Student();
            s3.setStudentID(103);
            s3.setName("Carlos Martinez");
            studentList.add(s3);

            Student s4 = new Student();
            s4.setStudentID(104);
            s4.setName("Diana Roberts");
            studentList.add(s4);

            Student s5 = new Student();
            s5.setStudentID(105);
            s5.setName("Ethan Brown");
            studentList.add(s5);

            Student s6 = new Student();
            s6.setStudentID(106);
            s6.setName("Fiona Taylor");
            studentList.add(s6);

            Student s7 = new Student();
            s7.setStudentID(107);
            s7.setName("George Clark");
            studentList.add(s7);

            Student s8 = new Student();
            s8.setStudentID(108);
            s8.setName("Hannah Lee");
            studentList.add(s8);

            Student s9 = new Student();
            s9.setStudentID(109);
            s9.setName("Isabella Singh");
            studentList.add(s9);

            Student s10 = new Student();
            s10.setStudentID(110);
            s10.setName("Jack Patel");
            studentList.add(s10);

            int choice;
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Show Available Courses");
                System.out.println("2. Display Students");
                System.out.println("3. Register for a Course");
                System.out.println("4. Display Registered Students for a Course");
                System.out.println("5. Drop a Course");
                System.out.println("6. Exit");
                System.out.print("\nEnter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        cm.displayCourses(courseList);
                        break;

                    case 2:
                        System.out.println("Student List:");
                        System.out.println("-----------------------------------");
                        System.out.printf("%-10s  | %-20s|\n", "ID", "Name");
                        System.out.println("-----------------------------------");
                        for (Student student : studentList) {
                            System.out.printf("%-10d  | %-20s|\n", student.getStudentID(), student.getName());
                            System.out.println("-----------------------------------");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Student ID: ");
                        int studentID = sc.nextInt();
                        Student student = findStudentByID(studentList, studentID);
                        if (student == null) {
                            System.out.println("Student not found!");
                            break;
                        }

                        System.out.print("Enter Course Code: ");
                        String courseCode = sc.next();
                        Course course = findCourseByCode(courseList, courseCode);
                        if (course != null) {
                            cm.register(course, student);
                            System.out.println("\nUpdated Course List:");
                            cm.displayCourses(courseList);
                        } else {
                            System.out.println("Course not found!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Course Code to view registered students: ");
                        String code = sc.next();
                        cm.displayRegisteredStudents(code);
                        break;

                    case 5:
                        System.out.print("Enter Student ID: ");
                        studentID = sc.nextInt();
                        student = findStudentByID(studentList, studentID);
                        if (student == null) {
                            System.out.println("Student not found!");
                            break;
                        }

                        System.out.print("Enter Course Code: ");
                        courseCode = sc.next();
                        cm.dropCourse(courseCode, student);
                        System.out.println("\nUpdated Course List:");
                        cm.displayCourses(courseList);
                        break;

                    
                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    private static Student findStudentByID(List<Student> students, int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseByCode(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
