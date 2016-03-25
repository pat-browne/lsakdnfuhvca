package com.drupal.tests;

import com.qaautoman.data.data.TechPortalData2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Patrick.Browne on 4/27/2015.
 */
public class Search_Test2 {

    private WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setup(){
        driver = new FirefoxDriver();
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.quit();
    }

    @Test(groups = "p1", dataProvider = "pages2", dataProviderClass = TechPortalData2.class)
    public void pageLoad(String url, String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Test(groups="p2", dependsOnMethods = "pageLoad")
    public void search(){
        driver.findElement(By.cssSelector("#edit-search-block-form--2")).sendKeys("FORUM");
        driver.findElement(By.cssSelector("#edit-submit")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.drupal.org/search/site/FORUM");
    }

}
