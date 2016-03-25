package com.techportal.utilities;

import org.apache.xpath.operations.Bool;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.NoSuchElementException;

/**
 * Created by Patrick.Browne on 2/5/2016.
 */
public class MyWaits {

    public static ExpectedCondition<Boolean> visibilityOfElement(final WebElement element){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    return element.isDisplayed();
                } catch (NoSuchElementException e) {
                    System.out.println("Element Is Not Present: " + element);
                    return false;
                } catch (StaleElementReferenceException el) {
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> wait(final boolean condition){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return condition;
            }
        };
    }
}
