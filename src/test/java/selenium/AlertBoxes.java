package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Helper;

public class AlertBoxes {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        WebDriver driver = Helper.setup(url);
        Helper.scroll(1300, driver);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"post-body-4292417847084983089\"]/div/button[1]")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Message : " + alert.getText());
        alert.dismiss();

        WebElement demo = driver.findElement(By.id("demo"));
        System.out.println(demo.getText());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"post-body-4292417847084983089\"]/div/input")).click();
        Thread.sleep(2000);
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Alert Message : " + alert2.getText());
        alert2.accept();


        driver.findElement(By.xpath("//*[@id=\"post-body-4292417847084983089\"]/div/button[2]")).click();
        Thread.sleep(2000);
        Alert alert3 = driver.switchTo().alert();
        System.out.println("Alert Message : " + alert3.getText());
        alert3.sendKeys("Welcome");
        alert3.accept();


        Helper.closeEverything(driver);
    }
}
