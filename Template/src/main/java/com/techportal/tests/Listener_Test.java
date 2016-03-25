package com.techportal.tests;

import com.techportal.utilities.MyTestListener;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Patrick.Browne on 2/5/2016.
 */
@Listeners(MyTestListener.class)
public class Listener_Test {

    @Test
    public void test1Pass(){
        Assert.assertTrue(true);
    }

    @Test
    public void test2Fail(){
        Assert.assertTrue(false, "I am asserting false from test failure.");

    }

    @Test(dependsOnMethods = "test2Fail")
    public void test3skip(){
        Assert.assertTrue(true);
    }

    @Test
    public void test4skip(){
        throw new SkipException("I am skipping because you said so.");
    }

}
