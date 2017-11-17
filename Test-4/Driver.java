import java.util.*;

/**
 * Driver displays an option menu to test each method of the Date class.
 *
 * @author Karl McGuire
 * @version 11/16/17
 */
public class Driver {
    public static void main(String[] args) {
        // date is used as the user's initial date
        // otherDate is used to store modifications of date
        Date date, otherDate;
       
        // create a Scanner object for getting keyboard input
        Scanner input = new Scanner(System.in);

        // start prompt
        System.out.println("ENTER DATE:");
        date = promptDate(input);
        System.out.println("SET DATE: " + date);

        // choice holds the user's input
        char choice = ' ';

        // while the user doesn't want to quit
        while(choice != 'Q') { 
            // display menu
            System.out.println("==========================");
            System.out.println("(1) Add a number of days.");
            System.out.println("(2) Subtract a number of days.");
            System.out.println("(3) Calculate days between another date.");
            System.out.println("(4) Get the Julian date.");
            System.out.println("(5) Get the long-format date.");
            System.out.println("(Q) QUIT."); 

            // ask for the user's choice
            System.out.print("OPTION: ");
            choice = input.next().charAt(0); 

            switch(choice) {
                case 'Q':
                case 'q':
                    // exit the loop (this will end the program)
                    break;
                case '1':
                    // ask for number of days to add
                    System.out.print("- Number of days to add: ");  
                    // assign otherDate to the modified date
                    otherDate = date.add(input.nextInt());
                    // output otherDate to user
                    System.out.println("-- " + otherDate + " (" + otherDate.getDate('L') + ").");
                    break;
                case '2':
                    // ask for number of days to subtract
                    System.out.print("- Number of days to subtract: ");
                    // assign otherDate to the modified date
                    otherDate = date.subtract(input.nextInt());
                    // output otherDate to user
                    System.out.println("-- " + otherDate + " (" + otherDate.getDate('L') + ").");
                    break;
                case '3':
                    // prompt for the date to compare
                    System.out.println("- Date to compare: ");
                    // assign otherDate to the new date
                    otherDate = promptDate(input);
                    // use daysBetween method and output to user
                    System.out.println("-- " + date.daysBetween(otherDate) + " days between " + date + " and " + otherDate + ".");
                    break;
                case '4':
                    // print julian date using getJulianDate function
                    System.out.println("- Julian date: " + date.getJulianDate());
                    break;
                case '5':
                    // print long form using getDate('L')
                    System.out.println("- Long form of " + date + " is " + date.getDate('L'));
                    break;
                default:
                    // the user input didn't match one of the options
                    System.out.println("ERROR - Please input a number 1-5 or 'Q' to quit.");
            }
        }
    }

    /**
     * promptDate is a helper function for taking user input and returning a
     * Date object.
     *
     * This is a useful helper function because it is used twice in main() and
     * I wanted to avoid repeating code (DRY).
     *
     * @param Scanner input is the keyboard input to use
     * @return Date object
     */
    public static Date promptDate(Scanner input) {
        // prompt for the month number and store it  
        System.out.print("- Month  (MM): ");
        int month = input.nextInt();

        // prompt for the day number and store it
        System.out.print("- Day    (DD): ");
        int day = input.nextInt();

        // prompt for the year number and store it
        System.out.print("- Year (YYYY): ");
        int year = input.nextInt();
       
        // return new date object
        return new Date(month, day, year);
    }
}
