/**
 * Geometry demonstrates my extensive knowledge of the 'final' keyword in Java.
 *
 * @author Karl McGuire
 * @version 12/12/17
 */
public class Geometry {
	// PI is a (short) representation of the PI constant for use in calculating
	// the area of circles	
	static final double PI = 3.14159;

	/**
	 * circleArea calculates the area of a circle given the radius.
	 *
	 * @param radius is the radius of the circle
	 * @return area 
	 */
	public static double circleArea(double radius) {
		// if less then 0, just return 0
		return (radius <= 0) ? 0 : PI * (radius * radius);
	}

	/**
	 * rectangleArea calculates the area of a rectangle given the length and 
	 * width.
	 *
	 * @param length is the length of the rectangle
	 * @param width is the width of the rectangle
	 * @return area of triangle
	 */
	public static double rectangleArea(double length, double width) {
		// if less then 0, just return 0
		return (length <= 0 || width <= 0) ? 0 : length * width;
	}

	/**
	 * triangleArea calculates the area of a triangle given the base length and
	 * height.
	 *
	 * @param base is the base length of the triangle
	 * @param height is the height of the triangle
	 * @return area of triangle
	 */
	public static double triangleArea(double base, double height) {
		// if less then 0, just return 0
		return (base <= 0 || height <= 0) ? 0 : 0.5 * (base * height);
	}
}
