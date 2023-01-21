package adv_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Helper;

import java.io.IOException;
import java.time.Duration;

public class LoginTest {
   private WebDriver driver;
   WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test - Setup");
        String url = "https://suitecrm.theautomationtechies.com/public/index.php#/Login";
        driver = Helper.setup(url);
        Helper.scroll(1000, driver);
    }
    @Test(enabled = false)
    public void test_LoginTest() throws InterruptedException, IOException {
        try {
            login();
        } catch (NoSuchElementException nse) {
            System.out.println("Exception in the Login");
            driver.navigate().refresh();
            Thread.sleep(2000);
            login();
        } catch (Exception e) {
            System.out.println("Exception in the Login : " + e.getMessage());
            Helper.takeScreenshots(driver, "TC2");
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void test_LoginTest_using_implicit_wait() throws InterruptedException, IOException {
        try {
            login();
        } catch (Exception e) {
            Helper.takeScreenshots(driver, "TC2");
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void test_logout() throws IOException {
        try{
            Thread.sleep(4000);
            logout();
        }
        catch (Exception e){
            Helper.takeScreenshots(driver, "TC2");
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(enabled = false)
    public void test_LoginTest_using_explicit_wait() throws InterruptedException {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            login();
        } catch (Exception e) {
            System.out.println("Exception in the Login : " + e.getMessage());
        }
    }


    private void login() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.name("username")).sendKeys("veronica");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.id("login-button")).click();
        String pageSource = driver.getPageSource();
        if(pageSource.contains("My Meetings")){
            System.out.println("Text found");
        }
    }


    private void logout() {
        driver.findElement(By.xpath("//span[contains(.,'Veronica T')]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
    }

    @AfterTest
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
