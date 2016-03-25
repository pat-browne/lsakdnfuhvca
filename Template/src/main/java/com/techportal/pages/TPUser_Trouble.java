package com.techportal.pages;

import com.techportal.TPUser_BasePage;
import com.techportal.utilities.MyWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by Patrick.Browne on 2/4/2016.
 */
public class TPUser_Trouble extends TPUser_BasePage {

    //@FindBy(css = "#expandOrCollapsAllStepsTable>tbody>tr:nth-of-type(2)") WebElement firstCheckBox;
    //>td:nth-of-type(4)>input[name='troubleShootStepCheckBox']
    //"#appMidDiv>table>tbody>tr:nth-child(3)>td"
    @FindBy(id = "doneTroubleshoot") WebElement btnDoneTrShoot;
    @FindBy(id = "dropdown") WebElement dropEndSession;
    @FindBy(id = "tabSTB_Health_Span2") WebElement dropSTBHealth;

    public TPUser_Trouble(WebDriver driver){
        super(driver);
    }

    public void selectTrStepBox(String text) {
        WebElement trStepBox = driver.findElement(By.xpath(".//tr[contains(@id, 'trStep_"+text+"')]/td[4]/input[@name='troubleShootStepCheckBox']"));
        //WebElement stepDesc = driver.findElement(By.xpath(".//tr[contains(@id, 'trStep" + text + "')]/td[2]"));
        //WebElement notesCheck =  driver.findElement(By.cssSelector("#finalNote"));
        wait.until(ExpectedConditions.elementToBeClickable(trStepBox));
        clickElement(trStepBox);
    }

    public void selectDoneTrShoot(){
        clickElement(btnDoneTrShoot);
    }

    public void selectEndSession(String text){
        selectDropText(dropEndSession, text);
    }

    public void selectSTBHealth(){
        clickElement(dropSTBHealth);
        WebElement stbHeader= driver.findElement(By.cssSelector("#stbPopUp table>tbody>tr:first-child>th:first-child"));
        Assert.assertEquals(stbHeader.getText(), "Model");
    }

    public void verifySTBHealth(String model, String receiver, String smartCard, String status, String stbHealth){
        selectSTBHealth();
        WebElement tableModel = driver.findElement(By.xpath(".//div[@id='stbPopUp']/table/tbody/tr[2]/td[1]"));
        WebElement tableReceiver = driver.findElement(By.xpath(".//div[@id='stbPopUp']/table/tbody/tr[2]/td[2]"));
        WebElement tableSmartCard = driver.findElement(By.xpath(".//div[@id='stbPopUp']/table/tbody/tr[2]/td[3]"));
        WebElement tableStatus = driver.findElement(By.xpath(".//div[@id='stbPopUp']/table/tbody/tr[2]/td[4]"));
        WebElement tableSTBHealth = driver.findElement(By.xpath(".//div[@id='stbPopUp']/table/tbody/tr[2]/td[5]"));
        //WebElement tableModel= driver.findElement(By.cssSelector("#stbPopUp table>tbody>tr:nth-of-type(2)>td:first-child"));
        //WebElement tableReceiver= driver.findElement(By.cssSelector("#stbPopUp table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)"));
        Assert.assertEquals(tableModel.getText(), model);
        Assert.assertEquals(tableReceiver.getText(), receiver);
        Assert.assertEquals(tableSmartCard.getText(), smartCard);
        Assert.assertEquals(tableStatus.getText(), status);
        Assert.assertEquals(tableSTBHealth.getText(), stbHealth);
    }
}
