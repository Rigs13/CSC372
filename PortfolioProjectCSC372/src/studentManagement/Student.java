package studentManagement;

/*
 * Author: Semisi Rigby
 * 
 * This class will be used for the creation of
 * the student objects containing name, address,
 * and GPA for each. The class will feature a parameterized
 * constructor, getters, and a toString method.
 */

public class Student {
	
	// attributes
	private String name;
	private String address;
	private double GPA;
	
	// parameterized constructor
	public Student(String name, String address, double GPA) {
		this.name = name;
		this.address = address;
		this.GPA = GPA;
	}
	
	// getters for attributes
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public double getGPA() {
		return GPA;
	}
	
	// override toString method for displaying and writing to external file
	@Override
	public String toString() {
		return "Name: " + name + "\nAddress: " + address + "\nGPA: " + GPA + "\n";
	}

}
