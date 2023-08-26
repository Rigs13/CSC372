package ctaMod6;
import java.util.Comparator;

/* Author: Semisi Rigby
 * 
 * This class will be used as a comparator implementing
 * the Java comparator interface using Roll Number for the
 * student array list and selection sort method.
 */

public class RollNumberComparator implements Comparator<Student> {

	// override abstract method from comparator interface
	@Override
	public int compare(Student student1, Student student2) {
		
		// returns comparison based on student roll number
		return student1.getRollNumber() - student2.getRollNumber();
	}

}
