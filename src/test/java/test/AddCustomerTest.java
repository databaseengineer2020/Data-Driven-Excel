package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TS_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	
	String customerName = exlread.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String emailAdd = exlread.getCellData("AddContactInfo", "Email", 2);
	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	String state = exlread.getCellData("AddContactInfo", "State", 2);
	String zip = exlread.getCellData("AddContactInfo", "Zip", 2);
	
	@Test
	public void validUserShouldAbleToCreateCustomerProfile() {
		driver = BrowserFactory.init();
		
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(userName);
		loginpage.insertPassword(password);
		loginpage.clickOnSighinButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardHeader();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addcustomerPage = PageFactory.initElements(driver,AddCustomerPage.class);
		addcustomerPage.validateCustomerHeader();
		addcustomerPage.insertCustomerName(customerName);
		addcustomerPage.insertCompanyName(companyName);
		addcustomerPage.insertEmailAddr(emailAdd);
		addcustomerPage.insertPhone(phone);
		addcustomerPage.insertAddress(address);
		addcustomerPage.insertCityName(city);
		addcustomerPage.insertCountryName(country);
		addcustomerPage.insertStateName(state);
		addcustomerPage.insertZipCode(zip);
		addcustomerPage.clickOnSaveButton();
		
		
		dashboardPage.clickOnListCustomerButton();
		
		addcustomerPage.verifyEnterElementInDynamicTableAndDelete();
		addcustomerPage.clickOnalertButton();
		
	}

}
