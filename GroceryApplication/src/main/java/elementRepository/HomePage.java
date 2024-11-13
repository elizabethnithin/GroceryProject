
package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver; //Current instance of the class
		PageFactory.initElements(driver, this); //with page factory -  initelement (static element of page factory)
		}
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement homePageHeading;
	 @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	 WebElement subCategoryMenu;
	 
	 
	public String readHeading()
	{
		return homePageHeading.getText();
	}
	 public SubCategoryNew goToSubCategory()
	 {
		 subCategoryMenu.click();
		 return new SubCategoryNew(driver);
	 }
	
	 
}
