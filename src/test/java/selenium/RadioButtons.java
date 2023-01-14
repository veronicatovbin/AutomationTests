package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Helper;

public class RadioButtons {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        WebDriver driver = Helper.setup(url);
        Helper.scroll(700, driver);
        Thread.sleep(3000);

        driver.findElement(By.id("radio1")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("radio2")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("radio3")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("radio4")).click();
        Thread.sleep(3000);
        driver.quit();

    }
}
