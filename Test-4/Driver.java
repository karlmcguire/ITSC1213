import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Date date, otherDate;
        Scanner input = new Scanner(System.in);
        char choice = ' ';
        int days;

        // start prompt
        System.out.println("ENTER DATE:");
        date = promptDate(input);
        System.out.println("SET DATE: " + date);

        while(choice != 'Q') { 
            System.out.println("==========================");
            System.out.println("(1) Add a number of days.");
            System.out.println("(2) Subtract a number of days.");
            System.out.println("(3) Calculate days between another date.");
            System.out.println("(4) Get the Julian date.");
            System.out.println("(5) Get the long-format date.");
            System.out.println("(Q) QUIT."); 

            System.out.print("OPTION: ");
            choice = input.next().charAt(0); 

            switch(choice) {
                case 'Q':
                case 'q':
                    break;
                case '1':
                    System.out.print("- Number of days to add: ");  
                    otherDate = date.add(input.nextInt());
                    System.out.println("-- " + otherDate + " (" + otherDate.getDate('L') + ").");
                    break;
                case '2':
                    System.out.print("- Number of days to subtract: ");
                    otherDate = date.subtract(input.nextInt());
                    System.out.println("-- " + otherDate + " (" + otherDate.getDate('L') + ").");
                    break;
                case '3':
                    System.out.println("- Date to compare: ");
                    otherDate = promptDate(input);
                    System.out.println("-- " + date.daysBetween(otherDate) + " days between " + date + " and " + otherDate + ".");
                    break;
                case '4':
                    System.out.println("- Julian date: " + date.getJulianDate());
                    break;
                case '5':
                    System.out.println("- Long form of " + date + " is " + date.getDate('L'));
                    break;
                default:
                    System.out.println("ERROR - Please input a number 1-5 or 'Q' to quit.");
            }
        }
    }

    public static Date promptDate(Scanner input) {
        System.out.print("- Month  (MM): ");
        int month = input.nextInt();

        System.out.print("- Day    (DD): ");
        int day = input.nextInt();

        System.out.print("- Year (YYYY): ");
        int year = input.nextInt();
        
        return new Date(month, day, year);
    }
}
