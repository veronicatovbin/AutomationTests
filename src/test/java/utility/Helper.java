package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Helper {
    public static void scroll(int num, WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollBy(0,"+num + ")","");
    }
    public static WebDriver setup(String url){
       // System.setProperty("webdriver.chrome.driver", "D:\\Git\\AutomationWithVeronica\\drivers\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--ignore-certificate-errors");


        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        // This is telling the selenium webdriver to wait for 20 seconds before it throws exception for unresponsive page
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        // This is telling the selenium webdriver to wait for 20 seconds before it throws exception for Javascript errors
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

        //This is telling the selenium webdriver not to throw the No such element exception for 20 seconds or;
        // This is telling the selenium webdriver to wait for 20 seconds before
        // it throws the No such element exception on all webelements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);

        return driver;
    }

    public static void closeEverything(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public static void takeScreenshots(WebDriver driver, String fileName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("D:\\Git\\AutomationWithVeronica\\screenshots\\" + fileName + "_" + timeStamp + ".png");
        FileUtils.copyFile(sourceFile,destinationFile);
    }

    public static void returnNothing(){
        System.out.println("Nothing is returned");
    }

    public static String method1(){
        return "String";
    }

    public static int method2(){
        return 0;
    }

    public static double method3(){
        return 1.1;
    }


}
