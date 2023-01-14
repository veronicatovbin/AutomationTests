package adv_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Helper;

import java.util.Set;

public class Netbanking {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test - Setup");
        String url = "https://netbanking.hdfcbank.com/netbanking/";
        //url="https://netportal.hdfcbank.com/login#/openMarketLoginCC";
        driver = Helper.setup(url);
        Helper.scroll(1000, driver);
    }

    @AfterTest
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void EnterCustomerID(){
        //12345
        //press continue
        driver.switchTo().frame("login_page");
        driver.findElement(By.name("fldLoginUserId")).sendKeys("12345");

        driver.findElement(By.xpath("//a[contains(.,'Credit Card only? Login here')]")).click();

//        Set<String> windowHandles = driver.getWindowHandles();
//        System.out.println(driver.getCurrentUrl());
//        driver.findElement(By.id("openMarketUID")).sendKeys("12345");

    }

}
