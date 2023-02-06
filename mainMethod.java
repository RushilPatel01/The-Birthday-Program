import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.time.Period;

import javax.swing.JOptionPane;

/**
 * Main method that assembles everything together. All the information used in the GUI.
 *
 */
public class mainMethod {
	
	// All of these values holds different things, which are assigned later and used in the GUI Program.
	
	public static String zodiacSign;
	public static String gemstone;
	public static String sign;
	public static String zodiacSignString;
	
	public static int leapDaysLived;
	public static int daysLived;
	public static int daysOfYear;
	public static int dayOfYearBorn;
	
	public static int birthdayDay;
	public static int birthdayMonth;
	public static int birthdayYear;
	public static String birthDate;
	
	public static LocalDate userDate;

	public static int currentMonth;
	public static int currentDay;
	public static int currentYear;
	public static int currentDate;
	public static String currentTime;
	
	public static int[] exactAgeArr;
	
	public static int exactAgeYear;
	public static int exactAgeMonth;
	public static int exactAgeDay;
	
	public static int[] timeLeftArr;
	
	public static int timeLeftYear;
	public static int timeLeftMonth;
	public static int timeLeftDay;
	
	/**
	 * This main method compiles everything from all the other classes and assigns it to the above
	 * values which are used when creating the GUI.
	 * 
	 * @param args
	 */
	public static void main (String [] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Prompts the user for their birthday (Format must be exact)
		birthDate = JOptionPane.showInputDialog("Date (Write in format 'yyyymmdd'):");
		
		//Close keyboard
		input.close();
		
		//Seperates birthDate into three seperate integers for LocalDate
		birthdayMonth = Integer.parseInt(birthDate.substring(4, 6));
		birthdayDay = Integer.parseInt(birthDate.substring(6, 8));
		birthdayYear = Integer.parseInt(birthDate.substring(0, 4));
		
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
	    LocalDateTime now = LocalDateTime.now();  
	    currentTime = (dtf.format(now));
	    
		//Use the LocalDate class in order to get the day of year for other methods
		LocalDate userDate = LocalDate.of(birthdayYear, birthdayMonth, birthdayDay);
		
		//Calls the astrology method from the getZodiac class
		zodiacSign = getZodiac.astrology(userDate);
		zodiacSignString = getZodiac.getHoroscope(userDate);
		
		//Calls getGemstone method from GetGemstone class
		gemstone = GetGemstone.getGemstone(birthdayMonth);
		
		//Calls the leapYearsLived method from the getDaysLived class
		leapDaysLived = GetDaysLived.leapYearsLived(birthdayDay, birthdayMonth, birthdayYear);
		
		//Calls the getDaysLived from the GetDaysLived class
		GetDaysLived.getDaysLived(birthdayDay, birthdayMonth, birthdayYear, leapDaysLived);
		
		//Calculates the current date; used in the OpenConnection method
		currentMonth = Integer.parseInt(dtf.format(now).substring(5, 7));
		currentDay = Integer.parseInt(dtf.format(now).substring(8, 10));
		currentYear = Integer.parseInt(dtf.format(now).substring(0, 4));
		currentDate = currentYear + currentMonth + currentDay;
	    		
		GUI.main(args); //Always open the GUI at the end so that it gets all of the variables
		
		
		Period exactAge = dateInformation.timeSince(userDate);
		// Assigns the exact age array created earlier.
		exactAgeArr = dateInformation.periodToArray(exactAge);
		// Each int is assigned to the proper array element.
		exactAgeYear = exactAgeArr[0];
		exactAgeMonth = exactAgeArr[1];
		exactAgeDay = exactAgeArr[2];
		
		Period timeLeft = dateInformation.timeLeft(userDate);
		// Assigns the time left array created earlier.
		timeLeftArr = dateInformation.periodToArray(timeLeft);
		
		// Each int is assigned to the proper array element.
		timeLeftYear = timeLeftArr[0];
		timeLeftMonth = timeLeftArr[1];
		timeLeftDay = timeLeftArr[2];
	}
	
	/**
	 * Based on different cases, it gets the birth month name based on month number.
	 * @param month Holds month number.
	 * @return null
	 */
	public static String getBirthdayMonth(int month) {
		switch(month) {
			case 1: return "January"; 
			case 2: return "February"; 
			case 3: return "March"; 
			case 4: return "April";
			case 5: return "May"; 
			case 6: return "June"; 
			case 7: return "July"; 
			case 8: return "August"; 
			case 9: return "September"; 
			case 10:return "October"; 
			case 11:return "November"; 
			case 12:return "December"; 
				
		}
		return null;
	}
}
