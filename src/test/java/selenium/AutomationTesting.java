package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utility.Helper;

public class AutomationTesting {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String url = "https://theautomationtechies.com/welcome-to-automation-testing/";
        driver = Helper.setup(url);
        Helper.scroll(1000, driver);

//        testDateAndTime();
//        testRadioButtons();
//        testCheckboxes();
//        testDropDown();
//        testEmail();
//        testNumber();
//        testWebsite();
//        testReadParagraph();
        testFileUploader();
//        testAddress();
//        testInputParagraph();

        Thread.sleep(3000);
        driver.quit();
        }

    private static void testDateAndTime() throws InterruptedException {
        //driver.findElement(By.id("Today_s_Date_")).clear();
        driver.findElement(By.id("Today_s_Date_")).sendKeys("2023", Keys.TAB, "01", "02");

        driver.findElement(By.id("Current_Timestamp_")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("Current_Timestamp_")).sendKeys("12","23", Keys.ARROW_DOWN);
    }

    private static void testInputParagraph() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div/section/div/form/fieldset/div[14]/div/input")).click();
        //Thread.sleep(3000);
    }

    private static void testAddress() {
        driver.findElement(By.xpath("//*[@id=\"Fill_in_the_Address_address_line_1\"]")).sendKeys("123 str");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Fill_in_the_Address_address_line_2\"]")).sendKeys("NY");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Fill_in_the_Address_state\"]")).sendKeys("NY");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Fill_in_the_Address_country\"] ")).sendKeys("USA"); //Thread.sleep(2000);
        //Thread.sleep(1000);
        driver.findElement(By.name("What do you think of this form?")).sendKeys("Difficult ");
        //Thread.sleep(2000);
    }

    private static void testFileUploader() {
        driver.findElement(By.id("File_Uploader_")).sendKeys("D:\\Git\\testFile.txt");
        //Thread.sleep(2000);
    }

    private static void testReadParagraph() {
        Helper.scroll(1500,driver);
        WebElement Paragraph= driver.findElement(By.xpath("//*[@id=\"Paragraph__div\"]/p[2]"));
        System.out.println(Paragraph.getText());
        //Thread.sleep(2000);
    }

    private static void testWebsite() {
        driver.findElement(By.name("Favorite Website?")).sendKeys("https://www.google.com/");
        //Thread.sleep(2000);
    }

    private static void testNumber() {
        Helper.scroll(500,driver);
        driver.findElement(By.cssSelector("#Enter_any_number_between__1_to_100")).sendKeys("5");
        //Thread.sleep(2000);
    }

    private static void testEmail() {
        driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
    }

    public static void testRadioButtons(){
        driver.findElement(By.xpath("//*[@id=\"Are_you_excited_For_Automation_Testing___div\"]/div/label[1]")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Are_you_excited_For_Automation_Testing___div\"]/div/label[2]")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Are_you_excited_For_Automation_Testing___div\"]/div/label[3]")).click();
        //Thread.sleep(2000);
    }

    public static void testCheckboxes(){
        driver.findElement(By.id("What_is_your_dream_job__100K_Job")).click();
        //Thread.sleep(2000);
        driver.findElement(By.id("What_is_your_dream_job__Vacation")).click();
        //Thread.sleep(2000);
    }

    public static void testDropDown(){
        WebElement el=(driver.findElement(By.id("Work_from_Home_")));
        Select select = new Select(el);
        select.selectByIndex(0);
        //Thread.sleep(2000);
        select.selectByValue("No");
        //Thread.sleep(2000);
        select.selectByVisibleText("Maybe");
        //Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());
    }

}

