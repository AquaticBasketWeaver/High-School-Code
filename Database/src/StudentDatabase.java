import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
public class StudentDatabase {
	
	//Creates attributes of the studentDatabase
	private Student students[];
	private boolean sorted;
	private int numStudents;
	
	public StudentDatabase(){
		
		//instantiates variables in the constructor
		//2104 students
		this.numStudents = 2104;
		this.students = new Student[numStudents];
		this.sorted = false;
	}
	
	public void readStudentDataBase(String filename) throws FileNotFoundException{
		
		//creates scanner object and reads from file, placing each line in next index of students array
		Scanner sc = new Scanner(new FileReader(filename));  
		for (int i = 0; i < numStudents; i++){
			this.students[i] = new Student(sc.nextLine().split(","));
			
		}
	}
	
	public void saveStudentDataBase(String filename) throws IOException{
		/*
		PrintWriter pw = new PrintWriter(new FileWriter(filename));
		for (int i = 0; i < numStudents; i++){
			pw.println(students[i].toString());
		}
		pw.flush();
		pw.close();
		*/
		
		//Outputs each line of students array into the console
		for (int i = 0; i < numStudents; i++){
			System.out.println(students[i].toString());
		
		}
		
		
	}
	
	public void bubbleSort(){
		
		//Creates the order of the alphabet
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		//Creates the temporary memory holder for memory swap
		Student memoryHolder = null;
		
		//Instantiates current index, how many times loop has gone through, and if a change has been made
		int index = 0;
		int loopcount = 0;
		boolean change = false;
		int length = 0;
		boolean swap = false;
		
		//Loops while not sorted
		while (sorted!=true){
			
			//Instantiates the 2 names that need to be compared
			String name1 = students[index].getLastname().toUpperCase();
			String name2 = students[index + 1].getLastname().toUpperCase();
			
			//If first letters are not in order, sets swap to true
			if (alphabet.indexOf(name1.charAt(0)) > alphabet.indexOf(name2.charAt(0))){
				swap = true;
			}
			else{
				
				//gets the length of the shortest lastname
				if (name1.length() < name2.length()){
					length = name1.length();
				}
				else {
					length = name2.length();
				}
				
				//Loops for duration of length of shortest last name
				for (int j = 0; j < length; j++){	
					
					//goes through all letters in last name and swaps if necessary
					if (alphabet.indexOf(name1.charAt(j)) < alphabet.indexOf(name2.charAt(j))){
						j = length;
					}
					else if (alphabet.indexOf(name1.charAt(j)) > alphabet.indexOf(name2.charAt(j))){
						j = length;
						swap = true;
					}
					else if (j == length - 1){
						if (name2.length() < name1.length()){
							swap = true;
						}
					}
				}
			}
			
			//Does swap here
			if (swap == true){
				memoryHolder = this.students[index];
				this.students[index] = this.students[1 + index];
				this.students[1 + index] = memoryHolder;
				change = true;
				swap = false;
			}
			
			//Goes to the next index
			index++;
			
			//Determines if need to go through last names again or ends loop
			if (index == (numStudents - 1 - loopcount)){
				index = 0;
				loopcount++;
				if (change == false){
					sorted = true;
				}
				change = false;
			}
		}
	}
	
