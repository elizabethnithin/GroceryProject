package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageContact {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;
	
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement manageContactButton;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	@FindBy(xpath="//textarea[@name='address']")
	WebElement address;
	@FindBy(xpath="//textarea[@name='del_time']")
	WebElement deliveryTime;
	@FindBy(xpath="//input[@id='del_limit']")
	WebElement deliveryLimt;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	WebElement update;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement invalidMessage;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement reset;
	
	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void contact()
	{
		manageContactButton.click();
	}
	
	public void edit()
	{
		editButton.click();
	}
	public void editfields() throws InterruptedException
	{
		
		phone.clear();
		phone.sendKeys("085473737");
	
		email.clear();
		email.sendKeys("test234@gmail.com");
	
		address.clear();
		address.sendKeys("test address");
		
		
		deliveryTime.clear();
		deliveryTime.sendKeys("30 minutes");
	
		deliveryLimt.clear();
		deliveryLimt.sendKeys("30");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000);");
		Thread.sleep(200);
		update.click();
	}
	
	public void ResetContact() throws InterruptedException
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 2000);");
		Thread.sleep(2000);
		reset.click();
	}
	
	public String readInvalidmessage() {
		return invalidMessage.getText();
	}		
}
