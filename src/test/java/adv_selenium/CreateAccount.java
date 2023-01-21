package adv_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Helper;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class CreateAccount {
    private WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test - Setup");
        String url = "https://suitecrm.theautomationtechies.com/public/index.php#/Login";
        driver = Helper.setup(url);

}
@Test(priority=1)
public void CreateAccountTest(){

    driver.findElement(By.xpath("/html/body/app-root/div/scrm-navbar-ui/scrm-base-navbar/div/scrm-action-bar-ui/div/div[2]/div/div/ul/li[1]")).click();
    driver.findElement(By.xpath("//*[@id=\"ngb-nav-6-panel\"]/div/scrm-field-layout/form/div[1]/div[1]/div[2]/div[1]/scrm-field/scrm-dynamic-field/scrm-varchar-edit/input")).sendKeys("Emilia");
driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div/scrm-field-layout/form/div[2]/div[1]/div[2]/div[1]/scrm-field/scrm-dynamic-field/scrm-varchar-edit/input")).sendKeys("https://google.com");


        }
    @AfterTest
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
}}

