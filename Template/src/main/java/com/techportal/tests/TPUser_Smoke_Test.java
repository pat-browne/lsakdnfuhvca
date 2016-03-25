package com.techportal.tests;


import com.techportal.data.TPUser_Data;
import com.techportal.pages.TPUser_AccountPage;
import com.techportal.pages.TPUser_Trouble;
import com.techportal.pages.TPUser_Home;
import com.techportal.utilities.MyDriverFactory;
import com.techportal.utilities.MyTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

/**
 * Created by Patrick.Browne on 2/1/2016.
 */
@Listeners(MyTestListener.class)
public class TPUser_Smoke_Test {

    public WebDriver driver;
    MyDriverFactory.BrowserType type = MyDriverFactory.BrowserType.EXPLORER;
    public WebDriverWait wait;
    TPUser_Home TPHome;
    TPUser_AccountPage TPAcctPage;
    TPUser_Trouble TPFlow;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = MyDriverFactory.getDriver(type);
        TPHome = PageFactory.initElements(driver, TPUser_Home.class);
        TPAcctPage = PageFactory.initElements(driver, TPUser_AccountPage.class);
        TPFlow = PageFactory.initElements(driver, TPUser_Trouble.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }


    @Test(groups = {"p1", "pageLoads"})
    public void loadPage(){
        TPHome.loadTechPortal();
    }

    @Test(groups = {"p1", "AccountSubmit"}, dependsOnMethods = "loadPage")
    public void populateAccountFld(){
        TPHome.setTextAccountLogin("8046909801094278");
    }

    @Test(groups = {"p1", "AccountSubmit"}, dependsOnMethods = "populateAccountFld")
    public void selectApp(){
        TPHome.setDropApplication("CSC Tech Portal");
    }

    @Test(groups = {"p1", "AccountSubmit"}, dependsOnMethods="selectApp")
    public void submitAccount(){
        TPHome.clickOpenAccount("8046909801094278", null);
    }

    @Test(groups = {"p2"}, dataProvider = "accounts", dataProviderClass = TPUser_Data.class)
    public void testAccountSubmit(String acct1, String errorCheck){
        TPHome.loadTechPortal();
        TPHome.setTextAccountLogin(acct1);
        TPHome.clickOpenAccount(acct1, errorCheck);
    }

    @Test(groups = {"p3"}, dataProvider = "accounts", dataProviderClass = TPUser_Data.class)
    public void troubleShootFirstReceiver(String acct1, String errorCheck){
        TPHome.loadTechPortal();
        TPHome.setTextAccountLogin(acct1);
        TPHome.setDropApplication("CSC Tech Portal");
        TPHome.clickOpenAccount(acct1, errorCheck);
        //TPAcctPage.selectFirstReceiver();
        TPAcctPage.selectReceiverModel("Virtual Joey");
        //TPAcctPage.selectFrequencyRepeat();
        TPAcctPage.selectFrequencyRepeat();
        //TPAcctPage.selectErrorCode("3_0_2002_3499_1531_EA06_EA06_EA06");
        TPAcctPage.selectSymptomIndicator("Video - Frozen");
        TPAcctPage.selectSymptomFlow("Frozen Video - Live TV");
        //TPAcctPage.selectErrorCodeTroubleshoot();
        TPAcctPage.selectSymptomTroubleshoot();
        TPFlow.selectTrStepBox("1");
        //TPFlow.selectSTBHealth();
        TPFlow.verifySTBHealth("211", "R0011400288", "S1957060016", "ACTIVE", "N/A");
        TPFlow.selectDoneTrShoot();
    }
}
