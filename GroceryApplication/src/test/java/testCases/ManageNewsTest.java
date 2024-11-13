package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

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
  public void NewsAddition() throws IOException {
	  lp = new LoginPage(driver);
	  mn= new ManageNews(driver);
	  hp=lp.loginWithValidCredentials(excelRead(1,0),excelRead(1,1));
	  mn.addNews();
	  assertEquals(mn.readInvalidmessage(),"Alert!","Alert message not As Expected");
  }
  
  @Test
  public void SearchItem() throws IOException  {
	  lp = new LoginPage(driver);
	  mn= new ManageNews(driver);
	  hp=lp.loginWithValidCredentials(excelRead(1,0),excelRead(1,1));
	  mn.search();
  }
  @Test
  public void editItem() throws IOException  {
	  lp = new LoginPage(driver);
	  mn= new ManageNews(driver);
	//  hp=lp.loginWithValidCredentials("admin","admin");
	  hp=lp.loginWithValidCredentials(excelRead(1,0),excelRead(1,1));
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