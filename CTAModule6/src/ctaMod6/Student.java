package ctaMod6;

/*
 * Author: Semisi Rigby
 * 
 * This class will be used for creating a blueprint
 * for the student class to be used within an arraylist
 */

public class Student {
	
	// attributes for student class
	private int rollNumber;
	private String name;
	private String address;
	
	// parameterized constructor
	public Student(int rollNumber, String name, String address) {
		
		// refer to params to instance of self
		this.rollNumber = rollNumber;
		this.name = name;
		this.address = address;
		
	}
	
	// getters for rollNumber, name, and address
	public int getRollNumber() {
		return rollNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() { 
		return address;
	}

}
