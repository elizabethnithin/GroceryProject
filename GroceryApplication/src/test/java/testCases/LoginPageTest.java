package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
//import basicTestNG.BasicAnnotion;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
  @Test
  public void verifyLoginWithCredentials() throws IOException { 
	  lp= new LoginPage(driver);
	  //hp= new HomePage(driver);
	  //hp=lp.loginWithValidCredentials("admin","admin"); 
	  hp=lp.loginWithValidCredentials(excelRead(1,0),excelRead(1,1));
	  String actual=hp.readHeading();
	  String expected="7rmart supermarket";
	  Assert.assertEquals(actual, expected,Constant.lp_verifyLoginWithCredentials); // compares actual and expected results
  }
  
 @Test
  public void verifyLoginWithInValidcredentials() { 
	  lp= new LoginPage(driver);
	  hp= new HomePage(driver);
	  lp.loginWithInvalidCredentials("test","a45in");
	// String actual=lp.readInvalidMessage();
	// String Expected="Alert!";
	// Assert.assertEquals(actual, Expected, ": Alert message  as expected");
	 
	 Assert.assertEquals(lp.readInvalidMessage(),"Alert!","Alert message not as expected"); // compares actual and expected results
  }
}
