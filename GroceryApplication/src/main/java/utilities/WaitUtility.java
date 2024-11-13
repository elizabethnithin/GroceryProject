package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public void WaitForWebElementAlert(WebDriver driver) { //Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}
public void waitForWebElement(WebDriver driver, WebElement element, String attribute, String attributeValue) {
		 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver) 
		            .withTimeout(Duration.ofSeconds(30))
		            .pollingEvery(Duration.ofSeconds(2))
		            .ignoring(NoSuchElementException.class);		 
		 fluentWait.until(ExpectedConditions.attributeToBe(element, attribute, attributeValue));
	}
public void threadWait(WebDriver driver, int timeinSeconds) throws InterruptedException {
	Thread.sleep(timeinSeconds);
}


public void waitForSeconds(WebDriver driver, int seconds) throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds)); //implicit wait
}

public void waitForMilliSeconds(WebDriver driver, int milliseconds) throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(milliseconds)); //implicit wait
}

public void waitForWebElementtobeVisible(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element)); //explicit wait
}

 
}
