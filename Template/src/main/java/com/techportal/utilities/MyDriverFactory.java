package com.techportal.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by Patrick.Browne on 2/4/2016.
 */
public class MyDriverFactory {

    public enum BrowserType{
        FIREFOX("firefox"),
        CHROME("chrome"),
        EXPLORER("explorer"),
        SAFARI("safari");

        private String value;

        BrowserType(String value){
            this.value = value;
        }

        public String getBrowserName(){
            return this.value;
        }
    }



    public static WebDriver getDriver(BrowserType type){
        WebDriver driver = null;
        switch(type){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case EXPLORER:
                System.setProperty("webdriver.ie.driver", "src\\main\\resources\\drivers\\IEDriverServer.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability("requireWindowFocus", true);
                driver = new InternetExplorerDriver(capabilities);
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                assert false : "Please specify BrowserType.";
                break;
        }
        return driver;
    }
}
