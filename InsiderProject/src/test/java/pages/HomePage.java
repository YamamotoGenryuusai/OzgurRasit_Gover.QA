package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.TestBaseRapor;

public class HomePage extends TestBaseRapor {
    public HomePage(){PageFactory.initElements(Driver.getDriver(),this);}

    // Header/Features Link

    @FindBy( xpath = "(//a[normalize-space()='Company'])[1]")
    public WebElement companyTab;

    @FindBy(xpath = "//a[normalize-space()='Careers']")
    public WebElement careersTab;



    @FindBy(xpath = "//span[@id='select2-filter-by-department-container']")
    public WebElement allForDepartment;

    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    public WebElement allForLocation;

    @FindBy(xpath = "(//a[text()='Find your dream job'])[1]")
    public WebElement findYourDreamjob;

    @FindBy(xpath = "//*[@data-select2-id='select2-filter-by-department-result-eft7-Quality Assurance']")
    public WebElement qualityAssuranceTable;

    @FindBy(xpath = "//a[@href='https://useinsider.com/careers/open-positions/?department=qualityassurance']")
    public WebElement seeAllQaJobs;


    @FindBy(xpath = "//li[text()='Istanbul, Turkiye']")
    public WebElement istanbulTurkiye;




}
