/**
 * This class provides methods for a Temperature object in either celcius or fahrenheit units.
 * 
 * @author Karl McGuire
 * @version 09/14/17
 */

public class Temperature
{
    // stores the current temperature in fahrenheit
    private double fahrenheitTemperature;
    // stores the current temperature in celcius
    private double celciusTemperature;

    /**
     * This is the default no-args constructor and sets the fields to their default values.
     *
     */
    public Temperature() {
        fahrenheitTemperature = 32.0;
        celciusTemperature = 0.0;
    }

    /**
     * Standard set() method for setting the temperature with a celcius value.
     * 
     * @param double inTemp is the new temperature in celcius to set the fields to
     */
    public void setCelcius(double inTemp) {
        celciusTemperature = inTemp;
        fahrenheitTemperature = ((9.0/5) * celciusTemperature) + 32;
    }

    /**
     * Standard set() method for setting the temperature with a fahrenheit value.
     *
     * @param double inTemp is the new temperature in fahrenheit to set the fields to
     */
    public void setFahrenheit(double inTemp) {
        fahrenheitTemperature = inTemp;
        celciusTemperature = (fahrenheitTemperature - 32) * (5.0/9);;
    }

    /**
     * Standard get() method for getting the current temperature in fahrenheit form.
     *
     * @return double temperature in fahrenheit
     */
    public double getFahrenheit() {
        return fahrenheitTemperature;
    }

    /**
     * Standard get() method for getting the current temperature in celcius form.
     *
     * @return double temperature in celcius
     */
    public double getCelcius() {
        return celciusTemperature;
    }
}
