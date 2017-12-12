import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		char input = ' ';
		double area = 0.0;

		double radius = 0.0;
		
		double length = 0.0;
		double width = 0.0;

		double base = 0.0;
		double height = 0.0;
		
		while(input != '4') {

		System.out.println("Choose:");
		System.out.println("1: Circle Area");
		System.out.println("2: Rectangle Area");
		System.out.println("3: Triangle Area");
		System.out.println("4: Quit");
		System.out.print(" : ");

		input = keyboard.next().charAt(0);
		
		switch(input) {
			case '1':
				System.out.print("Radius: ");
				radius = keyboard.nextDouble();
				System.out.print("Area: ");
				
				area = Geometry.circleArea(radius);
				
				if(area == 0.0)
					break;

				System.out.println(area);
				break;
			case '2':
				System.out.print("Length: ");
				length = keyboard.nextDouble();
				System.out.print("Width: ");
				width = keyboard.nextDouble();

				System.out.print("Area: ");
				area = Geometry.rectangleArea(length, width);
				
				if(area == 0.0)
					break;

				System.out.println(area);
				
				break;
			case '3':
				System.out.print("Base: ");
				base = keyboard.nextDouble();
				System.out.print("Height: ");
				height = keyboard.nextDouble();

				System.out.print("Area: ");
				area = Geometry.triangleArea(base, height);

				if(area == 0.0)
					break;

				System.out.println(area);
				break;
			default:
				break;
		}
		
		}
	}
}
