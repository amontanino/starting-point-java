package it.xpug.fittizia;

public class Attendant {

	private String firstName;
	private String lastName;
	private String email;
	private String courseId;
	private int numOfAttendants;
	private boolean company;

	public static final String COURSE_ID = "course_id";
	public static final String FIRST_NAME = "first_name";
	public static final String LAST_NAME = "last_name";
	public static final String EMAIL = "email";
	public static final String NUM_ATTENDANTS = "num_attendants";
	public static final String IS_COMPANY = "is_company";

	public static final int SINGLE_ATTENDANT = 1;

	public Attendant(String firstName, String lastName, String email,
			String courseId, int numOfAttendants, boolean isCompany) {
		super();
		if (!isCompany) {
			forceNumOfAttendants();
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courseId = courseId;
		company = isCompany;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getNumOfAttendants() {
		return numOfAttendants;
	}

	public boolean isCompany() {
		return company;
	}

	public void forceNumOfAttendants() {
		this.numOfAttendants = SINGLE_ATTENDANT;
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
