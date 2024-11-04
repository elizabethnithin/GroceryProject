package elementRepository;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver; //Current instance of the class
		PageFactory.initElements(driver, this); //with page factory -  initelementt (static element of page factory)
		}
	
	
	 //Without page factory 
     //By UserNameField=By.name("UserName"); 
	 //WebElement element =driver.findElement("UserNameField").click 
	
	@FindBy(name="username")
	WebElement userNameField ;
	@FindBy(name="password")
	WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement loginButton;
	@FindBy(xpath="//h5[text()=' Alert!']")
	WebElement invalidText;
	
	public HomePage loginWithValidCredentials(String userName,String passWord)
	{
		userNameField.sendKeys(userName);
	//	gu.sendKeysFunction
		passwordField.sendKeys(passWord);
		loginButton.click();
		return new HomePage(driver);//chaining of test cases
	}
	
	
	public String readInvalidMessage()
	{
		return invalidText.getText();
	}
	
	
	public void loginWithInvalidCredentials(String userName,String passWord)
	{
		userNameField.sendKeys("usrename");
		passwordField.sendKeys("123");
		loginButton.click();
	}
}
