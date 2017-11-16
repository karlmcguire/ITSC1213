public class Geometry {
	static final double PI = 3.14159;
	

	public static double circleArea(double radius) {
		if(radius <= 0) {
			System.err.println("non positive");
			return 0;
		}

		return PI * (radius * radius);	
	}

	public static double rectangleArea(double length, double width) {
		if(length <= 0 || width <= 0) {
			System.err.println("non positive");
			return 0;
		}
		
		return length * width;
	}

	public static double triangleArea(double base, double height) {
		if(base <= 0 || height <= 0) {
			System.err.println("non positive");
			return 0;
		}

		return (0.5) * (base * height);
	}
}
