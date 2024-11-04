package elementRepository;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageNews {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;
	//String News;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement manageNews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement SeacrhButton;
	@FindBy(xpath="//input[@name='un']")
	WebElement searchText;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement InsideSearch;
	@FindBy(xpath="btn btn-rounded btn-warning")
	WebElement Reset;
	@FindBy(xpath="//textarea[@id='news']")
	WebElement NewsField;
	@FindBy(xpath="//button[@type='submit']")
	WebElement Save;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement invalidMessage;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	List<WebElement> searchcol;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[2]/a[1]")
	WebElement edit;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[2]/a[2]")
	WebElement delete;
	@FindBy(xpath="//textarea[@id='news']")
	WebElement editArea;
	@FindBy(xpath="//button[@type='submit']")
	WebElement update;
	
	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void addNews()
	{
		manageNews.click();
		NewButton.click();
		NewsField.clear();
		NewsField.sendKeys("elz");
		Save.click();
	}
	
	
	public void search() 
	{
		manageNews.click();
		SeacrhButton.click();
		searchText.sendKeys("elz");
		InsideSearch.click();
		for (int i=0;i<searchcol.size();i++)
		  {
			  if(searchcol.get(i).getText().equals("elz"))
			  {
				  System.out.println("match is found");
			  }
			  else
			  {
				  System.out.println("match is not found");  
			  }
					  
		  }
	}
	public void edit() 
	{
		manageNews.click();
		edit.click();
		editArea.clear();
		editArea.sendKeys("Edited data");
		update.click();
	}
	
	public void delete() 
	{
		manageNews.click();
		delete.click();
		driver.switchTo().alert().accept();	
	}
	
	 public boolean readDeleteElement() {

			//List<WebElement> tableColumn = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
			boolean value = true;
			for (int i = 0; i < searchcol.size(); i++) {
				if (searchcol.get(i).getText().equals("elz")) {

				
					value = false;
				}

			}
			return value;
	 }
	  public void deleteTableElement() { 
		   for (int i = 0; i < searchcol.size(); i++) {
					if (searchcol.get(i).getText().equals("elz")) {
						//String path ="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[2]/a[2]";
						//WebElement element = driver.findElement(By.xpath(path));
						delete.click();
						driver.switchTo().alert().accept();
						break;
					}
					}
		  
		  }

	public String readInvalidmessage() {
		return invalidMessage.getText();
	}	
	
	
}
