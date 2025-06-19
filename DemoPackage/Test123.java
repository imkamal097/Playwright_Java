package DemoPackage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test123 {

    @Test
    public void testAddition() {
        int a = 5;
        int b = 10;
        int result = a + b; 
        Assert.assertEquals(result, 15, "Addition result should be 15");
    }
    @AfterTest
    public void testString() {
        String str = "TestNG"; 
        Assert.assertTrue(str.contains("Test"), "String should contain 'Test'");
    }
} 
