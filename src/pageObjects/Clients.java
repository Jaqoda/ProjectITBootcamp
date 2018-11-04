package pageObjects;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Clients {

private static WebElement element;
	
	public static WebElement getAddNewClient(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//i[contains(text(),'library_add')]"));
		return element;
	}
	
	public static WebElement getClientName(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//body/div[@id='app']/div[@class='application--wrap']/main[@class='v-content']/div[@class='v-content__wrap']/div[@class='container']/div[@class='mt-1 white v-card']/div[@class='v-card__actions']/div[@class='layout column']/div[@class='layout']/div[@class='flex secondary xs12']/form[@class='ma-2 pa-3 text-xs-center']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]"));
		return element;
	}
	public static WebElement getContactName(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//form[@class='ma-2 pa-3 text-xs-center']//div[1]//div[2]//div[1]//div[2]//div[1]//div[1]//input[1]"));
		return element;
	}
	public static WebElement getEmail(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='flex xs6 mr-2']//input[@type='text']"));
		return element;
	}
	public static WebElement getRegistryNumber(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//form[@class='ma-2 pa-3 text-xs-center']//div[2]//div[2]//div[1]//div[2]//div[1]//div[1]//input[1]"));
		return element;
	}
	public static WebElement getCountries(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='v-select__slot']//input[@type='text']"));
		return element;
	}
	public static WebElement getCity(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//form[@class='ma-2 pa-3 text-xs-center']//div[3]//div[2]//div[1]//div[2]//div[1]//div[1]//input[1]"));
		return element;
	}
	public static WebElement getStreet(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//body/div[@id='app']/div[@class='application--wrap']/main[@class='v-content']/div[@class='v-content__wrap']/div[@class='container']/div[@class='mt-1 white v-card']/div[@class='v-card__actions']/div[@class='layout column']/div[@class='layout']/div[@class='flex secondary xs12']/form[@class='ma-2 pa-3 text-xs-center']/div[@class='layout']/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]"));
		return element;
	}
	public static WebElement getZip(WebDriver driver)
	{
		element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[6]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/input[1]"));
		return element;
	}
	public static WebElement getDateAdded(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='flex xs3']//div[@class='v-dialog__container']//input[@type='text']"));
		return element;
	}
	public static WebElement getCode(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='v-input code-field v-text-field']//input[@type='text']"));
		return element;
	}
	public static WebElement getAgreementDay(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='flex xs3 ml-3']//input[@type='text']"));
		return element;
	}
	public static WebElement getStatus(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='v-input--selection-controls__ripple primary--text']"));
		return element;
	}
	
	public static WebElement getSave(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[contains(text(),'Save')]"));
		return element;
	}
	
	public static WebElement getStatusLabel(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//label[contains(text(),'Status: Active')]"));
		return element;
	}
	public static WebElement getMonthsForward(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='v-picker v-card v-picker--date']//div[@class='v-picker__body']//div//i[@class='v-icon material-icons'][contains(text(),'chevron_right')]"));
		return element;
	}
	public static WebElement getMonthsBackward(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='v-picker v-card v-picker--date']//div[@class='v-picker__body']//div//i[@class='v-icon material-icons'][contains(text(),'chevron_left')]"));
		return element;
	}
	
	public static WebElement getOkCalendar(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='v-btn__content'][contains(text(),'OK')]"));
		return element;
	}
	
	public static WebElement getClientNameInList(WebDriver driver) {
		element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]"));
		return element;
	}
	
	public static void setClientName(WebDriver driver, String clientName)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement clientN = getClientName(driver);
		wait.until(ExpectedConditions.elementToBeClickable(clientN));
		clientN.click();
		clientN.sendKeys(clientName);
	}
	public static void setContactName(WebDriver driver, String contactName)
	{
		getClientName(driver).click();
		getContactName(driver).sendKeys(contactName);
	}
	public static void setEmail(WebDriver driver, String email)
	{
		getEmail(driver).sendKeys(email);
	}
	public static void setRegistryNumber(WebDriver driver, String registryNumber)
	{
		getRegistryNumber(driver).sendKeys(registryNumber);
	}
	public static void setCountry(WebDriver driver, String countryName)
	{
		Actions builder = new Actions(driver);
		Actions country = builder
		.moveToElement(getCountries(driver))
		.click()
		.sendKeys(countryName);
		country.sendKeys(Keys.DOWN).sendKeys(Keys.RETURN);
		country.perform();
	}
	public static void setCity(WebDriver driver, String city)
	{
		getCity(driver).sendKeys(city);
	}
	public static void setStreet(WebDriver driver, String street)
	{
		getStreet(driver).sendKeys(street);
	}
	public static void setZip(WebDriver driver, String zip)
	{
		getZip(driver).sendKeys(zip);
	}
	public static void setDateAdded(WebDriver driver, String dateAdded) throws InterruptedException
	{
		getDateAdded(driver).click();
		Thread.sleep(1000);
		LocalDate ld = DateTimeUtils.StringToDate(dateAdded);
		int monthsBetween = DateTimeUtils.MonthsBetweenTwoDates(LocalDate.now(), ld);
		if(monthsBetween>=0)
		{
			for(int i=0;i<monthsBetween;i++)
			{
				getMonthsForward(driver).click();
				Thread.sleep(1000);
			}
		}
		else
		{
			for(int i=0;i>monthsBetween;i--)
			{
				getMonthsBackward(driver).click();
				Thread.sleep(1000);
			}	
		}
        String day = Integer.toString(ld.getDayOfMonth());
        //contains(text(),'10')
        String relXPathToRow =String.format("//*[contains(text(),'%s')]", day);
        List<WebElement> lwe = driver.findElements(By.xpath(relXPathToRow));
        lwe.get(lwe.size()-1).click();
        Thread.sleep(1000);
        System.out.println("Kliknuo na datum");
        getOkCalendar(driver).click();
        Thread.sleep(1000);
        
		
	}
	public static void setCode(WebDriver driver, String code)
	{
		getCode(driver).sendKeys(code);
	}
	public static void setAgreementDay(WebDriver driver, String agreementDay)
	{
		getAgreementDay(driver).sendKeys(agreementDay);
	}
	public static void setStatus(WebDriver driver, String status )
	{
		String currentStatus = getStatusLabel(driver).getText();
		String cs = currentStatus.split(":")[1].trim();
		if(!status.equals(cs))
		{
			getStatus(driver).click();
		}
	}
	public static void setSave(WebDriver driver)
	{
		getSave(driver).click();
	}
}


