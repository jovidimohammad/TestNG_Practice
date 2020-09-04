package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {

    @Test
    public void test(){
        Assert.assertEquals("apple","apple");

        String[] fruits = {"apple","orange"};
        String[] fruits2 = {"pear","orange"};

       // Assert.assertEquals(fruits,fruits2);
        //hard assertion
        Assert.assertTrue(5>3);
        Assert.assertFalse(10-4<40);
    }

    @Test
    public void softAssertionTest(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("apple","pear");

        String[] fruits = {"apple","orange"};
        String[] fruits2 = {"pear","orange"};

        softAssert.assertEquals(fruits,fruits2);

        softAssert.assertEquals("apple","apple");

        softAssert.assertAll("Edn of the execution");
    }
}
