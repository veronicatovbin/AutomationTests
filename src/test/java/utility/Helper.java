package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    public static void scroll(int num, WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollBy(0,"+num + ")","");
    }
    public static WebDriver setup(String url){
        System.setProperty("webdriver.chrome.driver", "D:\\Git\\AutomationWithVeronica\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // This is telling the selenium webdriver to wait for 10 seconds before it throws exception for unresponsive page
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        // This is telling the selenium webdriver to wait for 5 seconds before it throws exception for Javascript errors
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));

        //This is telling the selenium webdriver not to throw the No such element exception for 10 seconds or;
        // This is telling the selenium webdriver to wait for 10 seconds before
        // it throws the No such element exception on all webelements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);

        return driver;
    }

    public static void closeEverything(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
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
