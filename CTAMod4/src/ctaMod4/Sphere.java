package ctaMod4;

public class Sphere extends Shape {
	
	// creation of subclass Sphere that extends Shape abstract class
	// attribute of radius
	private double radius;
	
	// parameterized constructor method with radius parameter
	public Sphere(double radius) {
		this.radius = radius;
	}
	
	// override abstract surface_area method from super class
	// returns double
	@Override
	double surface_area() {
		return 4 * Math.PI * (Math.pow(radius, 2));
	}

	// override abstract volume method from super 
	// returns double
	@Override
	double volume() {
		return ((4.0 / 3.0) * (Math.PI) * (radius*radius*radius));
	}
	
	// toString method to return calculations as a string
	public String toString() {
		return String.format("Sphere with Radius: %.2f has Surface Area: %.2f and Volume: %.2f",
				radius, surface_area(), volume());
	}

}
