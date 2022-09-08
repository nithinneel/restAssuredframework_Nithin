package GenericUtility;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author nithin
 *
 */
public class JavaUtility {
	/**
	 * this method is used to generate the random number	
	 * @return
	 */
	public int createRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		return randomNumber;
	}
	/**
	 * this method is used to get local time and date
	 */
	public String getSystemDate() {
		Date systemDate = new Date();
		String dateTime = systemDate.toString();
		return dateTime;
	}
	/**
	 * this method is used to get local date in format
	 * @return
	 */
	public String dateFormat() {
		LocalDateTime dateTime = LocalDateTime.now();
		String time = dateTime.getDayOfMonth()+"-"+dateTime.getMonthValue()+"-"+dateTime.getYear()+" "+dateTime.getHour()+":"+dateTime.getMinute();
		return time;
		
	}
}

