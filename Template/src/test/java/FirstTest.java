import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;

/**
 * Created by Patrick.Browne on 4/24/2015.
 */
public class FirstTest {

    public static void main(String[] args){


        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.drupal.org");
        String url = driver.getCurrentUrl();
        System.out.println(url);

        driver.findElement(By.cssSelector("#edit-search-block-form--2")).sendKeys("Forum");

        List<WebElement> button = driver.findElements(By.cssSelector(".link-button>span"));
        for(WebElement text : button){
            System.out.println(text.getText());
        }

        driver.close();
    }
}
