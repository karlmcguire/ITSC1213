/**
 * This class validates a user-inputted float literal and returns errors if 
 * there are any.
 *
 * @author Karl McGuire
 * @version 10/13/17
 */
public class ValidateFloat {
    // this holds the error messages    
    private String[] errors;
    // this holds the possible float string
    private String possible;    

    /**
     * This constructor adds the possible float literal to the internal field.
     *
     * @param String p is the possible float literal
     */
    public ValidateFloat(String p) {
        // initialize the error array with 20 spaces
        errors = new String[20];
        // set the possible field to the parameter
        possible = p;
    }

    /**
     * This method returns whether or not the possible field is valid or not.
     *
     * @return boolean whether or not the possible field is a valid float or not
     */
    public boolean Valid() {
        // decimal count
        int dCount = 0;
        // 'E' count
        int eCount = 0;
        // positive sign (+) count
        int pCount = 0;
        // negative sign (-) count
        int nCount = 0;
        // error count
        int errCount = 0;

        // for every char in the possible float string (while there are less 
        // than 20 errors)
        for(int a = 0; a < possible.length() && errCount != 20; a++) {
            // switch on the current character in the possible float string
            switch(possible.charAt(a)) {
                // the current character is a '.'
                case '.':
                    // if there is already a decimal in the string, add an error
                    if(dCount == 1) {
                        errors[errCount] = "Extra decimal point at char " 
                            + a + ".";
                        errCount++;
                    } else {
                        // update the decimal count
                        dCount = 1;
                    }
                    break;
                // the current character is 'E'
                case 'E': 
                    // if there is already an 'E' character in the string, 
                    // add an error
                    if(eCount == 1) {
                        errors[errCount] = "Extra 'E' character at char " 
                            + a + ".";
                        errCount++; 
                    } else {
                        // update the 'E' count
                        eCount = 1;
                    }
                    break;
                // the current character is '+'
                case '+': 
                    // if there are already two '+' characters in the string,
                    // add an error
                    if(pCount == 2) {
                        errors[errCount] = "Extra '+' character at char " 
                            + a + ".";
                        errCount++;
                    // if there are already two '-' characters in the string, 
                    // add an error 
                    } else if (nCount == 2) {
                        errors[errCount] = "Already two '-' signs, can't have extra '+' char at " + a + ".";
                        errCount++;
                    } else {
                        // update the '+' count
                        pCount++;
                    }
                    break;
                // the current character is '-'
                case '-':
                    // if there are already two '-' characters in the string,
                    // add an error
                    if(nCount == 2) {
                        errors[errCount] = "Extra '-' character at char " 
                            + a + ".";
                        errCount++;
                    // if there are already two '+' characters in the string,
                    // add an error 
                    } else if (pCount == 2) {
                        errors[errCount] = "Already two '+' signs, can't have extra '+' char at " + a + ".";
                        errCount++;
                    } else {
                        // update the '-' count
                        nCount++;
                    }
                    break;  
                // the current character is a number digit
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    // do nothing because it's valid
                    break;
                // if the current character is unknown
                default:    
                    // add an error message
                    errors[errCount] = "Unknown character '" +
                        possible.charAt(a) + "' used at char " + a + ".";
                    errCount++;
                    break;
            }
        }

        // if there are errors with the possible float string
        if(errCount > 0)
            return false;
        // there aren't any errors
        else
            return true;
    }

    /**
     * This method returns all the error messages in one string.
     *
     * @return String all error messages in one string
     */
    public String GetErrors() {
        String output = new String();

        // for every error in the error array
        for(int i = 0; i < errors.length; i++) {
            // if the error isn't null, add it to the output string
            if(errors[i] != null)
                output += "  " + errors[i] + "\n";
        }

        // return the finished string
        return output;
    }
}
