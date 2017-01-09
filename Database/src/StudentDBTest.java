import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @name Ivan Lam
 * @Teacher Mr. Reid
 * @Course ICS4U1
 * @DATE MAY 11, 2016
 */
public class StudentDBTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//Creates scanner object and student data base object
		Scanner sc  = new Scanner(System.in);
		StudentDatabase sdb = new StudentDatabase();
		
		//Reads from student data base file
		sdb.readStudentDataBase("StudentData.txt");
		
		sdb.bubbleSort();
		//sdb.selectSort();
		
		sdb.saveStudentDataBase("StudentDataO.txt");
		
		/*
		System.out.println(sdb.getNumFemaleStudents() + " number of female students");
		
		System.out.println("Enter Course: ");
		String course = sc.nextLine();
		System.out.println(sdb.getNumStudentsByCourse(course) + " number of students in " + course);
		
		
		
		System.out.println("Enter search: ");
		String search = sc.nextLine();
		for (int i = 0; i < sdb.search(search).split("~").length; i++){
			System.out.println(sdb.search(search).split("~")[i]);	
		}
		*/
			
	}

}
