package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Helper;

public class Checkboxes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Git\\AutomationWithVeronica\\drivers\\chromedriver.exe");
        String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Helper.scroll(500, driver);
        if(driver.findElement(By.id("check1")).isSelected()==false){
            driver.findElement(By.id("check1")).click();
        }
        if(driver.findElement(By.id("check2")).isSelected()==false){
            driver.findElement(By.id("check2")).click();
        }
        if(driver.findElement(By.id("check3")).isSelected()==false){
            driver.findElement(By.id("check3")).click();
        }
        if(driver.findElement(By.id("check4")).isSelected()==false){
            driver.findElement(By.id("check4")).click();
        }
        if(driver.findElement(By.id("check5")).isSelected()==false){
            driver.findElement(By.id("check5")).click();
        }


        Thread.sleep(3000);
        driver.quit();
    }


}
