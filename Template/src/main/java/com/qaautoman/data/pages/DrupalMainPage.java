package com.qaautoman.data.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by Patrick.Browne on 4/27/2015.
 */
public class DrupalMainPage {

    public static final String PAGE_TITLE = "Drupal - Open Source CMS | Drupal.org";
    public static final String PAGE_URL = "https://www.drupal.org";
    public static final String SEARCH_URL = "https://www.drupal.org/search/site/";

    //String field_Search_Text2 = "FORUM1";
    @FindBy(css = "#edit-search-block-form--2") WebElement field_Search_Text1;
    @FindBy(id = "edit-submit") public WebElement button_Search;

    WebDriver driver;

    public DrupalMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void setText_Search1(String text){
        field_Search_Text1.sendKeys(text);
        Assert.assertEquals(field_Search_Text1.getAttribute("value"), text);
    }
/*
    public void setText_Search2(String text){
        WebElement element = drivers.findElement(By.cssSelector("#edit-query"));
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }
*/
    public void submit_Search1(){
        button_Search.click();
    }
}
