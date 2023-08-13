package ctaMod4;

public class Cylinder extends Shape {
	
	// creation of Cylinder extending abstract Shape class
	// attributes of radius and height
	private double radius;
	private double height;
	
	// parameterized constructor method with radius and height args
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	// override surface area method from super for cylinder calculation
	@Override
	double surface_area() {
		return ((2 * Math.PI * radius * height) + (2 * Math.PI * (Math.pow(radius, 2))));
	}

	// override volume method from super for cylinder calculation
	@Override
	double volume() {
		return (Math.PI * (Math.pow(radius, 2)) * height);
	}
	
	// toString method for returning calculations as String
	public String toString() {
		return String.format("Cylinder with Radius: %.2f and Height: %.2f has" +
				" Surface Area of: %.2f and Volume of: %.2f", radius, height, surface_area(), volume());
	}

}
