package com.qaautoman.data.data;

import org.testng.annotations.DataProvider;

/**
 * Created by Patrick.Browne on 4/27/2015.
 */
public class TechPortalData2 {

    @DataProvider(name = "pages2")
    public static Object[][] pages2(){
        return new Object[][]{
                {"https://www.drupal.org", "Drupal - Open Source CMS | Drupal.org"},
                {"https://www.google.com", "Google"},
                {"https://www.yahoo.com", "Yahoo"},
                {"https://www.drupal.org", "Drupal - Open Source CMS | Drupal.org"}
        };

    }

}