	public void selectSort(){
		
		//Sets the order of alphabet, and creates piece of memory to swap data
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Student memoryHolder;
		
		//Instantiates a counter holder, the index, the highest index, and the while loop counter
		int highestIndex = 0;
		int index = 0;
		int loopcount = 1;
		int length = 0;
		String highName = "a";
		
		//Runs following code as long as not sorted
		while (sorted != true){
			
			//Instantiates the last name
			String name = students[index].getLastname().toUpperCase();
			
			//Checks if "highest" alphabet or not, and holds the new highest alphabet and its index if it is
			if (alphabet.indexOf(name.charAt(0)) > alphabet.indexOf(highName.charAt(0))){
				highestIndex = index;
				highName = name;
			}
			else {
				
				//gets the length of the shortest last name
				if (name.length() < highName.length()){
					length = name.length();
				}
				else {
					length = highName.length();
				}
				
				//Loops for duration of length of shortest last name
				for (int j = 0; j < length; j++){	
					
					//goes through all letters in last name and swaps if necessary
					if (alphabet.indexOf(name.charAt(j)) < alphabet.indexOf(highName.charAt(j))){
						j = length;
					}
					else if (alphabet.indexOf(name.charAt(j)) > alphabet.indexOf(highName.charAt(j))){
						j = length;
						highestIndex = index;
						highName = name;
					}
					else if (j == length - 1){
						if (highName.length() < name.length()){
							highestIndex = index;
							highName = name;
						}
					}
				}
				
			}
			
			
			//runs if index is equal to the number of students, less the times the while loop has run
			if (index == (numStudents  - loopcount)){
				
				//takes last index, and swap it with highest index
				memoryHolder = this.students[highestIndex];
				this.students[highestIndex] = this.students[index];
				this.students[index] = memoryHolder;
				
				//Sets the index back to 0, the count hold back to 0, increases the while loop count
				//and resets the name highest in the alpahebt 
				index = 0;
				highestIndex = 0;
				highName = "a";
				loopcount++;
				
				//Once while loop count is equal to the number of students, sets sorted to true
				if (loopcount == numStudents){
					sorted = true;
				}
			}
			else {
				
				//goes to next index
				index++;
			}
		}
	}
	
	public String displayStudents(){
		return null;
	}
	
	public int getNumFemaleStudents(){
		
		//instantiates the counter and initial index for student array
		int counter = 0;
		int index = 0;
		
		//loops through gender portion of student object, and adds to counter whenever female is found
		while(index != numStudents){
			if (students[index].getGender().equals("F")){
				counter++;
			}
			index++;
		}
		//returns the counter, which represents how many females there are
		return counter;
	}
	
	public int getNumStudentsByCourse(String course){
		
		//instantiates counter and the index for student array
		int counter = 0;
		int index = 0;	
		
		//gets course from parameter and creates array to hold each students 4 courses
		String inputCourse = course;
		String[] courses = new String[4];
		
		//loops while index has not reached end
		while (index != numStudents){
			
			//loops for the amount of courses a student has and checks if input course is same as students course
			for (int i = 0; i < (students[index].getCourses().split(" ").length)- 1; i++){
				courses[i] = students[index].getCourses().split(" ")[i];
				if (inputCourse.equals(courses[i])){
					
					//adds to counter and kills loop if courses match
					counter++;
					i = students[index].getCourses().split(" ").length;
				}
			}
			
			//goes to next student in index
			index++;
		}
		
		//returns amount of students with said course
		return counter;
	}
	
	public String search(String value){
		
		//Gets the word to search, instantiates the index, if found or not, 
		//array to hold student elements, and return
		String keyWord = value;
		int index = 0;
		boolean found = false;
		String[] elements = new String[6];
		String returnSearch = "";
		
		//loops while not reached maximum index
		while(index != numStudents){
			
			//Goes through elements of student and checks if matches keyword. If match, loop is killed
			for (int i = 0; i < 6; i++){
				elements[i] = students[index].toString().split(",")[i];
				if (keyWord.equals(elements[i])){
					found = true;
					returnSearch = returnSearch.concat(students[index].toString() + "~");
					i = 6;
				}
				
				//Special case for courses. Loops through a students 4 courses and checks for keyword match
				for (int j = 0; j < (students[index].getCourses().split(" ").length)- 1; j++){
					elements[j] = students[index].getCourses().split(" ")[j];
					if (keyWord.equals(elements[j])){
						found = true;
						returnSearch = returnSearch.concat(students[index].toString() + "~");
						j = (students[index].getCourses().split(" ").length)- 1;
						i = 6;
					}
				}
			}
			
			//Goes to next student
			index++;
		}
		
		//If a search word was found, returns all students that were found, if not, returns "not found"
		if (found == false){
			returnSearch = "Not Found";
		}
		return returnSearch;
	}
	
	public int getNumStudents(){
		return numStudents;
	}
}
