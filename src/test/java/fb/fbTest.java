package fb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Helper;

import java.io.IOException;

public class fbTest {
    private WebDriver driver;

    @BeforeTest
    public void openURL(){
        System.out.println("Before Test - Setup");
        String url = "https://www.facebook.com/";
        driver = Helper.setup(url);
        Helper.scroll(100, driver);
    }

    @AfterTest
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void TC1() throws IOException {
       try{
           driver.findElement(By.id("email")).sendKeys("veronica.tovbin@gmail.com");
           driver.findElement(By.id("pass")).sendKeys("12345");
           driver.findElement(By.name("login")).click();
       }
       catch (Exception e){
           System.out.println("-------- Catch block");
           Helper.takeScreenshots(driver, "TC1_fb_test");
           e.printStackTrace();
           Assert.fail();
       }

    }


}
