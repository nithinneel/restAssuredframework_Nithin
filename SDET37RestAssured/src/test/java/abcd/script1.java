package abcd;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.text.StrBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class script1 {
	
public static void main(String[] args) throws IOException {
	String targetmonth = "June";
	String targetdate = "15";
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("http://");
	WebElement monthdropdown = driver.findElement(By.id(""));
	Select selectmonth = new Select(monthdropdown);
	List<WebElement> allmonths = selectmonth.getOptions();
	for (WebElement month : allmonths) {
		String mm=month.getText();
		if (mm.equalsIgnoreCase(targetmonth)) {
			break;
			
		}
	}
	WebElement datedropdown = driver.findElement(By.id(""));
	Select selectDate = new Select(datedropdown);
	List<WebElement> allDates = selectDate.getOptions();
	for (WebElement date : allDates) {
		String dd=date.getText();
		if (dd.equals(targetdate)) {
			break;
		}
	}
	byte[] tmonth = targetmonth.getBytes();
	byte[] tDate = targetdate.getBytes();
	FileOutputStream fout = new FileOutputStream("Path/fileName");
	fout.write(tmonth);
	fout.write(tDate);
}
}
