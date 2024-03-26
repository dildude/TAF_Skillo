package org.Mincho.Skillo.automation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractionTest {



    @DataProvider(name = "inputs")
    public Object[][] generateNumbers(){
        return new Object[][]{
                {6, 3, 2},
                {4, 2, 2},
                {8, 1, 7},
                {9, 3, 6},
                {3, 1, 10},
                {3, 9, -6},
                {0, 0, 3},
                {1, 6, -5}
        };
    }

    @Test(dataProvider = "inputs", groups = "groupSubtrsc", suiteName = "calculation Suite")
    public void subtraction(int a, int b, int expectedResult){
        int result = a - b;
        Assert.assertEquals(result, expectedResult);
        System.out.println("The result of modulus is: " + result);
    }
}
