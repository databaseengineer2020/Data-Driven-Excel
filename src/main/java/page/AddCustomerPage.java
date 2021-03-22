package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),' Contacts ')]") WebElement CUSTOMER_HEADER_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='account']") WebElement USER_FULLNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id = 'cid']") WebElement COMPANY_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@ id ='email']") WebElement USER_EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@ id ='phone']") WebElement USER_PHONE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@ id ='address']") WebElement USER_ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@ id ='city']") WebElement USER_CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id = 'country']") WebElement COUNTERY_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='state']") WebElement USER_STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']") WebElement USER_ZIP_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@id = 'submit']") WebElement SAVE_BUTTON_FIELD;
	@FindBy(how = How.XPATH, using = "//a[@id = 'summary']") WebElement SUMMARY_BUTTON_FIELD;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]") WebElement ALERT_OK_BUTTON_FIELD;
	
	
	
	//Interactive Methods
	public void validateCustomerHeader() {
		Assert.assertEquals(CUSTOMER_HEADER_FIELD.getText(), "Contacts", "Add Customer Page Not Found!");
	}
	

	//Global Variable
	String enterdName;
	
	public void insertCustomerName(String customerName) {
		waitForElements(driver,1, USER_FULLNAME_FIELD);
		int generatNo = RandomNumber(999);
		enterdName = customerName + generatNo;
		USER_FULLNAME_FIELD.sendKeys(enterdName);
	}
	
	
	public void insertCompanyName(String companyName) {
		selectDropdownElement(COMPANY_NAME_FIELD, companyName);
	}
	
	public void insertEmailAddr(String email) {
		int generatNo = RandomNumber(999);
		USER_EMAIL_FIELD.sendKeys(generatNo + email);
	}
	
	public void insertPhone(String phone) {
		int generatNo = RandomNumber(999);
		USER_PHONE_FIELD.sendKeys(phone + generatNo);
	}
	
	public void insertAddress(String address) {
		USER_ADDRESS_FIELD.sendKeys(address);
	}
	
	public void insertCityName(String cityName) {
		USER_CITY_FIELD.sendKeys(cityName);
	}
	
	public void insertCountryName(String CountryName) {
		selectDropdownElement(COUNTERY_NAME_FIELD, CountryName);
	}
	
	public void insertStateName(String stateName) {
		USER_STATE_FIELD.sendKeys(stateName);
	}
	
	public void insertZipCode(String zipcode) {
		USER_ZIP_FIELD.sendKeys(zipcode);
	}
	
	public void clickOnSaveButton() {
		SAVE_BUTTON_FIELD.click();
		waitForElements(driver, 5, SUMMARY_BUTTON_FIELD);
	}
	
	
	public void clickOnalertButton() {
		ALERT_OK_BUTTON_FIELD.click();
		//driver.switchTo().alert().accept();
	}
	
	
	
	//tbody/tr[1]/td[3]
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	
	public void verifyEnterElementInDynamicTableAndDelete() {
		
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		
		for(int i=1; i<=10; i++) {
			String nameInTable = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			/*System.out.println(nameInTable);
			Assert.assertEquals(nameInTable, enterdName, "Entered Name Does'nt Exits!");
			break;*/
			
			if(nameInTable.contains(enterdName)) {
				System.out.println("Entered name Exits!!");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
				//clickOnalertButton();
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
