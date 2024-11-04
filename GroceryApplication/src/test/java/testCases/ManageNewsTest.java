package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContact;
import elementRepository.ManageNews;

public class ManageNewsTest extends BaseClass{
	LoginPage lp;
	ManageNews mn;
	HomePage hp;

  @Test
  public void NewsAddition() {
	  lp = new LoginPage(driver);
	  mn= new ManageNews(driver);
	  hp=lp.loginWithValidCredentials("admin","admin");
	//  String News = mn.getRandmelyCreatedSubCategoryName();
	  mn.addNews();
	  assertEquals(mn.readInvalidmessage(),"Alert!","Alert message not As Expected");
  }
  
  @Test
  public void SearchItem()  {
	  lp = new LoginPage(driver);
	  mn= new ManageNews(driver);
	  hp=lp.loginWithValidCredentials("admin","admin");
	  mn.search();
  }
  @Test
  public void editItem()  {
	  lp = new LoginPage(driver);
	  mn= new ManageNews(driver);
	  hp=lp.loginWithValidCredentials("admin","admin");
	  mn.edit();
  }
  @Test
  public void deleteItem()  {
	  lp = new LoginPage(driver);
	  mn= new ManageNews(driver);
	  hp=lp.loginWithValidCredentials("admin","admin");
	  mn.readDeleteElement();
	  mn.deleteTableElement();
	  
  }
 
}