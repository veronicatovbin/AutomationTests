package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Helper;

public class DropDown {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://theautomationtechies.com/web-elements-for-ui-testing/";
        WebDriver driver = Helper.setup(url);
        Helper.scroll(700,driver);
        Thread.sleep(1000);

//        // single drop down
//        WebElement selectDropDown = driver.findElement(By.id("Carlist"));
//        Select listOfCars = new Select(selectDropDown);
//
//        int count =listOfCars.getOptions().size();
//        System.out.println("Total items : " + count);
//
//        listOfCars.selectByIndex(3);
//        Thread.sleep(1000);
//
//        listOfCars.selectByValue("BMW Car");
//        Thread.sleep(1000);
//
//        listOfCars.selectByVisibleText("Honda");
//        Thread.sleep(1000);
//
//        for (int i = 0; i < count; i++) {
//            listOfCars.selectByIndex(i);
//            Thread.sleep(1000);
//            System.out.println("Selected item : " + listOfCars.getAllSelectedOptions().get(0).getText());
//        }

        //multiple drop down
        //Choose the country name if it is not Italy and Spain
        WebElement multipleDropdown=driver.findElement(By.name("FromLB"));
        Select countries = new Select (multipleDropdown);
        int count2 = countries.getOptions().size();
        Thread.sleep(1000);
        for (int i = 0; i <count2; i++) {
            String optionText = countries.getOptions().get(i).getText();
            if (optionText.equals("Italy")==false){
                countries.selectByIndex(i);
                Thread.sleep(1000);
            }
        }
        for (int i = 0; i < countries.getAllSelectedOptions().size(); i++) {
            System.out.println(countries.getAllSelectedOptions().get(i).getText());
        }
        countries.deselectAll();


        driver.quit();

    }
}
