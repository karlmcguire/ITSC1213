import java.util.*;
import java.io.*;

/**
 * This class demonstrates my extensive knowledge of the StringTokenizer class.
 *
 * @author Karl McGuire
 * @version 10/5/17
 */
public class Driver {
	public static void main(String[] args) throws IOException {
		// declare and initialize Scanner object for keyboard input 
		Scanner keyboard = new Scanner(System.in);
		// declare and initialize Scanner object for file input
		Scanner input = new Scanner(new File("input.txt"));
		// String object for temporary line storage 
		String line;	
		// declare StringTokenizer object
		StringTokenizer st;
		
		// part 1 of the activity
		System.out.print("space input: ");
		// store input in temporary line
		line = keyboard.nextLine();
		// initialize StringTokenizer with space delimeter  
		st = new StringTokenizer(line, " ");
		// print token count
		System.out.println("\ttoken count: " + st.countTokens());
		// print each token 
		System.out.println("\teach token: ");
		while(st.hasMoreTokens())
			System.out.println("\t\t'" + st.nextToken() + "'");
		// initialize StringTokenizer with space delimeter and include 
		// delimeters
		st = new StringTokenizer(line, " ", true);
		// print each token and delimeter
		System.out.println("\teach token with delim: ");
		while(st.hasMoreTokens())
			System.out.println("\t\t'" + st.nextToken() + "'");
		
		// same as above except with commas 
		System.out.print("comma input: ");
		line = keyboard.nextLine(); 
		st = new StringTokenizer(line, ",");
		System.out.println("\ttoken count: " + st.countTokens());
		System.out.println("\teach token: ");
		while(st.hasMoreTokens())
			System.out.println("\t\t'" + st.nextToken() + "'");
		st = new StringTokenizer(line, ",", true);
		System.out.println("\teach token with delim: ");
		while(st.hasMoreTokens())
			System.out.println("\t\t'" + st.nextToken() + "'");

		// same as above except with two delimeters 
		System.out.print("more than one delimeter: ");
		line = keyboard.nextLine(); 
		st = new StringTokenizer(line, " ,");
		System.out.println("\ttoken count: " + st.countTokens());
		System.out.println("\teach token: ");
		while(st.hasMoreTokens())
			System.out.println("\t\t'" + st.nextToken() + "'");
		st = new StringTokenizer(line, " ,", true);
		System.out.println("\teach token with delim: ");
		while(st.hasMoreTokens())
			System.out.println("\t\t'" + st.nextToken() + "'");

		// total is the total token count of the file   
		int total = 0;
		// for each line in the file
		for(int i = 0; input.hasNextLine(); i++) {
			// initialize the StringTokenizer object with the current line 
			// and a comma as the delimeter
			st = new StringTokenizer(input.nextLine(), ",");
			// print out the current line number (i) with the token count
			System.out.println("line " + i + ": " + st.countTokens() + " tokens");
			// update the total token count
			total = total + st.countTokens();
		}

		// print out the total tokens in the file
		System.out.println("total tokens: " + total);
	}
}