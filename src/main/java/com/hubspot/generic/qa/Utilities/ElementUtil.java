package com.hubspot.generic.qa.Utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hubspot.generic.qa.BasePage.BasePage;



public class ElementUtil extends BasePage{


	public static WebDriver driver;
	public WebDriverWait wait;

	public ElementUtil(WebDriver driver) {
		ElementUtil.driver = driver;
		wait = new WebDriverWait(driver,20);
	}

	/**
	 * this is used to create the webelement on the basis of by locator
	 * @param locator
	 * @return webelement
	 */
	public static WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("element could not be created..." + locator);
		}

		return element;
	}
	
	public  void doClick(By locator){
	
			getElement(locator).click();
		
	}
	
	public void doSendKeys(By locator, String value){
		getElement(locator).sendKeys(value);
		
	}
	
	public String doGetText(By locator){
		return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator){
		return getElement(locator).isDisplayed();
	}
	
	//***************************wait utils ******************************
		public String doGetPageTitleWithContains(int timeOut, String title) {
			wait.until(ExpectedConditions.titleContains(title));
			return driver.getTitle();
		}

		public String doGetPageTitleWithIsTitle(int timeOut, String title) {
			wait.until(ExpectedConditions.titleIs(title));
			return driver.getTitle();
		}
		
		public String doGetPageCurrentUrl(int timeOut, String urlValue) {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.urlContains(urlValue));
			return  driver.getCurrentUrl();
		}
		
		public WebElement waitForElementPresent(By locator, int timeOut){
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		
		public WebElement waitForElementToBeClickable(By locator, int timeOut){
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		//////////imported///////
		/*public static void webDriverWaitClickable(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}*/
		public WebElement waitForElementToBeVisible(By locator, int timeOut){
			WebElement element = getElement(locator);
			return wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public List<WebElement> visibilityOfAllElements(By locator, int timeOut){
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		
		public void clickWhenReady(By locator, int timeOut){
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		}
		
		public Alert waitForAlertPresent(int timeOut){
			return wait.until(ExpectedConditions.alertIsPresent());
		}
		public void javascripts(By locator) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", getElement(locator) );
		}
		
		//******************* FluentWait Utils ***********************
		public WebElement waitForElementWithFluentWaitConcept(By locator, int timeOut){
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);
			
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		
		public WebElement waitForElementWithFluentWait(final By locator, int timeOut) {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);

			WebElement element = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(locator);
				}
			});
			
			return element;
		}
		
	
		
}

