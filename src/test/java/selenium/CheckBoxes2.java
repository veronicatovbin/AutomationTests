package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Helper;

import java.util.List;

public class CheckBoxes2 {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        WebDriver driver = Helper.setup(url);
        Helper.scroll(500, driver);

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));

        for(WebElement element : checkboxes){
            if(element.isSelected()==false){
                System.out.println("I am clicking on : " + element.getAttribute("value"));
                element.click();
            }
        }

//        WebElement content = driver.findElement(By.className("numbers"));
//        System.out.println(content.getText());

        Thread.sleep(2000);
        driver.quit();
    }
}
