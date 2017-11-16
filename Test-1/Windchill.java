/**
 * This class holds fields and methods used
 * for determining the wind chill index given the
 * temperature in Fahernheit and the speed
 * of the wind in miles per hour
 * 
 * @author L. Lehmann
 * @version v1
 */
public class Windchill
{
    private double temperatureInFahr;
    private double windspeed;
    private double windChillIndex;
    
    public Windchill() 
	{
        temperatureInFahr = 32;
        windChillIndex = 32;
        windspeed = 0;
    }
    
    public Windchill(double inTemperature, double inWindSpeed)
    {
        temperatureInFahr = inTemperature;
        windspeed = inWindSpeed;
        if(temperatureInFahr < 50 && windspeed > 3)
           windChillIndex = 35.74 + (.6215 * temperatureInFahr) - (35.75 * Math.pow(windspeed, 0.16))
                         + (.4275 * temperatureInFahr * Math.pow(windspeed, 0.16));
        else
           windChillIndex = temperatureInFahr;
    
    }
    
    public void setTemperature(double inTemperature)
    {
     temperatureInFahr = inTemperature;
       
      if(temperatureInFahr < 50 && windspeed > 3)
         windChillIndex = 35.74 + (.6215 * temperatureInFahr) - (35.75 * Math.pow(windspeed, 0.16))
                       + (.4275 * temperatureInFahr * Math.pow(windspeed, 0.16));
      else
       windChillIndex = temperatureInFahr;
    }
    
    public void setWindSpeed(double inWindSpeed)
    {
        windspeed = inWindSpeed;
        if(temperatureInFahr < 50 && windspeed > 3)
           windChillIndex = 35.74 + (.6215 * temperatureInFahr) - (35.75 * Math.pow(windspeed, 0.16))
                         + (.4275 * temperatureInFahr * Math.pow(windspeed, 0.16));
        else
           windChillIndex = temperatureInFahr;
    }
    
    public double getTemperatureInFahr(  )
    {
        return temperatureInFahr;
    }
    
    public double getWindspeed( )
    {
        return windspeed;
    }
    
    public double getWindChillIndex( )
    {
        return windChillIndex;
    }
    
    public String toString( )
    {
        return "Fahernheit temperature: " + temperatureInFahr
              + "\nWind speed in mph: " + windspeed
              + "\nWind chill index: " + windChillIndex;
    }
    
} 
