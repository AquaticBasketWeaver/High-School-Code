/**
 * 
 */

/**
 * @name Ivan Lam
 * @Teacher Mr. Reid
 * @Course ICS4U1
 * @DATE MAY 11, 2016
 */
public class Student {
	
	//Creates attributes of the student
	String lastname;
	private String firstname;
	private String gender;
	private String studentID;
	private String dob;
	private String courses;
	
	public Student(String[] info){
		
		//Instantiates attributes of the student within the constructor
		this.lastname = info[0];
		this.firstname = info[1];
		this.gender = info[2];
		this.studentID = info[3];
		this.dob = info[4];
		this.courses = info[5];
	}
	
	public String getLastname(){
		
		//Gets the last name
		return lastname;
	}
	
	public String getGender(){
		
		//Gets last name
		return gender;
	}
	
	public String getCourses(){
		
		//Gets course
		return courses;
	}
	
	public String toString(){
		
		//Returns pieces of the attributes in a line and as a string
		return (lastname + "," + firstname + "," + gender + "," + studentID + "," + dob + "," + courses);
	}
	
}
