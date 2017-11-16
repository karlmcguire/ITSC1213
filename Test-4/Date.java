/**
 * Date holds a date and performs operations on the date.
 *
 * @author Karl McGuire
 * @version 11/15/17
 */
public class Date {
    // month holds the month number (1-12)	
    private int month;
    // day holds the day number (1-31)
	private int day;
    // year holds the year number (e.g. 2017)
	private int year;

    // daysPerMonth holds the days per month where the month is the index, note
    // that leap years aren't accounted for in this array, the daysInMonth 
    // function handles leap years
	private static final int[] daysPerMonth = new int[]{
        0, 
        31, // (1)  January
        28, // (2)  February
        31, // (3)  March
        30, // (4)  April
        31, // (5)  May
        30, // (6)  June
        31, // (7)  July
        31, // (8)  August
        30, // (9)  September
        31, // (10) October
        30, // (11) November
        31  // (12) December
    };

    /**
     * Date() creates an empty date object.
     *
     * @return new Date object
     */
	public Date() {
        // set all fields to 0
		month = day = year = 0;
	}

    /**
     * Date creates a new Date object with the parameters.
     *
     * @param m is the month number (1-12)
     * @param d is the day number (1-31)
     * @param y is the year number (e.g. 2017)
     * @return new Date object
     */
	public Date(int m, int d, int y) {
        // make sure the month param is between 1 and 12, otherwise set 0
		month = (m >= 1 && m <= 12) ? m : 0;
        // set the year field
		year = y;
        // make sure the days correspond with the # of days in the month, 
        // otherwise set 0
		day = (d <= daysInMonth(month, year)) ? d : 0;
	}

    /**
     * Date creates a new Date object with the parameters.
     *
     * @param m is the month String (eg. "January")
     */
	public Date(String m, int d, int y) {
        // set the month field based on param, if invalid set month to 0
		switch(m.toLowerCase()) {
			case "january": month = 1;
				break;
			case "february": month = 2;
				break;
			case "march": month = 3;
				break;
			case "april": month = 4;
				break;
			case "may": month = 5;
				break;
			case "june": month = 6;
				break;
			case "july": month = 7;
				break;
			case "august": month = 8;
				break;
			case "september": month = 9;
				break;
			case "october": month = 10;
				break;
			case "november": month = 11;
				break;
			case "december": month = 12;
				break;
			default: month = 0;
				break;
		}
	
        // set the year field to param
		year = y;
        // set the day field if valid (based on the month), otherwise set 0
		day = (d <= daysInMonth(month, year)) ? d : 0;
	}

    /**
     * daysBetween returns the days between the current object and the param.
     *
     * @return number of days between
     */
	public int daysBetween(Date date) {
        // get the year difference
		int yd = year - date.getYear();
        // get the month difference
		int md = month - date.getMonth();
        // start the total count with the day difference
        int count = Math.abs(day - date.getDay());

        // for each year difference, add 365 (for regular year) or 366 (for 
        // leap year)
		for(int i = 0; i < Math.abs(yd); i++)
			count += (yd < 0) ? 
                daysInYear(year + i) :
                daysInYear(date.getYear() + i);
	
        // for each month difference, add the days of that month
		for(int i = 0; i < Math.abs(md); i++)
			count += (md < 0) ? 
                daysInMonth(month + i, year) : 
                daysInMonth(date.getMonth() + i, date.getYear());

        // return the total day difference
		return count;
	}

    /**
     * Gets the Julian date. 
     *
     * @return day of the year 
     */
    public int getJulianDate() {
        int count = day;

        // count the days of each previous month, daysInMonth handles the extra
        // day in the case of a leap year
        for(int i = (month - 1); i >= 1; i--)
            count += daysInMonth(i, year);

        return count;
    }
   
    /**
     * add adds the specified number of days to the Date.
     *
     * @param numDays is the number of days to add (must be positive)
     */
	public Date add(int numDays) {
	    // if number of days to add + current day (of current month) > total
        // number of days in that month (eg. 31), then we need to increment
        // the month, possibly the year, and adjust numDays for next call
        if(numDays + day > daysInMonth(month, year))
			return new Date(
                    // set new month to month + 1 (nextMonth handles 12 -> 1)
					nextMonth(month),
                    // if numDays > daysInMonth(current month, year), then
                    //     set new days to 0
                    // else
                    //     set new days to days + numDays (eg. < than 31)
					(numDays > daysInMonth(month, year)) ? 0 : day + numDays,
                    // set new year to year + 1 if month == 12, otherwise same 
					nextYear(month, year)).add(
                        // add the new numDays based on the numDays left after
                        // subtracting from the current day
						(numDays > daysInMonth(month, year)) ?
                            // new numDays minus the days added
                            numDays - (daysInMonth(month, year) - day) : 
                            // set days = 1 by adding 1 to the new Date
                            1);		
		
        // we don't need to increment month or year, so just return with a
        // simple addition to the day count
		return new Date(month, day + numDays, year);
	}

    /**
     * subtract subtracts the number of days from the Date.
     *
     * @param numDays is the number of days to subtract (must be positive)
     */
	public Date subtract(int numDays) {
        // check if we need to go into the previous month
		if(day - numDays <= 0)
			return new Date(
                    // previousMonth handles 1 -> 12 conversion
					previousMonth(month), 
                    // get the days in the previous month and handle leap years
					daysInMonth(
                        previousMonth(month), 
                        previousYear(month, year)),
                    // might need to subtract from the year field
					previousYear(month, year)).subtract(
                        // adjust the new subtraction amount to account for the
                        // days we already subtracted
						(numDays > daysInMonth(month, year)) ? 
                            // new numDays don't include the days of the
                            // current month
                            numDays - day :
                            // don't subtract anymore with this recursion call,
                            // just skip to the last statement
                            0);

        // there was no need to subtract from the month field so we can just 
        // return with a simple subtraction
		return new Date(month, day - numDays, year);
	}

