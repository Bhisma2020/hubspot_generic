package com.hubspot.generic.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.generic.qa.BasePage.BasePage;
import com.hubspot.generic.qa.Utilities.Constants;
import com.hubspot.generic.qa.Utilities.ElementUtil;

public class ContactPage extends BasePage{

	WebDriver driver;
	ElementUtil eleutil;
	
	
	By createcontact = By.xpath("//span[contains(text(),'Create contact')]");
	By email = By.xpath("//*[@data-field='email']");
	By firstname =By.xpath("//*[@data-field='firstname']");
	By lastname = By.xpath("//*[@data-field='lastname']");
	By jobtitle = By.xpath("//*[@data-field='jobtitle']");
	By createtab= By.xpath("//span[@class='private-loading-button__content private-button--internal-spacing'][contains(text(),'Create contact')]");
	By back =By.xpath("//div[@class='UIAbstractColumn__ColumnWrapper-vkv1rx-0 ggAAfp UIColumn-content']//i18n-string[contains(text(),'Contacts')]");
	By checkbox =By.xpath("//div[@class='private-checkbox private-checkbox--flush private-checkbox--unlabeled private-checkbox--align-center']//span[@class='private-checkbox__icon private-checkbox__dash']//*[local-name()='svg']");
	By delete = By.xpath("//*[text()='Delete']");
	By confirmation = By.xpath("//div//textarea[@style='height: 74px;']");
	By deletetab =By.xpath("//footer//div//button[@type='button']//*[text()='Delete']");
	By frame= By.xpath("//iframe[@style='display: none;']");
	
	public ContactPage( WebDriver driver) {

	this.driver= driver;	
	eleutil = new ElementUtil(this.driver);
	
	}

public void filltheformforContact(String mail,String fname,String lname,String title) {
		
	eleutil.waitForElementToBeVisible(createcontact, 10);	
	eleutil.doClick(createcontact);
	eleutil.waitForElementToBeVisible(email,10);
	eleutil.doSendKeys(this.email, mail);
	eleutil.waitForElementToBeVisible(firstname,10);
	eleutil.doSendKeys(this.firstname, fname);
	eleutil.waitForElementToBeVisible(lastname,10);
	eleutil.doSendKeys(this.lastname, lname);
	eleutil.waitForElementToBeVisible(jobtitle,10);
	eleutil.doSendKeys(this.jobtitle, title);
	eleutil.waitForElementToBeVisible(createtab,10);
	eleutil.doClick(this.createtab);
	
	}

	public String dogetTitle() {
		
		return eleutil.doGetPageTitleWithContains(10, Constants.CONTACTS_PAGE_TITLE);
		
		
	}
	

	public void deletecontact() throws InterruptedException {
		
		eleutil.doClick(checkbox);
		eleutil.doClick(delete);
		eleutil.clickWhenReady(confirmation, 15);
		eleutil.doSendKeys(confirmation, "5");
		//eleutil.waitForElementPresent(frame, 15);
		//driver.switchTo().frame(ElementUtil.getElement(frame));
		
		eleutil.javascripts(deletetab);
		eleutil.doClick(deletetab);
		
	}


	}

	