package com.qaautoman.data.data;

import org.testng.annotations.DataProvider;

/**
 * Created by Patrick.Browne on 4/24/2015.
 */
public class TechPortalDataExample {

    //Args: URL, TITLE OF PAGE
    @DataProvider(name = "pages")
    public static Object[][] pages(){
        return new Object[][]{
                {"http://www.drupal.org", "Drupal - Open Source CMS | Drupal.org"},
                {"http://www.google.com", "Google"},
                {"http://www.yahoo.com", "Yahoo"}
        };
    }

    @DataProvider(name = "login")
    public static Object[][] login(){
        return new Object[][]{
                {"pmb21656@gmail.com", "Dr50Qh4v3_1", null},
                {"asdfdsaf", "asdfdsaf", "Incorrect Email"}
        };

    }

}
