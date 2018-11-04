package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page {

private static WebElement web_element = null;
	
	public static WebElement getEmail(WebDriver driver) {
		web_element = driver.findElement(By.xpath("//input[@id='login-form-email']"));
		return web_element;

	}
	
	public static void setEmail(WebDriver driver, String mail) {
		getEmail(driver).sendKeys(mail);
	}
	
	public static WebElement getPassword(WebDriver driver) {
		web_element = driver.findElement(By.xpath("//input[@id='login-pass']"));
		return web_element;
	}
	
	public static void setPassword(WebDriver driver, String password) {
		getPassword(driver).sendKeys(password);
	}
	
	
	public static WebElement getLogInBtn(WebDriver driver) {

		web_element = driver.findElement(By.xpath("//div[@class='v-btn__content']"));
		return web_element;//click
	}
	
	
}