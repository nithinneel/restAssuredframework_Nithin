package GenericUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author nithin
 *
 */
public class BaseClass 
{
	
	public static WebDriver sdriver;
	public WebDriver driver;
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility  wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	public BaseAPIClass apiLib= new BaseAPIClass();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	
	/**
	 * connecting to database
	 */
//	@BeforeSuite
//	public void dbConfig()
//	{
//		dLib.ConnectToDatabase();
//	}
	/**
	 * launching the browser
	 * @throws Throwable
	 */
	//@Parameters("BROWSER")
	@BeforeMethod
	public void launchTheBrowser()
	{  
		String BROWSER = null;
		try {
			BROWSER = fLib.getThePropertiesFile("browser");
			System.out.println(BROWSER);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(BROWSER);
		String URL = null;
		try {
			URL = fLib.getThePropertiesFile("url");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			System.out.println("1");
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else {
			driver=new ChromeDriver();
		}

		System.out.println("Browser successfully launched");
		//implicitly wait
		sdriver=driver;
		wLib.waitForPageToLoad(driver);
		//enter the URL of the Application
		sdriver.get(URL);
		//maximize the screen
		driver.manage().window().maximize();
	}
	
	/**
	 * login to application as employee
	 */
	@BeforeMethod
//	public void loginToAppln()
//	{
//		String USERNAME = null;
//		try {
//			USERNAME = fLib.getThePropertiesFile("loginUserName");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		String PASSWORD = null;
//		try {
//			PASSWORD = fLib.getThePropertiesFile("loginPassword");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//
//		Loginpage loginpage  = new Loginpage(driver);
//		loginpage.loginToApp(USERNAME, PASSWORD);
//		System.out.println("Employee Login successful");
//	}	
	/**
	 * logout from application
	 */
//	@AfterMethod
//	public void logoutFromAppln()
//	{
//		HomePage homePage = new HomePage(driver);
//		homePage.Logout();
//		System.out.println("Logout successful");
//	}
	/**
	 * close the browser
	 */
	@AfterClass
	public void closeTheBrowser()
	{
		driver.quit();
		System.out.println("Browser successfully closed");
	}
	/**
	 * close database configuration
	 */
//	@AfterSuite
//	public void closeDBconfig()
//	{
//		dLib.closeDb();
//	}
}