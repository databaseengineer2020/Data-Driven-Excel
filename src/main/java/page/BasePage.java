package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void waitForElements(WebDriver driver, int timeInSecond, WebElement elementLocators) {
		WebDriverWait wait = new WebDriverWait(driver , timeInSecond);
		wait.until(ExpectedConditions.visibilityOf(elementLocators));	
	}
	
	public void selectDropdownElement(WebElement elementField, String visibleText) {
		Select selct = new Select(elementField);
		selct.selectByVisibleText(visibleText);
	}
	
	public int RandomNumber(int boundaryNumbers) {
		Random rnd = new Random();
		int randomNo = rnd.nextInt(boundaryNumbers);
		return randomNo;
	}
}
