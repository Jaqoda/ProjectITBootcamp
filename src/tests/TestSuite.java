package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.BussinesPage;
import pageObjects.Clients;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.ExcelUtil;

public class TestSuite {

	private WebDriver driver = null;

	// perform before all tests (setup)
	public void before() {
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://app.invoice-factory.source-code.rs/login");
	}

	// call to close all after every or after last
	public void after() {
		driver.close();
	}

	// This one will validate success login action
	public void successLogin() throws Exception {
		before();
		performLogin();

		WebElement userDataElement = Home_Page.getUserData(driver);
		
		ExcelUtil excelUtils = new ExcelUtil("/Users/jagoda/eclipse-workspace/pr_JagodaPeric/src/testData/TestData.xlsx", "SuccessLogin");
		// Open excel file sheet for this test scenario
		excelUtils.openSheet();
		if (userDataElement != null && userDataElement.getText().equals(excelUtils.getCellData(0, 2))) {
			excelUtils.setCellData("SUCCESS", 0, 3);
		} else {
			excelUtils.setCellData("FAIL", 0, 3);
		}

		after();
	}
	
	// This one will test add new bussiness action
	public void successAddNewBussines() throws Exception {
		before();
		performLogin();
		
		ExcelUtil excelUtils = new ExcelUtil("/Users/jagoda/eclipse-workspace/pr_JagodaPeric/src/testData/TestData.xlsx", "SuccessAddBussines");
		// Open excel file sheet for this test scenario
		excelUtils.openSheet();
		
		WebElement bussinesTabElement = Home_Page.getBussinessButon(driver);
		bussinesTabElement.click();
		WebElement addBussinesBtnElement = BussinesPage.getAddNewBussines(driver);
		Thread.sleep(2000);
		addBussinesBtnElement.click();
		
		WebElement bussinesNameElement = BussinesPage.getBussinesName(driver);
		bussinesNameElement.sendKeys(excelUtils.getCellData(1, 0));
		BussinesPage.SetCountry(driver, excelUtils.getCellData(1, 1));
		WebElement cityElement = BussinesPage.getCity(driver);
		cityElement.sendKeys(excelUtils.getCellData(1, 2));
		WebElement streetElement = BussinesPage.getStreet(driver);
		streetElement.sendKeys(excelUtils.getCellData(1, 3));
		WebElement zipElement = BussinesPage.getZip(driver);
		zipElement.sendKeys(excelUtils.getCellData(1, 4));
		WebElement regNumElement = BussinesPage.getRegistryNumber(driver);
		regNumElement.sendKeys(excelUtils.getCellData(1, 5));
		WebElement saveBtn = BussinesPage.getSaveBtn(driver);
		saveBtn.click();
		
		Thread.sleep(2000);
		WebElement bussinesNameInList = BussinesPage.getBussinesNameInList(driver);
		
		if (bussinesNameInList != null && bussinesNameInList.getText().equals(excelUtils.getCellData(1, 6))) {
			excelUtils.setCellData("SUCCESS", 1, 7);
		} else {
			excelUtils.setCellData("FAIL", 1, 7);
		}
		after();
	}
	
	// This one will test add new client action
	public void successAddNewClient() throws Exception {
		before();
		performLogin();
		
		ExcelUtil excelUtils = new ExcelUtil("/Users/jagoda/eclipse-workspace/pr_JagodaPeric/src/testData/TestData.xlsx", "SuccessAddClient");
		// Open excel file sheet for this test scenario
		excelUtils.openSheet();
		
		WebElement clientsTabElement = Home_Page.getClientsButon(driver);
		clientsTabElement.click();
		WebElement addClientsBtnElement = Clients.getAddNewClient(driver);
		Thread.sleep(2000);
		addClientsBtnElement.click();
		
		WebElement clientNameElement = Clients.getClientName(driver);
		clientNameElement.sendKeys(excelUtils.getCellData(0, 0));
		WebElement contactNameElement = Clients.getContactName(driver);
		contactNameElement.sendKeys(excelUtils.getCellData(0, 1));
		WebElement emailElement = Clients.getEmail(driver);
		emailElement.sendKeys(excelUtils.getCellData(0, 2));
		WebElement regNumElement = Clients.getRegistryNumber(driver);
		regNumElement.sendKeys(excelUtils.getCellData(0, 3));
		Clients.setCountry(driver, excelUtils.getCellData(0, 4));
		WebElement cityElement = Clients.getCity(driver);
		cityElement.sendKeys(excelUtils.getCellData(0, 5));
		WebElement streetElement = Clients.getStreet(driver);
		streetElement.sendKeys(excelUtils.getCellData(0, 6));
		WebElement zipElement = Clients.getZip(driver);
		zipElement.sendKeys(excelUtils.getCellData(0, 7));
		WebElement codeElement = Clients.getCode(driver);
		codeElement.sendKeys(randomCode(3));
		
		WebElement saveBtn = Clients.getSave(driver);
		saveBtn.click();
		
		Thread.sleep(2000);
		WebElement clientNameInList = Clients.getClientNameInList(driver);
		
		if (clientNameInList != null && clientNameInList.getText().equals(excelUtils.getCellData(0, 9))) {
			excelUtils.setCellData("SUCCESS", 0, 10);
		} else {
			excelUtils.setCellData("FAIL", 0, 10);
		}
		
		after();
	}
	
	// This one perform success login
	private void performLogin() throws Exception {
		ExcelUtil excelUtils = new ExcelUtil("/Users/jagoda/eclipse-workspace/pr_JagodaPeric/src/testData/TestData.xlsx", "SuccessLogin");
		// Open excel file sheet for this test scenario
		excelUtils.openSheet();

		WebElement userNameElement = LogIn_Page.getEmail(driver);
		userNameElement.sendKeys(excelUtils.getCellData(0, 0));
		WebElement passwordElement = LogIn_Page.getPassword(driver);
		passwordElement.sendKeys(excelUtils.getCellData(0, 1));
		WebElement loginBtnElement = LogIn_Page.getLogInBtn(driver);
		loginBtnElement.click();
	}
	
	private String randomCode(int length) {
		String code = "";
		for (int i = 0; i < length; i++) {
			code += rndChar();
		}
		
		return code;
	}
	
	private static char rndChar () {
	    int rnd = (int) (Math.random() * 52); // or use Random or whatever
	    char base = (rnd < 26) ? 'A' : 'a';
	    return (char) (base + rnd % 26);

	}
}
