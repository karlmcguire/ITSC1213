/**
 * File Name:   Converter.java
 * Lab Section: Lab 002
 *
 * This class takes a sentence as input and converts all single digit numbers 
 * into their English equivalent.
 *
 * @author Karl McGuire
 * @version 10/01/17
 */
public class Converter {
    // the original sentence when the object was created
    private StringBuilder original;

    // the converted sentence
    private String converted;

    /**
     * This constructor accepts an original sentence as its parameter
     * and converts all single digit numbers into their Enligh equivalent,
     * then sets the field "converted" to the converted sentence.
     *
     * @param String orig is the original sentence to be converted
     */
    public Converter(String orig) {
        // set the original field to the original sentence parameter    
        original = new StringBuilder(orig);

        // create a copy of the original sentence for manipulation
        StringBuilder sentence = original;
    
        // create a char array for the window
        //
        // the window is for determining whether a digit is alone (0-9) or 
        // surrounded by other numbers (>9)
        //
        // example:
        //
        // "There were 23 people at the meeting."
        //             ---
        //              ^
        // 
        // window[0] = '2'
        // window[1] = '3'
        // window[2] = ' '
        char[] window = new char[3];
    
        // for every letter in the original sentence
        for(int i = 0; i < sentence.length(); i++) {
            // if the current position is greater than 0, set window[0] to the
            // letter LEFT of the current letter (i-1)
            window[0] = i > 0 ? sentence.charAt(i-1) : ' ';

            // set window[1] to the current letter
            window[1] = sentence.charAt(i);

            // if the current position isn't the last letter in the sentence,
            // set window[2] to the letter RIGHT of the current letter (i+1)
            window[2] = i < sentence.length() - 1 ? sentence.charAt(i+1) : ' ';

            // if the letter to the left is not a number AND
            // the current letter is a number AND
            // the letter to the right is not a number THEN
            // replace the current letter with its English equivalent
            if(!isNumber(window[0]) && 
                isNumber(window[1]) && 
               !isNumber(window[2]))
                // replace the current letter with its English equivalent
                sentence.replace(i, i+1, getWord(window[1]));
        }
    
        // if the first letter of the sentence is lowercase
        if(Character.isLowerCase(sentence.charAt(0)))
            // set the first letter of the sentence to uppercase
            sentence.setCharAt(0, Character.toUpperCase(sentence.charAt(0)));

        // set the field 'converted' to the converted sentence
        converted = sentence.toString();    
    }

    /**
     * This get method returns the original sentence.
     *
     * @return String the original sentence
     */
    public String GetOriginal() {
        return original.toString();
    }

    /**
     * This get method returns the converted sentence.
     *
     * @return String the converted sentence
     */
    public String GetConverted() {
        return converted;
    }

    /**
     * This toString method returns both the original and converted sentences.
     *
     * @return String the original and converted sentences
     */
    public String toString() {
        return "Input Record:\n\t" + original + "\nOutput Record:\n\t" + 
                converted + "\n" ;  
    }

    /**
     * This internal method returns the English representation of a char digit.
     *
     * @param char letter is the digit
     * @return String the English representation of the digit
     */
    private String getWord(char letter) {
        // switch over the digit
        // the rest is self explanatory
        switch(letter) {
            case '0': return "zero"; 
            case '1': return "one"; 
            case '2': return "two"; 
            case '3': return "three";   
            case '4': return "four";    
            case '5': return "five";    
            case '6': return "six"; 
            case '7': return "seven";   
            case '8': return "eight";   
            case '9': return "nine";
            // if the letter isn't a digit return nothing
            //
            // this shouldn't happen because getWord() is only called after
            // isNumber()
            default:  return "";
        }
    }

    /**
     * This internal method returns whether or not the letter is a digit. 
     *
     * @param char letter is the supposed digit
     * @return boolean whether letter is a digit
     */
    private boolean isNumber(char letter) {
        if(letter == '0' ||
           letter == '1' || 
           letter == '2' || 
           letter == '3' || 
           letter == '4' || 
           letter == '5' || 
           letter == '6' || 
           letter == '7' || 
           letter == '8' || 
           letter == '9')
            // letter is a digit
            return true;
    
        // letter isn't a digit
        return false;
    }
}
