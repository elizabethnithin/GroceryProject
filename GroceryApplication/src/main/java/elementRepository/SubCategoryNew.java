package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class SubCategoryNew 
	{
	GeneralUtilities gu = new GeneralUtilities();
		WebDriver driver;
		String subCategoryName; 

		public SubCategoryNew(WebDriver driver) {

			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
	 @FindBy(xpath="//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/Subcategory/add')]")
	 WebElement SubCategoryAddButton;
	 @FindBy(xpath="//select[@class='form-control selectpicker']")
	 WebElement CategoryMenu;
	 @FindBy(xpath="//input[@id='subcategory']")
	 WebElement SubCategoryName;
	 @FindBy(xpath="//button[@type='submit']")
	 WebElement SaveButton; 
	 @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	 WebElement alert;
	 @FindBy(xpath="//a[@href='javascript:void(0)']")
	 WebElement searchButton;
     @FindBy(xpath = "//select[@id='un']")
	 WebElement searchCategory;
	 @FindBy(xpath = "//input[@name='ut']")
	 WebElement searchSubCategoryInput;
	 @FindBy(xpath = "//button[@name='Search']")
	 WebElement searchIcon;
	 @FindBy(xpath="//table//tbody//tr[1]//td[5]//a[2]")
	   WebElement deleteButton;
	   @FindBy(xpath ="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
		List<WebElement> subcategoryColoumn;
	 
	 public void addSubCategory()
	 {
		
		 SubCategoryAddButton.click();
		 gu.selectDropdownWithIndex(CategoryMenu, 1);
		 SubCategoryName.sendKeys("xxx");
		 SaveButton.click();
	 }

	
	 public String getRandmelyCreatedSubCategoryName() {
			return subCategoryName;
		}
	 
	public String readAlert() {
		return alert.getText();
	}
	
	public String readTableElement(int row, int column) {

		String path = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["+ column + "]";
		WebElement element = driver.findElement(By.xpath(path));
		return element.getText();
	}

	 public boolean searchValidTableElement(String subCategoryName,int i)
	   {
		   searchButton.click();
		   gu.selectDropdownWithIndex(CategoryMenu, i); 
		   searchSubCategoryInput.sendKeys(subCategoryName);
		   searchIcon.click();
		   return true;
	   }
	 
	 
	 public boolean searchInValidTableElement(String subCategoryName,int i)
	   {
		   searchButton.click();
		   gu.selectDropdownWithIndex(CategoryMenu, i); 
		   searchSubCategoryInput.sendKeys(subCategoryName);
		   searchIcon.click();
		   return false;
	   }
		   
	
	  public boolean readDeleteElement(String subcategory) {

			List<WebElement> tableColumn = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
			boolean value = true;
			for (int i = 0; i < tableColumn.size(); i++) {
				if (tableColumn.get(i).getText().equals(subcategory)) {

				
					value = false;
				}

			}
			return value;
		}
	   public void deleteTableElement(String subcategory) { 
		   for (int i = 0; i < subcategoryColoumn.size(); i++) {
					if (subcategoryColoumn.get(i).getText().equals(subcategory)) {
						String path ="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//a[2]";
						WebElement element = driver.findElement(By.xpath(path));
						element.click();
						driver.switchTo().alert().accept();
						break;
					}
					}
		  
		  }

}
