import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class IeTest {
    public static void main(String[] args){
        System.setProperty("webdriver.ie.drivers", "C:\\Selenium\\IEDriverServer.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("requireWindowFocus", true);
        WebDriver driver = new InternetExplorerDriver(capabilities);

        driver.get("http://techportal-test.dish.com/");
        //drivers.get("http://www.bloggersentral.com/2013/06/highlight-open-external-links-new-tabs.html");

        System.out.println("Just opened the url.");


        //String parentHandle = drivers.getWindowHandle(); // get the current window handle
        //System.out.println(parentHandle);
        //drivers.switchTo().window(parentHandle);
        //WebElement newWindowButton = drivers.findElement(By.cssSelector("#subscription-box>form>.sbutton"));
        //Actions newWindow = new Actions((drivers));
        //newWindowButton.click();
        //newWindow.keyDown(Keys.SHIFT).click(yahooLogo).keyUp(Keys.SHIFT).build().perform();

        //System.out.println(drivers.getCurrentUrl());

        for (String winHandle : driver.getWindowHandles()) {
            //winHandle = winHandle + 1;
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        System.out.println(driver.getCurrentUrl());

        WebElement accountNumber = driver.findElement(By.cssSelector("#accountNumber"));
        accountNumber.click();
        accountNumber.sendKeys("8046909801094278");

        WebElement appSelection = driver.findElement(By.cssSelector("#AppCombo"));


        WebElement researchButton = driver.findElement(By.cssSelector("label[tabindex = '1']"));

        researchButton.click();

        driver.quit();

    }
}
