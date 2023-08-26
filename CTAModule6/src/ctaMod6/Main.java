package ctaMod6;
import java.util.ArrayList;
import java.util.Comparator;

/*
 * Author: Semisi Rigby
 * 
 * This class will be the used as the main class that is used 
 * to create a static selection sort method for the student 
 * objects while using the two custom comparators for name and 
 * roll number. This class will also contain the driver code 
 * (main method) for execution.
 */

public class Main {
	
	// create a static selection sort method
	// params: ArrayList<Student>, comparator<Student>
	
	public static void selectionSort(ArrayList<Student> students, Comparator<Student> comparator) {
		// create an int for the ArrayList size
		int n = students.size();
		
		// create two for loops with pointers for looping and comparison
		
		// outer loop with pointer for separating sorted/unsorted portions of ArrayList
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

	// driver code (main method)
	public static void main(String[] args) {
		
		// create an ArrayList of Student objects
		ArrayList<Student> students = new ArrayList<>();
		
		// create and add students into ArrayList students
		students.add(new Student(10, "Bob", "200 South Street"));
		students.add(new Student(9, "Jane", "300 North Street"));
		students.add(new Student(8, "Jack", "100 West Street"));
		students.add(new Student(7, "Semisi", "400 East Street"));
		students.add(new Student(6, "Sabrina", "400 East Street"));
		students.add(new Student(5, "Pauline", "325 Culver Road"));
		students.add(new Student(4, "Kevin", "325 Culver Road"));
		students.add(new Student(3, "Asieli", "600 Range Circle"));
		students.add(new Student(2, "Salesi", "750 Colorado Ave"));
		students.add(new Student(1, "Bentley", "1700 Dog House Ave"));
		
		// display ArrayList before sorting using a for loop
		System.out.println("------Before Sorting------");
		for (Student student : students) { 
			System.out.println("Student Name: " + student.getName() + " Roll Number: "
					+ student.getRollNumber());
			System.out.println();
		}
		
		// call sorting method with creation of an instance for NameComparator class
		selectionSort(students, new NameComparator());
		
		// display ArrayList after sorting by name
		System.out.println("------Name Sort------");
		// use a for loop to iterate across ArrayList
		for (Student student : students) {
			System.out.println("Student Name: " + student.getName() + " Roll Number: "
					+ student.getRollNumber());
			System.out.println();
		}
		
		// call sorting method with creation of an instance for RollNumberComparator class
		selectionSort(students, new RollNumberComparator());
		
		// display ArrayList after sorting by Roll Number
		System.out.println("------Roll Number Sort------");
		// use a for loop to iterate across ArrayList
		for (Student student : students) {
			System.out.println("Student Name: " + student.getName() + " Roll Number: "
					+ student.getRollNumber());
			System.out.println();
		}
		

	}

}
