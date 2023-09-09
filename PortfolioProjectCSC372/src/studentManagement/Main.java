package studentManagement;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * Author: Semisi Rigby
 * 
 * This class will be used to handle the main logic for the student
 * management project in which a loop system will ask for input from the user
 * to create student objects (see Student class file). The created student
 * objects will be stored into a Linked List and then written to an 
 * external text file located within the same project directory after being sorted
 * by a custom sorting method (selection sort that was created in prior module).
 */

public class Main {
	
	// create a method for sorting students by name (ascending)
	public static void selectionSort(LinkedList<Student> students, Comparator<Student> comparator) {
		// create an int for the LinkedList size
		int n = students.size();
		
		// create two for loops with pointers for looping and comparison (sorted/unsorted portions)
		for (int i = 0; i < n - 1; i++) {
			// variable for tracking smallest index
			int minIndex = i;
			// creation of inner loop with second pointer
			for (int j = i + 1; j < n; j++) {
				// if statement to compare i and j pointers
				if (comparator.compare(students.get(j), students.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			// swap procedure if i was not kept as smallest index
			if (minIndex != i) {
				// temp variable for swapping
				Student temp = students.get(minIndex);
				students.set(minIndex, students.get(i));
				students.set(i, temp);
			}
		}
	}

	// Driver code (main method)
	public static void main(String[] args) {
		
		// variables for main method scope
		int studentAdd; // number of student objects to create
		
		// create an instance for Scanner object
		Scanner sc = new Scanner(System.in);

		// create LinkedList for student objects
		LinkedList<Student> studentList = new LinkedList<Student>();
		
		// introduction for input
		System.out.println("---------------");
		System.out.println("Welcome to the Student Management System!");
		System.out.println("---------------\n");
		
		// ask for number of students to add
		// implement a while loop to ensure valid input
		while (true) {
			// ask for the number of students to be added
			System.out.println("How many students would you like to add? (Ensure input is an integer): ");
			
			if (sc.hasNextInt()) {
				// variable to store input
				studentAdd = sc.nextInt();
				// consume the newline character to avoid input for next input received
				sc.nextLine();
				// break while loop with input
				break;
			}
			else {
				System.out.println("Invalid input. Ensure that input is of the type integer.");
				// consume the invalid input
				sc.nextLine();
			}
		}
		
		// begin looping to create student objects
		for (int i = 0; i < studentAdd; i++) {
			// variable for student object information
			String studentName;
			String studentAddress;
			double studentGPA;
			
			// collect student name
			System.out.println("Enter the name of student " + (i+1) + ":");
			studentName = sc.nextLine(); // trim used to condense space
			
			// collect student address
			System.out.println("Enter the address of student " + (i+1) + ":");
			studentAddress = sc.nextLine(); // trim used to condense space
			
			// collect and validate GPA
			// while loop to validate GPA input format
			while (true) {
				System.out.println("Enter the GPA of student " + (i+1) + ":");
				// take input as a string and attempt to parse into a double with 
				// a specific range of 0.0 to 4.0
				String input = sc.nextLine().trim();
				// try/catch block for parsing string into double
				try {
					studentGPA = Double.parseDouble(input);
					// see if double is within range of GPA format
					if (studentGPA >= 0 && studentGPA <= 4.0) {
						// break while loop
						break;
					}
					else {
						System.out.println("GPA must be within range 0 to 4.0.");
					}
				}
				catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a valid GPA format.");
				}
			}
			
			// create a student object from input given
			Student student = new Student(studentName, studentAddress, studentGPA);
			// add student to studentList
			studentList.add(student);
			
			// feedback for adding student to list
			System.out.println("---------------");
			System.out.println("Student has been added to list!");
			System.out.println("---------------\n");
	
		}
		
		// close scanner
		sc.close();
		
		// sort method call
		selectionSort(studentList, new StudentNameComparator());
		
		// write Student objects to file 
		// try and catch block with IO exception for writing to file
		try {
			
			FileWriter fw = new FileWriter("StudentLog.txt", true);
			PrintWriter out = new PrintWriter(fw);
			
			// print student objects to file using a for loop
			for (Student student : studentList) {
				out.println();
				out.println(student);
				out.println();
			}
			// close file 
			out.close();
			 
			// update user program to show info has been printed
			System.out.println("Student log has been updated!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End of program.");
		
		
	}

}
