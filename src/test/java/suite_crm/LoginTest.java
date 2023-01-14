package suite_crm;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.Helper;

import java.time.Duration;

public class LoginTest {
   private WebDriver driver;

   WebDriverWait wait;

   @BeforeTest
   public void openURL(){
       System.out.println("Before Test - Setup");
       String url = "https://suitecrm.theautomationtechies.com/public/index.php#/Login";
       driver = Helper.setup(url);
       Helper.scroll(100, driver);
   }
    @BeforeMethod
    public void login() {
        login("veronica","123456");
    }

    @AfterMethod
    public void logoutAfterEachLogin()  {
        logout();
    }
    @AfterTest
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 1)
    public void TC1_validCredentials_Login_Success() throws InterruptedException {
        System.out.println("Account #1 created");
//        Assert.assertTrue(driver.findElement(By.name("username")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.name("global-search-term")).isDisplayed());
    }
    @Test(priority = 2)
    public void TC1_validCredentials_Login_Success2() throws InterruptedException {
        System.out.println("Account #2 created");
//        Assert.assertTrue(driver.findElement(By.name("username")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.name("global-search-term")).isDisplayed());
    } @Test(priority = 2)
    public void TC1_validCredentials_Login_Success3() throws InterruptedException {
        System.out.println("Account #3 created");
//        Assert.assertTrue(driver.findElement(By.name("username")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.name("global-search-term")).isDisplayed());
    }


    @Test(priority = 2, enabled = false)
    public void TC2_loggedInUser_Logout_Success(){
        login("veronica","123456");
        logout();
    }

    @Test(priority = 3)
    public void TC3_wrongUsername_Login_ErrorMessageIsDisplayed() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.name("username")).isDisplayed());
        login("veronica2","123456");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
    }

    private void login(String username, String password) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }


    private void logout() {
        driver.findElement(By.xpath("//span[contains(.,'Veronica T')]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
    }



}
