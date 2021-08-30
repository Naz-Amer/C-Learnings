package objects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {

    public Elements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//nav[@class='column labcorp']//li[3]//a[1]")
    public WebElement Careers;


    @FindBy(xpath="//input[@class='search-keyword']")
    public WebElement KeywordSearch;


    @FindBy(xpath = "//input[@class='search-location']")
    public WebElement CityStateZip;


    @FindBy(xpath = "//button[normalize-space()='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//h1[contains(text(),'911 results found for Laboratory Automation Engine')]")
    public WebElement Sresult;


    @FindBy(xpath = " //h2[normalize-space()='Laboratory Automation Engineer']")
    public WebElement firstOne;

    @FindBy(xpath = "//a[@class='button job-apply top']")
    public WebElement applayNow;

    //.job-description__heading
    @FindBy(xpath = "//*[contains(@class, 'job-description__heading')]")
    //@FindBy(css = ".job-description__heading")
    public WebElement jobTitle;

    @FindBy(xpath = "//span[@class='job-location job-info']")
    public WebElement jobLocation;

    @FindBy(xpath = "//span[@class='job-id job-info']")
    public WebElement jobID;

    @FindBy(xpath = "//span[normalize-space()='Return to Job Search']")
    public WebElement returnSearch;

    // In Applaying page

    @FindBy(xpath = "//span[@class='jobTitle job-detail-title']")
    public WebElement ApjobTitle;

    @FindBy(xpath = "//span[@class='jobnum']")
    public WebElement ApjobID;

    @FindBy(xpath = "//span[@class='resultfootervalue']")
    public WebElement ApLocation;









}
