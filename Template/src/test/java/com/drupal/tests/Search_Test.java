package com.drupal.tests;



import com.qaautoman.data.data.TechPortalDataExample;
import com.qaautoman.data.pages.DrupalAccountPage;
import com.qaautoman.data.pages.DrupalLoginPage;
import com.qaautoman.data.pages.DrupalMainPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class Search_Test {

    public WebDriver driver;
    DrupalMainPage DMainPage;
    DrupalLoginPage DLoginPage;
    DrupalAccountPage DAccountPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        driver = new FirefoxDriver();
        DMainPage = PageFactory.initElements(driver, DrupalMainPage.class);
        DLoginPage = PageFactory.initElements(driver, DrupalLoginPage.class);
        DAccountPage = PageFactory.initElements(driver, DrupalAccountPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.quit();
    }


    @Test(groups={"p1", "pageLoads"})
    public void loadPage(){
        driver.get(DMainPage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), DMainPage.PAGE_TITLE);
    }
/*
    @Test(groups={"p2", "search"}, dependsOnMethods="loadPage")
    public void fillOutSearch(){
        DMainPage.setText_Search1("FORUM");
    }

    @Test(groups={"p2", "search"}, dependsOnMethods="fillOutSearch")
    public void submitSearch(){
        DMainPage.submit_Search1();
        Assert.assertEquals(drivers.getCurrentUrl(), "https://www.drupal.org/search/site/FORUM");
    }

    @Test(groups = "p2")
    public void searchMainPage(){
        drivers.get(DMainPage.PAGE_URL);
        Assert.assertEquals(drivers.getTitle(), DMainPage.PAGE_TITLE);
        DMainPage.setText_Search1("FORUM");
        DMainPage.submit_Search1();
        Assert.assertEquals(drivers.getCurrentUrl(), DMainPage.SEARCH_URL + "FORUM");
    }
*/

    @Test(groups="p3", dataProviderClass = TechPortalDataExample.class, dataProvider = "login")
    public void loginTest(String email, String password, String errorType){
        driver.manage().deleteAllCookies();
        driver.get(DLoginPage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), DLoginPage.PAGE_TITLE);
        DLoginPage.setText_EmailLogin(email);
        DLoginPage.setText_PasswordLogin(password);
        DLoginPage.click_LoginButton();
        //verify what to test based on data passed to it
        if(StringUtils.isBlank(errorType)){
            boolean result = DLoginPage.checkErrorHeader(errorType);
            Assert.assertTrue(result, "Expected Error :" + errorType);
        }else{
            Assert.assertTrue(!DAccountPage.getAccountName().isEmpty());
        }

    }
}
