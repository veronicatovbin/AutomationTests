package adv_selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Helper;

public class AutomationTestingUsingTestNG {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test - Setup");
        String url = "https://theautomationtechies.com/welcome-to-automation-testing/";
        driver = Helper.setup(url);
        Helper.scroll(1000, driver);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        System.out.println("After Test - TearDown");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 1)
    public void TC01_testRadioButtons() {
        driver.findElement(By.xpath("//*[@id=\"Are_you_excited_For_Automation_Testing___div\"]/div/label[1]")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Are_you_excited_For_Automation_Testing___div\"]/div/label[2]")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Are_you_excited_For_Automation_Testing___div\"]/div/label[3]")).click();
        //Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void TC02_testCheckboxes() {
        driver.findElement(By.id("What_is_your_dream_job__100K_Job")).click();
        //Thread.sleep(2000);
        driver.findElement(By.id("What_is_your_dream_job__Vacation")).click();
        //Thread.sleep(2000);
    }

    @Test (priority = 2)
    public void TC03_testDropDown() {
        WebElement el = (driver.findElement(By.id("Work_from_Home_")));
        Select select = new Select(el);
        select.selectByIndex(0);
        //Thread.sleep(2000);
        select.selectByValue("No");
        //Thread.sleep(2000);
        select.selectByVisibleText("Maybe");
        //Thread.sleep(2000);
        System.out.println(select.getFirstSelectedOption().getText());
    }

    @Test (priority = 3)
    public void TC04_testEmail() {
        driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
    }

    @Test (priority = 4)
    public void TC05_testDateAndTime() throws InterruptedException {
        //driver.findElement(By.id("Today_s_Date_")).clear();
        driver.findElement(By.id("Today_s_Date_")).sendKeys("2023", Keys.TAB, "01", "02");

        driver.findElement(By.id("Current_Timestamp_")).click();
        driver.findElement(By.id("Current_Timestamp_")).sendKeys("12", "23", Keys.ARROW_DOWN);
    }

    @Test (priority = 5)
    public void TC06_testNumber() {
        Helper.scroll(500, driver);
        driver.findElement(By.cssSelector("#Enter_any_number_between__1_to_100")).sendKeys("5");
        //Thread.sleep(2000);
    }

    @Test (priority = 6)
    public void TC07_testWebsite() {
        driver.findElement(By.name("Favorite Website?")).sendKeys("https://www.google.com/");
        //Thread.sleep(2000);
    }

    @Test (priority = 7)
    public void TC08_testReadParagraph() {
        Helper.scroll(1500, driver);
        WebElement Paragraph = driver.findElement(By.xpath("//*[@id=\"Paragraph__div\"]/p[2]"));
        System.out.println(Paragraph.getText());
        //Thread.sleep(2000);
    }

    @Test (priority = 8)
    public void TC09_testFileUploader() {
        driver.findElement(By.id("File_Uploader_")).sendKeys("D:\\Git\\testFile.txt");
        //Thread.sleep(2000);
    }

    @Test (priority = 9)
    public void TC10_testAddress() {
        driver.findElement(By.xpath("//*[@id=\"Fill_in_the_Address_address_line_1\"]")).sendKeys("123 str");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Fill_in_the_Address_address_line_2\"]")).sendKeys("NY");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Fill_in_the_Address_state\"]")).sendKeys("NY");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Fill_in_the_Address_country\"] ")).sendKeys("USA"); //Thread.sleep(2000);
        //Thread.sleep(1000);
    }

    @Test (enabled = false, priority = 10)
    public void TC11_testInputPara() {
        driver.findElement(By.name("What do you think of this form?")).sendKeys("Difficult ");
        //Thread.sleep(2000);
    }

    @Test (priority = 13)
    public void TC12_submit() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div/section/div/form/fieldset/div[14]/div/input")).click();
        //Thread.sleep(3000);

        Assert.assertTrue(driver.getCurrentUrl().contains("thanks"));
    }


}
