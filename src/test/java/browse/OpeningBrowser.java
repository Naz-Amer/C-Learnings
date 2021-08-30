package browse;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OpeningBrowser {

    WebDriver driver;

    @BeforeTest

    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.labcorp.com/");
    }

    @Test

    public void clickCarier() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Elements webObject = new Elements(driver);
        js.executeScript("arguments[0].scrollIntoView();", webObject.Careers);
        webObject.Careers.click();


        Set<String> list = driver.getWindowHandles();
        for (String each : list) {
            driver.switchTo().window(each);

        }

        webObject.KeywordSearch.sendKeys("Laboratory Automation Engineer 1");
        webObject.CityStateZip.clear();
        webObject.submitButton.click();


//        Assert.assertEquals("911 results found for Laboratory Automation Engineer 1", webObject.Sresult.getText());
//        System.out.println("The Actual result: " + webObject.Sresult.getText());
        js.executeScript("arguments[0].scrollIntoView();", webObject.firstOne);
        webObject.firstOne.click();
        js.executeScript("arguments[0].scrollIntoView();", webObject.applayNow);

        Assert.assertEquals("Laboratory Automation Engineer", webObject.jobTitle.getText());
        System.out.println("asserEquals:" + webObject.jobTitle.getText());

        Assert.assertEquals("Location\n" +
                "South San Francisco, California", webObject.jobLocation.getText());
        System.out.println("asserEquals:" + webObject.jobLocation.getText());

        Assert.assertEquals("Laboratory Automation Engineer", webObject.jobTitle.getText());
        Assert.assertEquals("Job ID 21-89455", webObject.jobID.getText());
        System.out.println("asserEquals:" + webObject.jobID.getText());
        webObject.applayNow.click();

        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='×']")));
        // click on the compose button as soon as the "compose" button is visible
        driver.findElement(By.xpath("//button[normalize-space()='×']")).click();





//        String j1 = webObject.jobTitle.getText().trim();
//        System.out.println(j1);
//        String j2 = webObject.ApjobTitle.getText().trim();
//        System.out.println(j2);
//        Assert.assertEquals(j1, j2, "Same job title");
//        System.out.println("Both Job titles are the same: " + j1 + "|" + j2);


//        String id1 = webObject.jobID.getText();
//        String id2 = webObject.ApjobID.getText();
//        Assert.assertEquals(id1, id2);
//        System.out.println("Job Id are same: " + id1 + "|" + id2);
//
//        String loc1 = webObject.jobLocation.getText();
//        String loc2 = webObject.ApLocation.getText();
//        Assert.assertEquals(loc1, loc2);
//        System.out.println("Job Locations are same: " + loc1 + "|" + loc2);


        webObject.returnSearch.click();



//    @AfterTest
//
//    public void closeUp(){
//        driver.quit();
//    }
    }
}
