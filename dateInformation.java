import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
/**
 * Collects a date, then tells the user time left, and time since the given date.
 * @author Tom Wells
 * @version 1.0
 */
public class dateInformation {
	
	/**
	 * Finds the amount of time the user will live based on the inputed birthday. 
	 * @param userDate The user's inputed birthday.
	 * @return A Period consisting of the amount of time the user has to live.
	 */
	public static Period timeLeft(LocalDate userDate) {
		// The average human life is 78 years, 7 months, and 6 days
		final Period humanLife = Period.of(78, 7, 6);
		// Used Period to get the time between the inputed day and the current time.
		Period currentAge = Period.between(userDate, LocalDate.now());
		
		Period timeLeft = humanLife.minus(currentAge);
		// Reformat to avoid negative months or days
		if (timeLeft.getDays() < 0) {
			timeLeft = timeLeft.plusDays(30);
			timeLeft = timeLeft.minusMonths(1);
		}
		if (timeLeft.getMonths() < 0) {
			timeLeft = timeLeft.plusMonths(12);
			timeLeft = timeLeft.minusYears(1);
		}
		
		return timeLeft;
	}
	
	/**
	 * Convert a period to an array of integers.
	 * @param source The Period to be converted.
	 * @return An array of size 3 that contains the contents of the Period.
	 */
	public static int[] periodToArray(Period source) {
		// Creates an int array.
		int[] result = new int[3];
		// Assigns each element to the appropriate value.
		result[0] = source.getYears();
		result[1] = source.getMonths();
		result[2] = source.getDays();
		
		return result;
	}
	
	/**
	 * Get the time  in years, months, and days since the user's inputed date.
	 * @param userDate The user's inputed date.
	 * @return A Period consisting of the time since the user's inputed date.
	 */
	public static Period timeSince(LocalDate userDate) {
		// Uses Period to get the current age between the inputed date and the current time.
		Period currentAge = Period.between(userDate, LocalDate.now());
		return currentAge;
	}
}