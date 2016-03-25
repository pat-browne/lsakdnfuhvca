package com.techportal.pages;

import com.techportal.TPUser_BasePage;
import com.techportal.utilities.MyWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Created by Patrick.Browne on 2/2/2016.
 */
public class TPUser_AccountPage extends TPUser_BasePage {

    @FindBy(id = "deviceCategoryHeaderDiv_Receivers") WebElement receiverHeader;
    @FindBy(id = "deviceCategoryDataCheckBoxTd_0") WebElement firstReceiver;
    @FindBy(id = "frIssueRdoBtn_1") WebElement interOnce;
    @FindBy(id = "frIssueRdoBtn_2") WebElement interRepeat;
    @FindBy(id = "_TrubleShootBtn_4715") WebElement sympTroubleShoot;
    @FindBy(id = "errorCodeTbutton") WebElement errTroubleShoot;
    @FindBy(id = "errorCodeCombo") WebElement errorCode;
    @FindBy(id = "expandOrCollapsAllStepsTable") WebElement tableTrShootSteps;


    public TPUser_AccountPage(WebDriver driver){
        super(driver);
    }

    public void selectFirstReceiver(){
        wait.until(MyWaits.visibilityOfElement(receiverHeader));
        clickElement(receiverHeader);
        clickElement(firstReceiver);
    }

    public void selectReceiverModel(String text){
        wait.until(MyWaits.visibilityOfElement(receiverHeader));
        clickElement(receiverHeader);
        WebElement receiverModel = driver.findElement(By.xpath(".//td[text()='"+text+"']/preceding-sibling::td"));
        clickElement(receiverModel);
        System.out.println(receiverModel + " - selected as receiver model.");
    }

    public void selectFrequencyOnce(){
        interOnce.click();
    }

    public void selectFrequencyRepeat(){
        interRepeat.click();
    }

    public void selectErrorCode(String text){
        selectDropText(errorCode, text);
    }

    public void selectSymptomIndicator(String text){
        WebElement indicator = driver.findElement(By.xpath(".//b[text() = '"+text+"']/parent::div/parent::div"));
        clickElement(indicator);
    }

    public void selectSymptomFlow(String text){
        WebElement flow = driver.findElement(By.xpath(".//td[text() = '"+text+"']"));
        wait.until(MyWaits.visibilityOfElement(flow));
        clickElement(flow);
    }

    public void selectErrorCodeTroubleshoot(){
        clickElement(errTroubleShoot);
    }

    public void selectSymptomTroubleshoot(){
        clickElement(sympTroubleShoot);
        wait.until(MyWaits.visibilityOfElement(tableTrShootSteps));
        Assert.assertTrue(tableTrShootSteps.isDisplayed(), "Trouble Shoot Page not loaded");
    }
}
