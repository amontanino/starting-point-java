package it.xpug.fittizia;

public class Attendant {
	private String firstName;
	private String lastName;
	private String email;
	private String courseId;
	
	public static final String COURSE_ID = "course_id";
	public static final String FIRST_NAME = "first_name";
	public static final String LAST_NAME = "last_name";
	public static final String EMAIL = "email";
	
	public Attendant(String courseId, String firstName, String lastName, String email) {
		this.courseId = courseId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getEmail() {
		return email;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
	
	

}
