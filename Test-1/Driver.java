import java.util.*;

/**
 * This class uses both Temperature and Windchill objects with user input to 
 * demonstrate set() and get() methods. 
 *
 * @author Karl McGuire
 * @version 09/14/17
 */
public class Driver {
    public static void main(String[] args) {
        // create and initialize Scanner object
        Scanner keyboard = new Scanner(System.in);
        // create and initialize Temperature object
        Temperature temperature = new Temperature();
        // create and initialize Windchill object
        Windchill windchill = new Windchill();

        // create and initialize our temporary temperature double
        double temp = 0.0;
        // create and intiialize our stop flag
        boolean stop = false;

        // continue until we break
        while(true) {
            System.out.println("===========================================");

            // print the current state of the Temperature object and Windchill 
            // object   
            System.out.println("Fahrenheit: \t\t" + 
                    temperature.getFahrenheit());
            System.out.println("Celcius: \t\t" + temperature.getCelcius());
            System.out.println("Wind Chill Index: \t" + 
                    windchill.getWindChillIndex());
            System.out.println("Wind Speed: \t\t" + windchill.getWindspeed());  

            System.out.println("===========================================");

            // prompt the user for their next action
            System.out.println("(T/t) to change temperature");
            System.out.println("(S/s) to change wind speed");
            System.out.println("(Q/q) to quit the application");
            System.out.print("Next Action: ");

            // switch on the user input for the next action
            switch(keyboard.next().charAt(0)) {
                // the user wants to change the temperature 
                case 'T':
                case 't':
                    // prompt for the new temperature
                    System.out.print("New Temperature: ");
                    // set the temporary double to the user input until we 
                    // know units
                    temp = keyboard.nextDouble();
                    
                    // prompt for the units
                    System.out.print("Unit (F/f) or (C/c): ");
                    // switch on the user input for the unit type
                    switch(keyboard.next().charAt(0)) {
                        // the temperature is in fahrenheit 
                        case 'F':
                        case 'f':
                            // use the Temperature set method to set fahrenheit
                            temperature.setFahrenheit(temp);
                            // use the Windchill set method to set temperature
                            // (fahrenheit by default)
                            windchill.setTemperature(temperature.getFahrenheit());
                            // exit the switch
                            break;  
                        // the temperature is in celcius
                        case 'C':
                        case 'c':
                            // use the Temperature set method to set celcius
                            temperature.setCelcius(temp);
                            // use the Windchill set method to set temperature 
                            // (fahrenheit by default)
                            windchill.setTemperature(temperature.getFahrenheit());
                            // exit the switch
                            break;  
                        // the user inputed something wrong 
                        default:
                            // tell the user what they did wrong
                            System.out.println("You need to enter either 'F' or 'C'. Restarting...");
                    }
                    // exit the switch
                    break;
                // the user wants to change the wind speed
                case 'S':
                case 's':
                    // prompt for the new wind speed
                    System.out.print("New Wind Speed: ");
                    // use the Windchill set method to set new speed
                    windchill.setWindSpeed(keyboard.nextDouble());
                    // exit the switch
                    break;
                // the user wants to stop the application
                case 'Q':
                case 'q':
                    // set the stop flag to true
                    stop = true;
                    // exit the switch
                    break;
                // the user inputed something wrong 
                default:
                    // tell the user what they did wrong
                    System.out.println("You need to enter either (T/t) or (S/s). Restarting...");
            }

            // if the user put 'Q' or 'q' to quit earlier and set the stop flag
            // to true
            if(stop)
                // exit the while loop and stop the application
                break;
        }

        // farewell message
        System.out.println("Goodbye!");
    }
}
