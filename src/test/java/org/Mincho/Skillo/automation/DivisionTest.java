package org.Mincho.Skillo.automation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivisionTest {


    @DataProvider(name = "inputs")
    public Object[][] generateNumbers(){
        return new Object[][]{
                {6, 3, 2},
                {4, 2, 2},
                {8, 1, 8},
                {9, 3, 3},
                {3, 1, 10},
                {3, 9, 1},
                {0, 0, 3},
                {1, 6, 20}
        };
    }

    @Test(dataProvider = "inputs", groups = "groupDivis", suiteName = "calculation Suite")
    public void division(int a , int b, int expectedResult){
        int result = a / b;
        Assert.assertEquals(result, expectedResult);
        System.out.println("The expected result is: " + expectedResult + " And the actual result is: " + result );
    }
}
