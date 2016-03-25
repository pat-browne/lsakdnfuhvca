package com.qaautoman.data.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;


/**
 * Created by Patrick.Browne on 4/27/2015.
 */
public class DrupalLoginPage {

    public static final String PAGE_URL = "https://www.drupal.org/user";
    public static final String PAGE_TITLE = "Welcome to Drupal.org | Drupal.org";

    WebDriver driver;

    @FindBy(className = "messages error") WebElement errorHeader;
    @FindBy(id = "edit-name") WebElement userEmail;
    @FindBy(id = "edit-pass") WebElement userPass;
    @FindBy(id = "edit-submit") WebElement loginButton;

    public void setText_EmailLogin(String text){
        userEmail.sendKeys(text);
    }

    public void setText_PasswordLogin(String text){
        userPass.sendKeys(text);
    }

    public void click_LoginButton(){
        loginButton.click();
    }

    public boolean checkErrorHeader(String text){
        try {
            return errorHeader.getText().equals(text);
        }catch(NoSuchElementException e){
            return false;
        }
    }


}
