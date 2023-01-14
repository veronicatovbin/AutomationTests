package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Git\\AutomationWithVeronica\\drivers\\chromedriver.exe");
        String url ="https://www.google.ca/search?q=today+weather";

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(url);

       // Thread.sleep(3000);
        /*
        get the page actualTitle - check if it has google in it
        get the current URL - check if it has google in it

         */

        /*
        Go over the String Class
         */
        String actualTitle = driver.getTitle();
        String expectedTitle = "google";
        //System.out.println(actualTitle);

        if(actualTitle.toLowerCase().equals(expectedTitle)){
            System.out.println("Title - Test Passed");
        }
        else {
            System.out.println("Title - Test Failed "+ actualTitle);
        }
        String actualUrl= driver.getCurrentUrl();
        String expectedURL = "google";
        // System.out.println(actualUrl);
        if(actualUrl.toLowerCase().contains(expectedURL)){
            System.out.println("Current URL - test passed");
        }
        else{
            System.out.println("Current URL - Test failed " + actualUrl);
        }
        driver.quit();
    }
}
