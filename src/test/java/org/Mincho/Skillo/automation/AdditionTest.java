package org.Mincho.Skillo.automation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdditionTest {


    @DataProvider(name = "inputs")
    public Object[][] generateNumbers(){
        return new Object[][]{
                {5, 3, 8},
                {5, 2, 7},
                {8, 1, 9},
                {9, 3, 12},
                {3, 1, 10},
                {3, 9, 1},
                {0, 0, 3},
                {1, 6, 20}
        };
    }




    @Test(dataProvider = "inputs", groups = "groupAddition", suiteName = "All Test Suite")
    public void additionValid(int a, int b, int expectedResult){
        int result = a + b;
        Assert.assertEquals(result, expectedResult);
        System.out.println("The result of modulus is: " + result);



    }















}
