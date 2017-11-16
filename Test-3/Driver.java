import java.util.*;

/**
 * This class loops for user input and determines whether the input is a valid 
 * float or not (for testing the ValidateFloat class).
 *
 * @author Karl McGuire
 * @version 10/13/17
 */
public class Driver {
	public static void main(String[] args) {
		// keyboard is used for user input	
		Scanner keyboard = new Scanner(System.in);
		// possible is the possible float string
		String possible = new String();
		// vf is the validatefloat object for testing
		ValidateFloat vf;

		// while the user doesn't input "quit"
		while(!possible.equals("quit")) {
			// prompt the user for their entry	
			System.out.print("entry: ");
			// store the user input into the possible float string
			possible = keyboard.nextLine();	
		
			// if the input isn't "quit"
			if(!possible.equals("quit")) {
				// initialize the vf object with the new possible string
				vf = new ValidateFloat(possible);
				// if it's a valid float
				if(vf.Valid()) {
					// output the valid response
					System.out.println("  valid");
				// if it's not a valid float	
				} else {
					// output the errors
					System.out.print(vf.GetErrors());	
				}
			}
		}

		// goodbye message
		System.out.println("Goodbye!");
	}
}
