package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {

	private static WebElement web_element = null;

	public static WebElement getBussinessButon(WebDriver driver) {

		web_element = driver.findElement(By.xpath("//a[@id='nav-bar-business']//div[@class='v-btn__content']"));
		return web_element;

	}

	public static WebElement getClientsButon(WebDriver driver) {
		web_element = driver.findElement(By.xpath("//a[@id='nav-bar-clients']//div[@class='v-btn__content']"));
		return web_element;// click

	}

	public static WebElement getUserData(WebDriver driver) {
		List<WebElement> webElements = driver.findElements(By.xpath("//strong[@id='home-page-user']"));
		if (webElements.isEmpty()) {
			web_element = null;
		} else {
			web_element = webElements.get(0);
		}

		return web_element;
	}

}
