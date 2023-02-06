import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * This class gets the number of leap years lived and the number of days lived.
 */
public class GetDaysLived {
	/**
	 * This method gets the number of leap years lived.
	 * @param birthdayDay holds the day.
	 * @param birthdayMonth holds the month.
	 * @param birthdayYear holds the year.
	 * @return Returns an int with the number of leap years lived.
	 * @throws DateTimeException Exception thrown.
	 */
	public static int leapYearsLived(int birthdayDay, int birthdayMonth, int birthdayYear) throws DateTimeException {
		int leapDays = 0; //Number of leap days lived
		
		// Creates a local date with the year, month, and day.
		LocalDate localDate = LocalDate.of(birthdayYear, birthdayMonth, birthdayDay);
		
		for (int i = 0; i <= Calendar.getInstance().get(Calendar.YEAR) - birthdayYear; i++) {
			localDate = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR) - i, birthdayMonth, birthdayDay);
			if (localDate.isLeapYear() == true){
				leapDays++;
			}
		}
		return leapDays;
	}
	/**
	 * Gets the number of days lived based on parameters.
	 * @param birthdayDay Holds the day.
	 * @param birthdayMonth Holds the month.
	 * @param birthdayYear Holds the year.
	 * @param leapDays Holds the number of leap years lived.
	 */
	public static void getDaysLived(int birthdayDay, int birthdayMonth, int birthdayYear, int leapDays) {
	    
		int addDay = 0;
		
		if (birthdayMonth == 2 && birthdayDay == 29) {
			birthdayDay--;
			addDay++;
		}
		
		int daysLived = 0;
		// Gets the current year based on today.
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		// Local date created based on parameters.
		LocalDate localDate = LocalDate.of(birthdayYear, birthdayMonth, birthdayDay);

		int dayOfYearBorn = localDate.getDayOfYear();
		mainMethod.dayOfYearBorn = dayOfYearBorn;

		int daysOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		mainMethod.daysOfYear = daysOfYear;
		
		// Calculates the number of days lived.
		int yearsLivedToDays = (((currentYear - birthdayYear)) * 365 - dayOfYearBorn + leapDays - addDay); //subtract the months from time born (if born in June, subtract 6 months)
		
		// Factors in leap year.
		daysLived = (yearsLivedToDays + daysOfYear);
		mainMethod.daysLived = daysLived;
	}
}
