package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Helper;

public class FileUploader {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        WebDriver driver = Helper.setup(url);
        Helper.scroll(700,driver);
        Thread.sleep(3000);
        driver.findElement(By.name("img")).sendKeys("D:\\Git\\testFile.txt");
        Thread.sleep(3000);
        driver.quit();
    }


}
