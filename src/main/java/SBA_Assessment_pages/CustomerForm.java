package SBA_Assessment_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerForm {
	WebDriver driver;
	// Declare required variables

	public CustomerForm(WebDriver driver) {
		this.driver = driver;
	}
	// Implement code here

	public void setCustomerName(String cName) {
		driver.findElement(By.name("cname")).sendKeys(cName);
	}

	public void setAge(String age) {
		driver.findElement(By.name("age")).sendKeys(age);
	}

	public void setAddress(String address) {
		driver.findElement(By.name("address")).sendKeys(address);
	}

	public void setPhoneNumber(String phoneNumber) {
		driver.findElement(By.name("phonenumber")).sendKeys(phoneNumber);
	}

	public void setEmail(String email) {
		driver.findElement(By.name("email")).sendKeys(email);
	}

	public void submitForm() {
		driver.findElement(By.id("submit")).click();
	}

	public String getErrorMessage() {
		return driver.findElement(By.id("message")).getText();
	}

}
