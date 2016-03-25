package com.techportal.data;

import com.techportal.utilities.MyTestListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

/**
 * Created by Patrick.Browne on 2/4/2016.
 */
public class TPUser_Data {

    @DataProvider(name = "accounts")
    public static Object[][] accounts(){
        return new Object[][]{
                {"8046909801439999", null},
                //{"9999909801437345", "Does Not Exist"},
                //{"asdfasdf", "Invalid Account"}
        };

    }

    @DataProvider(name = "otherDataProvider")
    public static Object[][] stbHealth(){
        return new Object[][]{
                {"###", "R#########", "S#######", "ACTIVE", "N/A"}
        };
    }
}
