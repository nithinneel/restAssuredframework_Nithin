package UsingFramework;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtility.DatabaseUtility;
import GenericUtility.EndPointsLibrary;
import GenericUtility.IConstants;
import GenericUtility.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.createProLibrary;

public class createAndUpdatePro {
	public class endToEndCreateDeleteAndVerifyPro {
		
		JavaUtility jLib = new JavaUtility();
		String ProName="apple"+jLib.createRandomNumber();
		WebDriver driver = null;

	@Test(priority = 1)
	public void createProUsingAPI() {
		
		//create project using API
		baseURI=IConstants.BASEURI;
		port=IConstants.PORTNUM;
		createProLibrary pLib = new createProLibrary("Nithin",ProName,"created",5);
		
		Response response = given()
		.body(pLib).contentType(ContentType.JSON)
		.when().post(EndPointsLibrary.createProject);
		response.then().assertThat().statusCode(201).log().all();    
	}
	@Test(priority = 3)
	public void verifyProInGuiUsingSelenium() {
		//find the element in WebPage GUI using Selenium
		//launch the browser
		WebDriverManager.chromedriver().create();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.get(IConstants.rmgyantraURL);
		driver.findElement(By.id("usernmae")).sendKeys(IConstants.rmgUserName);
		driver.findElement(By.id("inputPassword")).sendKeys(IConstants.rmgPassword);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		driver.findElement(By.xpath("//li/a[.='Projects']")).click();
		String project = driver.findElement(By.xpath("//tr/td[.='"+ProName+"']/..")).getText();
		System.out.println(project);
		if (project.contains(ProName)) {
			System.out.println("Project created and verified in GUI");
		}
		driver.quit();
	}

	@Test(priority = 2)
	public void verifyProInDataBaseUsingJdbc() throws SQLException {
		//verify in Database
		DatabaseUtility dLib = new DatabaseUtility();
		dLib.ConnectToDatabase("projects");
		dLib.executeQuery("select * from project", 4, ProName);
		dLib.closeDb();
	}
	}
}
