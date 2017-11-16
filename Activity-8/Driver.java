import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        // check args length
        if(args.length != 2) {
            System.out.println("ERROR: Proper usage is 'java Driver fileOne.txt fileTwo.txt'");
            return;
        }

        // get input file
        Scanner input = new Scanner(new File(args[0]));
        // create output file
        PrintWriter output = new PrintWriter(args[1]);

        // read each line of the input file
        while(input.hasNextLine()) {
            // write each line of the input file into the output file
            output.println(input.nextLine());
        }

        // close the output file
        output.close();

        // goodbye
        System.out.println("Done!");
    }
}
