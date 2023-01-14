package suite_crm;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.Helper;

import java.io.File;
import java.io.IOException;
import java.text.FieldPosition;
import java.time.Duration;

public class LoginTestV2 {
   private WebDriver driver;
   WebDriverWait wait;

   @BeforeTest
   public void openURL(){
       System.out.println("Before Test - Setup");
       String url = "https://suitecrm.theautomationtechies.com/public/index.php#/Login";
       driver = Helper.setup(url);
       Helper.scroll(100, driver);
   }

    @AfterTest
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 1)
    public void TC1_validCredentials_Login_Success() throws InterruptedException, IOException {
        try{
            Assert.assertTrue(driver.findElement(By.name("username")).isDisplayed());
            login("veronica","123456");
            Assert.assertTrue(driver.findElement(By.name("global-search-term")).isDisplayed());
        }
        catch (Exception e){
            Helper.takeScreenshots(driver, "TC1");
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(priority = 2)
    public void TC2_loggedInUser_Logout_Success() throws IOException {
        try{
            logout();
        }
        catch (Exception e){
            Helper.takeScreenshots(driver, "TC2");
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(priority = 3)
    public void TC3_wrongUsername_Login_ErrorMessageIsDisplayed() throws InterruptedException, IOException {
     try{
         Assert.assertTrue(driver.findElement(By.name("username")).isDisplayed());
         login("veronica2","123456");
         Assert.assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
        }
        catch (Exception e){
            Helper.takeScreenshots(driver, "TC3");
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void login(String username, String password) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }


    public void logout() {
        driver.findElement(By.xpath("//span[contains(.,'Veronica T')]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
    }



}