    /**
     * nextYear returns the number of the next year when passed the current
     * month (m) and the current year(y).
     *
     * @param m is the current month
     * @param y is the current year
     * @return next year number
     */
	private static int nextYear(int m, int y) {
		return (m + 1 == 13) ? y + 1 : y;
	}
    
    /**
     * previousYear returns the number of the previous year when passed the
     * current month (m) and the current year (y).
     *
     * @param m is the current month
     * @param y is the current year
     * @return previous year number
     */
	private static int previousYear(int m, int y) {
		return (m - 1 == 0) ? y - 1 : y; 
	}

    /**
     * nextMonth returns the next month (1-12) when passed the current month.
     *
     * @param m is the current month
     * @return next month number (1-12)
     */
	private static int nextMonth(int m) {
		return (m + 1 == 13) ? 1 : m + 1;
	}

    /**
     * previousMonth returns the previous month (1-12) when passed the current
     * month.
     *
     * @param m is the current month
     * @return previous month number (1-12)
     */
	private static int previousMonth(int m) {
		return (m - 1 == 0) ? 12 : m - 1;
	}

    /**
     * daysInMonth uses a lookup array to return the total number of days in
     * the current month (m) of the current year (y) and handles leap years.
     *
     * @param m is the current month
     * @param y is the current year
     * @return the number of days in the month (m) of the year (y)
     */
	private static int daysInMonth(int m, int y) {
        // return based on a ternary if:
		return ((m == 2) && 
                (isLeapYear(y)) ? 
                    // if it's a leap year && the month is february
                    29 : 
                    // if it's not february || not a leap year
                    //
                    // see daysPerMonth field for lookup array
                    daysPerMonth[m]);
	}

    /**
     * daysInYear determines if the year is a leap year or not and returns the
     * number of days in the year.
     *
     * @param y is the year to check
     * @return number of days in year
     */
	private static int daysInYear(int y) {
        return (isLeapYear(y)) ? 366 : 365;
	}

    /**
     * isLeapYear determines if the year param is a leap year or not.
     *
     * @param y is the year to check
     * @return true if year (y) is a leap year
     * @return false if year (y) is not a leap year
     */
	private static boolean isLeapYear(int y) {
	    // leap years have no remainder when / 4 &&
        //     leap years / 100 have no remainder OR
        //     leap years / 400 have no remainder
        return ((y % 4 == 0) && 
                (y % 100 != 0 || y % 400 == 0));
	}

    /**
     * daySuffix returns the correct suffix based on the day number.
     *
     * @param d is the day number (1-31)
     * @return suffix string ("st", "nd", "rd", "th")
     */
	private static String daySuffix(int d) {
        // switch on the last digit of the date (eg. 17 -> 7 -> "th")
        //                                      (eg. 23 -> 3 -> "rd")
        switch(d % 10) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
        }

		return "th";
	}

    /**
     * monthName returns the name of the month 
     *
     * @return month name (eg. "November")
     */
	private static String monthName(int m) {
        // self-explanatory
        switch(m) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
        }

        // m wasn't 1-12
		return "invalid month - should be 1-12";	
	}

    /**
     * getMonth returns the month number (1-12) of this object.
     *
     * @return month number (1-12)
     */
	public int getMonth() {
		return month;
	}

    /**
     * getDay returns the day number (1-31) of this object.
     *
     * @return day number (1-31)
     */
	public int getDay() {
		return day;
	}

    /**
     * getYear returns the year number
     *
     * @return year number (eg. 2017)
     */
	public int getYear() {
		return year;
	}

    /**
     * equals determines if parameter object is equal to this object.
     *
     * @return true if equal
     * @return false if not equal
     */
	public boolean equals(Date d) {
		return (month == d.getMonth() && 
                day   == d.getDay()   && 
                year  == d.getYear());
	}

    /**
     * compareTo compares the paramater object with this object.
     *
     * @return 1 if parameter is greater than this object
     * @return -1 if parameter is less than this object
     * @return 0 if parameter is equal to this object
     */
	public int compareTo(Date d) {
        // check if the years are different
        if(year < d.getYear())
			return -1;
		else if(year > d.getYear())
			return 1;
		
        // check if the months are different
		if(month < d.getMonth())
			return -1;
		else if(month > d.getMonth())
			return 1;

        // check if the days are different
		if(day < d.getDay())
			return -1;
		else if(day > d.getDay())
			return 1;

        // they are equal
		return 0;
	}

    /**
     * getDate returns the date in a string format based on the parameter.
     *
     * @param format either 'S' for short (11/07/17) or 'L' for long (November
     * 7th, 2017)
     * @return formatted string of the date
     */
	public String getDate(char format) {
		if(format == 'S' || format == 's')
			return String.format("%02d/%02d/%02d", month, day, year % 100);
		else if(format == 'L' || format == 'l')
			return String.format("%s %d%s, %d", 
                    monthName(month), day, daySuffix(day), year);
		
		return "invalid format - use 'S' or 'L'";
	}

    /**
     * toString returns a String of the current date (using short formatting).
     *
     * @return short formatted string of date
     */
	public String toString() {
		return getDate('S');	
	}
}
