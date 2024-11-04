package testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategoryNew;

public class SubCategoryTestNew extends BaseClass {
	SubCategoryNew sb;
	HomePage hp;
	LoginPage lp; 
	
  @Test(priority = 1)
  public void subCategoryAddition() throws IOException
  {
	  sb= new SubCategoryNew(driver);
	  lp= new LoginPage(driver);
	  hp=lp.loginWithValidCredentials(excelRead(1,0),excelRead(1,1));
	  sb=hp.goToSubCategory();
	  sb.addSubCategory();
		String subCategoryName = sb.getRandmelyCreatedSubCategoryName();
		String Expected = "Sub Category Created Successfully";
		String Actual = sb.readAlert();
		boolean value = Actual.contains(Expected);
		Assert.assertEquals(value, true, "Sub category created alert message not as expected");
	//	boolean TableStatus = sb.InsertedElementRead();
	//	assertTrue(TableStatus);
		Assert.assertEquals(sb.readTableElement(1, 1), subCategoryName, "Sub Category Name  As Expected");
	}
  @Test
  public void searchValid() throws IOException
  {
	  sb= new SubCategoryNew(driver);
	  lp= new LoginPage(driver);
	//  lp.loginWithValidCredentials(lp.excelRead(0, 0),lp.excelRead(0, 1));
	//  lp.loginWithValidCredentials("admin", "admin");
	  hp=lp.loginWithValidCredentials(excelRead(1,0),excelRead(1,1));
	  sb=hp.goToSubCategory();
	  sb.searchValidTableElement("xxx",1);
	  }
  @Test
  public void searchInValid() throws IOException
  {
	  lp= new LoginPage(driver);
	//  lp.loginWithValidCredentials(lp.excelRead(0, 0),lp.excelRead(0, 1));
	  hp=lp.loginWithValidCredentials(excelRead(1,0),excelRead(1,1));
	  sb=hp.goToSubCategory();
	  sb.searchInValidTableElement("123",1);
  }
  
  @Test
  public void deleteFunction() throws IOException
  {
	  sb= new SubCategoryNew(driver);
	  lp= new LoginPage(driver);
	
	  hp=lp.loginWithValidCredentials(excelRead(1,0),excelRead(1,1));
	  sb=hp.goToSubCategory();
	  String subCategory=sb.readTableElement(1, 1);
	  sb.deleteTableElement(subCategory);
	  Assert.assertEquals( sb.readAlert(),"Alert!","Sub Category Deleted Successfully");
	  sb.addSubCategory();
		 boolean TableStatus= sb.readDeleteElement(subCategory);
		 Assert.assertEquals( TableStatus,true,"Table status not as expected");
  }

}

  
  
