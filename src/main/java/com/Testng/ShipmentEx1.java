package com.Testng;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//@Listeners(com.Testng.class)       //DO NOT remove or alter this line. REQUIRED FOR TESTING
public class ShipmentEx1 {

	public static WebDriver driver;

	 @BeforeMethod
	public void createDriver() { // DO NOT change the method signature
		// Create driver and assign it to 'static' driver variable
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sanjay.ravindra\\eclipse-workspace\\Selenium_Assessments\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://webapps.tekstac.com/ShipmentCharge/Index");

	}

	@DataProvider(name = "data")
	public Object[][] shipmentData() throws Exception // DO NOT change the method signature
	{
		// Parse data from Shipmentdetails.xlsx and return the 2-dimensional array
		String path = System.getProperty("user.dir") + "/" + "Excel.xlsx";
		FileInputStream input = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(input);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][cellCount];
	int k = 0;
	for (int i = 1; i <=rowCount; i++) {
		XSSFRow row = sheet.getRow(i);
		for (int j = 0; j < cellCount; j++) {
			XSSFCell cell = row.getCell(j);
			DataFormatter format = new DataFormatter();
		    data[k][j] = format.formatCellValue(cell);
		}
		k++;
	}
	return data;

	}

	// DO NOT change the method signature
	@Test(dataProvider = "data")
	void testShipment(String orginPort, String destinationPort, String railModeCharge, String roadModeCharge,
			String airModeCharge) throws InterruptedException {
		System.out.println(orginPort+"\n"+destinationPort+"\n"+railModeCharge+"\n"+roadModeCharge+"\n"+airModeCharge);
		WebElement orgin = driver.findElement(By.name("origin_id"));
		Select s = new Select(orgin);
		s.selectByVisibleText(orginPort);
		Select s1 = new Select(driver.findElement(By.name("destination_id")));
		s1.selectByVisibleText(destinationPort);
		driver.findElement(By.name("submit")).click();
		String road = driver.findElement(By.xpath("(//tr/td[2])[1]")).getText();
		StringTokenizer st = new StringTokenizer(road,".");
		String rail = driver.findElement(By.xpath("(//tr/td[2])[2]")).getText();
		StringTokenizer st1 = new StringTokenizer(rail,".");
		String air = driver.findElement(By.xpath("(//tr/td[2])[3]")).getText();
		StringTokenizer st2 = new StringTokenizer(air,".");
		assertEquals(st.nextToken(), roadModeCharge, "The Rail mode Charge doesnt match");
		assertEquals(st2.nextToken(), railModeCharge, "The Road mode Charge doesnt match");
		assertEquals(st1.nextToken(), airModeCharge, "The Air mode Charge doesnt match");
////		driver.navigate().back();
		// Select the souce/destination as specified in description.
		// Test the tabled data against the excel data as specified in description.
	}

	public void shipment() {
		// Invoke the test using TestNG ONLY HERE.
	}

	public static void main(String[] args) {
		// Ex3TestNG ex3=new Ex3TestNG();
		// Implement any required code.
	}

}
