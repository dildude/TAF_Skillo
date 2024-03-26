package org.Mincho.Skillo.automation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ModulusTest {

    @DataProvider(name = "inputs")
    public Object[][] generateNumbers(){
        return new Object[][]{
                {6, 3, 0},
                {4, 2, 0},
                {8, 1, 0},
                {9, 2, 3},
                {3, 1, 10},
                {3, 9, 1},
                {0, 0, 3},
                {1, 6, 20}
        };
    }

    @Test(dataProvider = "inputs", groups = "groupModulus", suiteName = "calculation Suite")
    public void modulus(int a, int b, int expectedResult){
        int result = a % b;
        Assert.assertEquals(result, expectedResult);
        System.out.println("The result of modulus is: " + result);
    }


}
