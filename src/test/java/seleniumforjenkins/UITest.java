package seleniumforjenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UITest {
    @Parameters("Browser")
    @Test
    public void startBrowser(String browserName)
    {
        WebDriver driver = null;
        System.out.println("Parameter value is " + browserName);
        if(browserName.contains("Chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browserName.contains("Edge"))
        {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");
        Assert.assertTrue(driver.getTitle().contains("Orange"),"Title does not match");
    }
}
