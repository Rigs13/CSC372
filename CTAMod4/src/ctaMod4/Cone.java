package ctaMod4;

public class Cone extends Shape {

	// creation of Cone class that extends the abstract Shape class
	// attributes of radius and height
	private double radius;
	private double height;
	
	// parameterized constructor method with radius/height
	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	
	// override method from super for surface area of Cone
	@Override
	double surface_area() {
		return Math.PI * radius * (radius + (Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2))));
	}

	// override method from super for volume of Cone
	@Override
	double volume() {
		return Math.PI * (Math.pow(radius, 2)) * (height/3);
	}
	
	// toString method for returning calculation methods as String
	public String toString() {
		return String.format("Cone with Radius: %.2f and Height: %.2f" +
				" has a Surface Area of: %.2f and Volume: %.2f",
				radius, height, surface_area(), volume());
	}

}
