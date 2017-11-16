import java.util.*;
import java.io.*;

/**
 * This class is for testing the Pet class.
 *
 * @author Karl McGuire
 * @version 10/20/17
 */
public class Driver {
    public static void main(String[] args) throws IOException {
        // read in the pets from rescue.text
        Scanner input = new Scanner(new File("rescue.txt"));
        Pet[] pets = new Pet[3];
        String[] tokens = new String[3];    

        // getting and printing pets
        System.out.println("Pets: ");
        for(int i = 0; input.hasNext(); i++) {
            // split the current line   
            tokens = input.nextLine().split(",");   
            // add the current pet to the array
            pets[i] = new Pet(tokens[0], tokens[1], Double.parseDouble(tokens[2])); 
            // output the current pet using the toString() method   
            System.out.println("\t" + pets[i]);
        }

        // testing .equals()
        System.out.println("\n1st and 2nd pet equal test:");

        if(pets[0].equals(pets[1]))
            System.out.println("\t" + pets[0].getName() + " and " + pets[1].getName() + " ARE equal.");
        else
            System.out.println("\t" + pets[0].getName() + " and " + pets[1].getName() + " ARE NOT equal.");


        // testing .compareTo()
        System.out.println("\n1st and 3rd pet compareTo test (comparing cost):");

        if(pets[0].compareTo(pets[2]) == 0)
            System.out.println("\t" + pets[0].getName() + " costs the SAME as " + pets[1].getName() + " ($" + pets[0].getCostToAdopt() + ").");
        else if(pets[0].compareTo(pets[2]) == 1)
            System.out.println("\t" + pets[0].getName() + " costs MORE than " + pets[1].getName() + " ($" + pets[0].getCostToAdopt() + ").");
        else if(pets[0].compareTo(pets[2]) == -1)
            System.out.println("\t" + pets[0].getName() + " costs LESS than " + pets[1].getName() + " ($" + pets[0].getCostToAdopt() + ").");
    }
}
