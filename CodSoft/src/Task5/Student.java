package Task5;



//Store student information, including student ID, name, and
//registered courses.
public class Student {

	 private int studentID;
	 private String name;
	 Course c;   

	    public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getC() {
		return c;
	}

	public void setC(Course c) {
		this.c = c;
	}
}
