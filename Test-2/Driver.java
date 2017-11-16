import java.io.*;
import java.util.*;

/**
 * File Name:   Driver.java
 * Lab Section: Lab 002
 *
 * This class asks for an input file, converts every line in the input file 
 * using the Converter class, and then writes each converted line to an output
 * file (outSentence.txt).
 *
 * @author Karl McGuire
 * @version 10/01/17
 */
public class Driver {
	/**
	 * This main method starts the execution of the program and might throw
	 * an IOException due to the fact that it handles files.
	 *
	 * @param String[] args is the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		// declare and initialize a new Scanner object using keyboard input
		Scanner keyboard = new Scanner(System.in);

		// declare a Converter object
		Converter converter;

		// prompt for the input file
		System.out.print("Input file: ");
		// declare and initialize a new Scanner object for file input
		Scanner input = new Scanner(new File(keyboard.nextLine()));
	
		// declare and initialize a new PrintWriter object for file output
		PrintWriter output = new PrintWriter("outSentence.txt");

		// while the input file has lines left
		while(input.hasNext()) {
			// create a new Converter object with the current line as the input
			converter = new Converter(input.nextLine());	
			
			// print the converted sentence to the screen
			System.out.println(converter.GetConverted());

			// print the converted sentence to the output file
			output.println(converter.GetConverted());
		}
	
		// close the input file for reading
		input.close();

		// close the output file for writing
		output.close();
	}
}
