package utilities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String selectDropdownWithIndex(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public String selectDropdownWithValue(WebElement element, String select) {
		Select object = new Select(element);
		object.selectByValue(select);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public String selectDropdownWithVisibleext(WebElement element, String select) {
		Select object = new Select(element);
		object.selectByVisibleText(select);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	
	public void dismissAlert(WebElement alert, WebDriver driver)
	{
		
		alert.click();
	driver.switchTo().alert().dismiss();
	}
	public void getElementAttributes(WebElement element)
	{
		String backgroundColor=element.getCssValue("background-color");
		System.out.println(backgroundColor);
		
		String attributeType=element.getAttribute("class");
		String attributeTagName =element.getTagName();
		System.out.println(attributeType);
		System.out.println(attributeTagName);
		String loginText=element.getText();
		System.out.println(loginText);
}
	public void dragAndDrop(WebElement sourceElement,WebElement targetElement,WebDriver driver)
	{
	Actions actionObj=new Actions(driver);
	actionObj.dragAndDrop(sourceElement, targetElement).perform();
	
	
	}
	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}


public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	
//public void clickJavaScriptExecutor(WebDriver driver,int Horizondal, int Vertical ) {
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("arguments[0].click()", element);
//}

public  void scrollFunction(WebDriver driver,WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", element);
}
}

