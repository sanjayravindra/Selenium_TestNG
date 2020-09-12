package com.Testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustReg {
	// DO NOT Change the class Name

	// Use the below declarations
	static WebDriver driver;
	static String[][] excelData = null;

	@BeforeSuite
	public void createDriver() { // DO NOT change the method signature
		// Annotate this with BeforeSuite
		// Create driver and assign it to 'static' driver variable
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sanjay.ravindra\\eclipse-workspace\\Selenium_Assessments\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://webapps.tekstac.com/CustomerRegistration_4284/");
	}

	@DataProvider(name = "Customers")
	public Object[][] usersData() throws Exception { // DO NOT change the method signature
		// Annotate this method with data provider name as "Customers".
		// Parse data from Customers.xlsx, store in excelData variable and return the
		// 2-dimensional array
		String path = System.getProperty("user.dir") + "/Excel.xlsx";
		FileInputStream input = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(input);
		XSSFSheet sheet = book.getSheet("Sheet2");
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount + 1][cellCount];
		excelData = new String[rowCount + 1][cellCount];
		for (int i = 0; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cellCount; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter format = new DataFormatter();
				data[i][j] = format.formatCellValue(cell);
				String value = data[i][j].toString();
				excelData[i][j] = value;
			}
		}
		return data;
	}

	@Test(dataProvider = "Customers", priority = 0)
	void testUser(String Uname, String Uphoneno, String Udob, String gender, String Uaddr) { // DO NOT change the method
																								// signature
		// Annotate this method with data provider name as "Customers". Add 'priority=0'
		// Fill the form using data parsed from excel and submit
		driver.findElement(By.id("name")).sendKeys(Uname);
		driver.findElement(By.id("mobile")).sendKeys(Uphoneno);
		driver.findElement(By.id("dob")).sendKeys(Udob);
		driver.findElement(By.id(gender)).click();
		driver.findElement(By.id("address")).sendKeys(Uaddr);
		driver.findElement(By.id("register")).click();
	}

	@Test(testName = "testName", priority = 1)
	void testName() { // DO NOT change the method signature
		// Locate the name in "Registered Successfully page". Assert it against the
		// excel data.Set 'Name doesnt match 'custom failure message in assert
		String name = driver.findElement(By.xpath("//*[@id=\"errorMessage\"]/table/tbody/tr[1]/td[2]")).getText();
		try {
			Assert.assertEquals(name, excelData[0][0]);
		} catch (AssertionError a) {
			System.out.println("Name doesnt match");
			throw a;
		}
	}

	@Test(testName = "testPhone", priority = 2)
	void testPhone() { // DO NOT change the method signature
		// Locate the phone in "Registered Successfully page". Assert it against the
		// excel data.Set 'Name doesnt match 'custom failure message in assert
		String phone = driver.findElement(By.xpath("//*[@id=\"errorMessage\"]/table/tbody/tr[2]/td[2]")).getText();
		try {
			Assert.assertEquals(phone, excelData[0][1]);
		} catch (AssertionError a) {
			System.out.println("Name doesnt match");
			throw a;
		}
	}

	@Test(testName = "testDOB", priority = 3)
	void testDOB() { // DO NOT change the method signature
		// Locate the date of birth in "Registered Successfully page". Assert it against
		// the excel data.Set 'Name doesnt match 'custom failure message in assert
		String dob = driver.findElement(By.xpath("//*[@id=\"errorMessage\"]/table/tbody/tr[3]/td[2]")).getText();
		try {
			Assert.assertEquals(dob, excelData[0][2]);
		} catch (AssertionError a) {
			System.out.println("Name doesnt match");
			throw a;
		}
	}

	@Test(testName = "testGender", priority = 4)
	void testGender() { // DO NOT change the method signature
		// Locate the gender in "Registered Successfully page". Assert it against the
		// excel data.Set 'Name doesnt match 'custom failure message in assert
		String gender = driver.findElement(By.xpath("//*[@id=\"errorMessage\"]/table/tbody/tr[5]/td[2]")).getText();

		try {
			Assert.assertEquals(gender, excelData[0][3]);
		} catch (AssertionError a) {
			System.out.println("Name doesnt match");
			// throw a;
		}
	}

	public void checkUser() { // DO NOT change the method signature
		// Invoke the test using TestNG ONLY HERE.
		TestNG testsuite = new TestNG();
		testsuite.setTestClasses(new Class[] { CustReg.class });
		try {
			testsuite.run();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		CustReg cr = new CustReg();
		// Implement code here
		cr.createDriver();
		cr.checkUser();
	}

}
