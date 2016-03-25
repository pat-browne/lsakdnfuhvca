package com.techportal.pages;

import com.techportal.TPUser_BasePage;
import com.techportal.utilities.MyWaits;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Patrick.Browne on 2/1/2016.
 */
public class TPUser_Home extends TPUser_BasePage {

    @FindBy(id = "accountNumber") WebElement field_AccountLogin;
    @FindBy(id = "appCombo") WebElement drop_Application;
    @FindBy(css = "label[tabindex = '1']") WebElement button_OpenAccount;
    @FindBy(id = "header_AccountNumberID") WebElement header_AccountID;
    @FindBy(css = "#appMidDiv>table>tbody>tr:nth-child(3)>td") WebElement error_AccountDoesNotExist;


    public TPUser_Home(WebDriver driver){
        super(driver);
        //Enter URL and PAGE TITLE here
        this.PAGE_URL = "URLENTEREDHERE";
        this.PAGE_TITLE = "PAGETITLEHERE";
    }

    public void setTextAccountLogin(String text) {
        setElementText(field_AccountLogin, text);
    }

    public void clickOpenAccount(String acct, String errorCheck) {
        clickElement(button_OpenAccount);
        wait = (new WebDriverWait(driver, 25));
        //check error messages if errorCheck value passed in
        if(errorCheck != null){
            if(errorCheck == "Invalid Account")
                try{
                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                } catch (NoAlertPresentException e){
                }
            else if(errorCheck == "Does Not Exist"){
                try{
                    wait.until(MyWaits.visibilityOfElement(error_AccountDoesNotExist));
                } catch (NoSuchElementException e) {
                }
            }
        }else{
            wait.until(MyWaits.visibilityOfElement(header_AccountID));
            Assert.assertEquals(driver.findElement(By.cssSelector("#header_AccountNumberID")).getText(), acct);
        }
    }

    public void setDropApplication(String text) {
        selectDropText(drop_Application, text);
    }


}
