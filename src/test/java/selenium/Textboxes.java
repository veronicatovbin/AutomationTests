package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Textboxes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Git\\AutomationWithVeronica\\drivers\\chromedriver.exe");
        String url ="https://theautomationtechies.com/web-elements-for-ui-testing/";

        ChromeDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get(url);
       if(driver.findElement(By.id("text1")).isEnabled()){
        driver.findElement(By.id("text1")).sendKeys("veronica");
       }

       driver.findElement(By.id("text2")).sendKeys("tovbin");

       if(driver.findElement(By.name("Hidden")).isEnabled()){
           driver.findElement(By.name("Hidden")).sendKeys("christmas");
       }
        //*[@id="text4"]
        if(driver.findElement(By.xpath("//*[@id=\"text4\"]")).isEnabled()){
            driver.findElement(By.xpath("//*[@id=\"text4\"]")).sendKeys("Merry");
        }
        Thread.sleep(Duration.ofMillis(3000));
       driver.quit();


    }
}
