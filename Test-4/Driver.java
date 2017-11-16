import java.util.*;

public class Driver {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
   
        // start prompt
        System.out.println("DATE:");
        System.out.println(getDate(input));
    }

    public static Date getDate(Scanner input) {
        System.out.print("\tMonth  (MM): ");
        int month = input.nextInt();

        System.out.print("\tDay    (DD): ");
        int day = input.nextInt();

        System.out.print("\tYear (YYYY): ");
        int year = input.nextInt();
        
        return new Date(month, day, year);
    }
}
