package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\Git\\AutomationWithVeronica\\drivers\\chromedriver.exe");
        String url ="https://theautomationtechies.com/web-elements-for-ui-testing/";

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        if(driver.findElement(By.id("text1")).isEnabled()){
            driver.findElement(By.id("text1")).sendKeys("Veronica");
        }
        else{
            System.out.println("Text one is disabled");

        }
        if(driver.findElement(By.id("text2")).isEnabled()){
            driver.findElement(By.id("text2")).sendKeys("Veronica");
        }
        else{
            System.out.println("Text two is disabled");

        }




        driver.quit();
    }
}
