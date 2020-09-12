package SBA_Assessment_setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverSetup {
	
	public static WebDriver driver;
	public static String baseUrl = "http://webapps.tekstac.com/CustomerRegistration/";
	
	public  WebDriver getDriver() {
		/** For Windows OS
		    System.setProperty("webdriver.geckodriver.driver", "geckodriver.exe");
		**/
		
		/** For Linux OS **/
	    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxProfile profile=new FirefoxProfile();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        firefoxOptions.setProfile(profile);
        driver = new FirefoxDriver(firefoxOptions);
//		System.setProperty("webdriver.chrome.driver",
//				"chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.navigate().to(DriverSetup.baseUrl);
	    return driver;
	}

}
