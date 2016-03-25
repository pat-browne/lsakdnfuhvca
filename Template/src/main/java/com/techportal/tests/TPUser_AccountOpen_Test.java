package com.techportal.tests;

import com.techportal.data.TPUser_Data;
import com.techportal.pages.TPUser_AccountPage;
import com.techportal.pages.TPUser_Home;
import com.techportal.utilities.MyDriverFactory;
import com.techportal.utilities.MyTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Patrick.Browne on 2/4/2016.
 */
@Listeners(MyTestListener.class)
public class TPUser_AccountOpen_Test {

    MyDriverFactory.BrowserType type = MyDriverFactory.BrowserType.EXPLORER;
    public WebDriver driver;
    TPUser_Home TPHome;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = MyDriverFactory.getDriver(type);
        TPHome = PageFactory.initElements(driver, TPUser_Home.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.quit();
    }

    @Test(groups = {"a1"}, dataProvider = "accounts", dataProviderClass = TPUser_Data.class)
    public void accountLoginTest(String acct, String errorCheck){
        TPHome.loadTechPortal();
        TPHome.setTextAccountLogin(acct);
        TPHome.setDropApplication("CSC Tech Portal");
        TPHome.clickOpenAccount(acct, errorCheck);
    }

}
