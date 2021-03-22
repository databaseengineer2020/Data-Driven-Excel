package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage{
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//h2[contains (text(), ' Dashboard ')]") WebElement DASHBOARD_HEADER_FIELD;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement CUSTOMER_BUTTON_FIELD;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Customer')]") WebElement ADDCUSTOMER_BUTTON_FIELD;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'List Customers')]") WebElement LIST_CUSTOMER_BUTTON;
	
	
	//Interactive Methods
	public void validateDashboardHeader() {
		waitForElements(driver, 3, DASHBOARD_HEADER_FIELD);
		Assert.assertEquals(DASHBOARD_HEADER_FIELD.getText(), "Dashboard", "dashboard Page not Found!!!");
	}
	
	public void clickCustomerButton() {	
		waitForElements(driver, 3, CUSTOMER_BUTTON_FIELD);
		CUSTOMER_BUTTON_FIELD.click();
	}
	

	public void clickAddCustomerButton() {
		waitForElements(driver, 3, ADDCUSTOMER_BUTTON_FIELD);
		ADDCUSTOMER_BUTTON_FIELD.click();
	}
	
	public void clickOnListCustomerButton() {
		waitForElements(driver, 5, LIST_CUSTOMER_BUTTON);
		LIST_CUSTOMER_BUTTON.click();
	}

}
