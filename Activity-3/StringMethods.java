/**
 * This class contains a main() method only and its purpose it to demonstrate 
 * the use of several methods in the String class API
 * 
 * @author Karl McGuire 
 * @version 09/19/17
 */
public class StringMethods {
	public static void main(String[] args) {
		// sentence object for manipulation
		String sentence = new String(
			"The Mississippi originates in Minnesota and flows to Louisiana."
		);
		// for olding the number of times 'i' appears in the sentence
		int count = 0;

		// count the number of times 'i' appears in the sentence
		for(int k = 0; k < sentence.length( ); k++)
			count = (sentence.charAt(k) == 'i') ? count + 1 : count;

		// print out the number of characters in the sentence
		System.out.println(
			"The number of characters in the sentence:\n\t" + 
			sentence + 
			"\nis " + sentence.length()
		);
		
		// print out the number of times 'i' appears in the sentence	
		System.out.println("The lowercase i appears " + count + " times.");

		// 1) Does the sentence contain the string 'nat'?
		System.out.println("1) " + sentence.contains("nat"));
		
		// 2) Does the sentence contain the string 'beat'?
		System.out.println("2) " + sentence.contains("beat"));
		
		// 3) Does the sentence end with 'ana'?
		System.out.println("3) " + 
			sentence.substring(
				sentence.length()-4, 
				sentence.length()
			).equals("ana")
		);
		
		// 4) Does the sentence end with 'ana.'?
		System.out.println("4) " + 
			sentence.substring(
				sentence.length()-4,
				sentence.length()
			).equals("ana.")
		);

		// 5) Where is the first occurace of 's' ?
		System.out.println("5) " + sentence.indexOf("s"));

		// 6) Where is the second occurance of 's'?
		System.out.println("6) " + 
			sentence.indexOf("s", 
				sentence.indexOf("s") + 1
			)
		);

		// 7) Where is the third occurance of 's'?
		System.out.println("7) " + 
			sentence.indexOf("s", 
				sentence.indexOf("s",
					sentence.indexOf("s") + 1
				) + 1
			)
		);

		// 8) Where is the last occurace of 's'?
		System.out.println("8) " + sentence.lastIndexOf("s"));	

		// 9) Where does the first occurance of 'is' start?
		System.out.println("9) " + sentence.indexOf("is"));

		// 10) Where does the last occurance of 'is' start"?
		System.out.println("10) " + sentence.lastIndexOf("is"));

		// 11) Replace each occurance of 's' with 'z'.
		System.out.println("11) " + sentence.replaceAll("s", "z"));

		// 12) Does step 11 change the original sentence? Prove it by printing.
		System.out.println("12) " + sentence);

		// 13) Print the substring of the sentence beginning at character 3 for
		//     6 characters
		System.out.println("13) '" + sentence.substring(3, 9) + "'");

		// 14) Print the entire sentence in upper case.
		System.out.println("14) " + sentence.toUpperCase());

		// 15) Does step 13 change the original string? Prove it by printing.
		System.out.println("15) " + sentence);
	}
}
