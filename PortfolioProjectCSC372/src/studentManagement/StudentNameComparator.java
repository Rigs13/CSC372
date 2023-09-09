package studentManagement;
import java.util.Comparator;

/*
 * Author: Semisi Rigby
 * 
 * This class will be used as a comparator implementing
 * the Java comparator interface to compare the names for
 * the student LinkedList and sort method.
 */

public class StudentNameComparator implements Comparator<Student> {

	// override abstract method from comparator interface
	@Override
	public int compare(Student s1, Student s2) {
		// returns comparison based on Unicode of student name Strings
		return s1.getName().compareTo(s2.getName());
	}
	

}
