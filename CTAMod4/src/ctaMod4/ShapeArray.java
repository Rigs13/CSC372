package ctaMod4;

public class ShapeArray {

	/* 
	 	ShapeArray will instantiate objects of Sphere, Cylinder, and Cone
	 	Add objects to an array
	 	Loop through array and display the instance data of each object
	 	with toString method of each class
	*/
	
	// main method for creating instances of each object and array
	public static void main(String[] args) {
		
		// Instantiate Sphere, Cylinder, and Cone objects; args: radius, height
		Sphere sphere = new Sphere(2);
		Cylinder cylinder = new Cylinder(3, 5);
		Cone cone = new Cone(3, 5);
		
		// Create an array for storing Shapes
		Shape[] shapeArray = new Shape[3];
		
		// Add objects to array
		shapeArray[0] = sphere;
		shapeArray[1] = cylinder;
		shapeArray[2] = cone;
		
		// iterate across the array and return the string with calculations
		// when displaying a shape to the console, the toString is called automatically
		for (int i = 0; i < shapeArray.length; i++) { 
			Shape x = shapeArray[i];
			System.out.println(x);
		}
		
	}

}
