package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContact;

public class ManageContactTest extends BaseClass {
	
		LoginPage lp;
		ManageContact mc;
		HomePage hp;

@Test
  public void contactupdate() throws InterruptedException, IOException {
	lp = new LoginPage(driver);
	mc = new ManageContact(driver);
	hp=lp.loginWithValidCredentials(excelRead(1,0),excelRead(1,1));
    mc.contact();
    mc.edit();
    mc.editfields();
    Assert.assertEquals(mc.readInvalidmessage(),"Alert!","Alert message not As Expected");  
  }

@Test
public void resetbutton() throws InterruptedException  {
	lp = new LoginPage(driver);
	mc = new ManageContact(driver);
	hp=lp.loginWithValidCredentials("admin","admin"); //chaining of test cases 
	mc.contact();
	mc.edit();
	mc.ResetContact();
	String expectedurl="https://groceryapp.uniqassosiates.com/admin/list-contact";
	Assert.assertEquals(driver.getCurrentUrl(), expectedurl, "matching URL");   
}
}
