import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("text.txt"));
        PrintWriter output = new PrintWriter("out.txt");    
        String vowels = "aeiou";
        String line;
        int i = 0;

        int eCount = 0;
        int vowelCount = 0; 
        int charCount = 0;
        int spaceCount = 0;

        while(input.hasNext()) {
            line = input.nextLine();

            // a)   
            eCount += line.length() - line.replace("e", "").length();   
    
            // b)
            for(i = 0; i < vowels.length(); i++) {
                char vowel = vowels.charAt(i);
                vowelCount += line.length() - line.replace("" + vowel, "").length();    
            }

            // c)
            charCount += line.length(); 
    
            // d)
            for(i = 0; i < line.length(); i++)
                if(line.charAt(i) == ' ' && i < line.length() && line.charAt(i+1) != '\n' && line.charAt(i+1) != ' ')
                    spaceCount++;
        
            System.out.println(line.toUpperCase()); 
            output.println(line.toUpperCase());
        }

        output.println("a) e: \t\t" + eCount);
        System.out.println("a) e: \t\t" + eCount);

        output.println("b) vowels: \t" + vowelCount);
        System.out.println("b) vowels: \t" + vowelCount);

        output.println("c) chars: \t" + charCount);
        System.out.println("c) chars: \t" + charCount);

        output.println("d) spaces: \t" + spaceCount);
        System.out.println("d) spaces: \t" + spaceCount);

        input.close();
        output.close();
    }
}
