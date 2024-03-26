package org.Mincho.Skillo.automation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationTest {


    @DataProvider(name = "inputs")
    public Object[][] generateNumbers(){
        return new Object[][]{
                {6, 3, 18},
                {4, 2, 2},
                {8, 1, 8},
                {9, 3, 3},
                {3, 1, 3},
                {3, 9, 1},
                {0, 0, 0},
                {1, 6, 20}
        };
    }

    @Test(dataProvider = "inputs", groups = "groupMultip", suiteName = "calculation Suite")
    public void multiplication(int a, int b, int expectedResult){
        int result = a * b;
        Assert.assertEquals(result, expectedResult);
        System.out.println("The result of modulus is: " + result );
    }
}
