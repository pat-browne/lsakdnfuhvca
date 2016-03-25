package com.techportal;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Patrick.Browne on 2/4/2016.
 */
public class TPUser_BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public String PAGE_URL;
    public String PAGE_TITLE;

    public TPUser_BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void loadTechPortal(){
        loadPage();
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.manage().window().maximize();
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#accountNumber")));
        Assert.assertEquals(driver.getTitle(),PAGE_TITLE);
    }

    public void loadPage(){
        driver.get(getPageUrl());
    }

    public String getPageUrl(){
        return PAGE_URL;
    }

    public String getPageTitle(){
        return PAGE_TITLE;
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void setElementText(WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void selectDropValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectDropText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public boolean verifyElementPresent(WebElement element){
        try{
            element.getTagName();
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public void getElementText(WebElement element){
        element.getText();
    }

}
