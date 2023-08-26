package ctaMod6;
import java.util.Comparator;

/*
 * Author: Semisi Rigby
 * 
 * This class will be used as a comparator implementing 
 * the Java comparator interface using names for the 
 * student array list and selection sort method.
 */

public class NameComparator implements Comparator<Student> {

	// override abstract method from comparator interface
	@Override
	public int compare(Student student1, Student student2) {
		
		// returns comparison based on Unicode of student name Strings
		return student1.getName().compareTo(student2.getName());
	}

}
