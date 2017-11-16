/**
 * This class contains a main() method only
 * and its purpose it to demonstrate the use
 * of several methods in the String class API
 * 
 * @author Karl McGuire 
 * @version 09/19/17
 */
public class StringMethods {
    public static void main(String[] args) {
        String sentence;
        int count;
        
        sentence = new String("The Mississippi originates in Minnesota and flows to Louisiana.");
        System.out.println("The number of characters in the sentence:\n" 
                + sentence + "\nis "+ sentence.length());
        count = 0;

        for(int k = 0; k < sentence.length( ); k++)
            if(sentence.charAt(k) == 'i')
                count++;
        
        System.out.println("The lowercase i appears " + count + " times.");

      /* 1) Does the sentence contain the string "nat" ?
       * 2) Does the sentence contain the string "beat" ?
       * 3) Does the sentence end with "ana"?
       * 4) Does the sentence end with "ana."?
       * 5) Where is the first occurace of 's' ?
       * 6) Where is the second occurance of 's'?
       * 7) Where is the third occurance of 's'?
       * 8) Where is the last occurace of 's'?
       * 9) Where does the  first occurance of "is" start?
       * 10)Where does the last occurance of "is" start"?
       * 11)Replace each occurance of 's' with 'z'.
       * 12) Does step 11 change the original sentence, prove it by printing.
       * 13) Print the substring of the sentence beginning at character 3 for
       *     6 characters"
       * 14) Print the entire sentence in upper case.
       * 15) Does step 13 change the original string, prove it by printing
       */

		System.out.println("1) " + sentence.contains("nat"));
   		System.out.println("2) " + sentence.contains("beat"));
		System.out.println("3) " + sentence.substring(sentence.length()-4, sentence.length()).equals("ana"));
		System.out.println("4) " + sentence.substring(sentence.length()-4, sentence.length()).equals("ana."));
		System.out.println("5) " + sentence.indexOf("s"));
		System.out.println("6) " + sentence.indexOf("s", sentence.indexOf("s")+1));
		System.out.println("7) " + sentence.indexOf("s", sentence.indexOf("s", sentence.indexOf("s")+1)+1));
   		System.out.println("8) " + sentence.lastIndexOf("s"));	
		System.out.println("9) " + sentence.indexOf("is"));
		System.out.println("10) " + sentence.lastIndexOf("is"));
		System.out.println("11) " + sentence.replaceAll("s", "z"));
		System.out.println("12) " + sentence);
		System.out.println("13) '" + sentence.substring(3, 9) + "'");
		System.out.println("14) " + sentence.toUpperCase());
		System.out.println("15) " + sentence);
    }
}
