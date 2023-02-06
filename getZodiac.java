import java.time.LocalDate;

/**
 * Gets the zodiac sign and horoscope.
 *
 */
public class getZodiac {
	
	/**
	 * Gets the zodiac sign based on the day.
	 * 
	 * @param userDate Holds the date.
	 * @return null.
	 */
	public static String astrology(LocalDate userDate) {
	   	 int day = userDate.getDayOfYear();
	   	 
	   	 if (inRangeInclusive(day, 80, 109)) {
	   		 return "1"; //Aries
	   	 } else if (inRangeInclusive(day, 110, 140)) {
	   		 return "2"; //Taurus
	   	 } else if (inRangeInclusive(day, 141, 171)) {
	   		 return "3"; //Gemin i
	   	 } else if (inRangeInclusive(day, 172, 203)) {
	   		 return "4"; //Cancer
	   	 } else if (inRangeInclusive(day, 204, 234)) {
	   		 return "5"; //Leo
	   	 } else if (inRangeInclusive(day, 235, 265)) {
	   		 return "6"; //Virgo
	   	 } else if (inRangeInclusive(day, 266, 295)) {
	   		 return "7"; //Libra
	   	 } else if (inRangeInclusive(day, 296, 325)) {
	   		 return "8"; //Scorpio
	   	 } else if (inRangeInclusive(day, 325, 355)) {
	   		 return "9"; //Sagittarius
	   	 } else if (356 <= day || day <= 20) { // Hard coded because of the wrap around
	   		 return "10"; //Capricorn
	   	 } else if (inRangeInclusive(day, 21, 49)) {
	   		 return "11"; //Aquarius
	   	 } else if (inRangeInclusive(day, 50, 79)) {
	   		 return "12"; //Pisces
	   	 }
	   	 return null;
	    }
	
	/**
	 * Like the astrology method, it checks the day and finds where it is in the range and returns the proper information.
	 * 
	 * @param userDate User date.
	 * @return null
	 */
	public static String getHoroscope(LocalDate userDate) {
	   	 int day = userDate.getDayOfYear();
	   	 
	   	 if (inRangeInclusive(day, 80, 109)) {
	   		 return "Aries"; //Aries
	   	 } else if (inRangeInclusive(day, 110, 140)) {
	   		 return "Taurus"; //Taurus
	   	 } else if (inRangeInclusive(day, 141, 171)) {
	   		 return "Gemini"; //Gemin i
	   	 } else if (inRangeInclusive(day, 172, 203)) {
	   		 return "Cancer"; //Cancer
	   	 } else if (inRangeInclusive(day, 204, 234)) {
	   		 return "Leo"; //Leo
	   	 } else if (inRangeInclusive(day, 235, 265)) {
	   		 return "Virgo"; //Virgo
	   	 } else if (inRangeInclusive(day, 266, 295)) {
	   		 return "Libra"; //Libra
	   	 } else if (inRangeInclusive(day, 296, 325)) {
	   		 return "Scorpio"; //Scorpio
	   	 } else if (inRangeInclusive(day, 325, 355)) {
	   		 return "Sagittarius"; //Sagittarius
	   	 } else if (356 <= day || day <= 20) { // Hard coded because of the wrap around
	   		 return "Capricorn"; //Capricorn
	   	 } else if (inRangeInclusive(day, 21, 49)) {
	   		 return "Aquarius"; //Aquarius
	   	 } else if (inRangeInclusive(day, 50, 79)) {
	   		 return "Pisces"; //Pisces
	   	 }
	   	 return null;
	    }
	
	/**
	 * Used in both the getHoroscope method and astrology method.
	 * 
	 * @param val Holds the day which is tested to see where it is located.
	 * @param lower Holds the lower value.
	 * @param upper Holds the higher value.
	 * @return Returns either true or false.
	 */
	public static boolean inRangeInclusive(int val, int lower, int upper) {
	   	 if (lower <= val && val <= upper) {
	   		 return true;
	   	 } else {
	   		 return false;
	   	 }
	    }
}
