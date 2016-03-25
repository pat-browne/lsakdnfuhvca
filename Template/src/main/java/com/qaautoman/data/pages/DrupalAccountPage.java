package com.qaautoman.data.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Patrick.Browne on 4/27/2015.
 */
public class DrupalAccountPage {
    @FindBy(id = "page-title") WebElement accountTitleName;

    public String getAccountName(){
        return accountTitleName.getText();
    }

}
