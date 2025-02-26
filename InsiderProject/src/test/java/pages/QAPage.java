package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class QAPage {

    @FindBy(xpath = "//span[@id='select2-filter-by-department-container']")
    public WebElement allForDepartment;

    @FindBy(css = ".btn.btn-outline-secondary.rounded.text-medium.mt-5.mx-auto.py-3.loadmore")
    public WebElement seeAllTeamsButton;




    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    public WebElement allForLocation;

    @FindBy(xpath = "(//a[text()='Find your dream job'])[1]")
    public WebElement findYourDreamjob;

    @FindBy(xpath = "//*[@data-select2-id='select2-filter-by-department-result-eft7-Quality Assurance']")
    public WebElement qualityAssuranceTable;

    @FindBy(xpath = "//a[normalize-space()='See all QA jobs']")
    public WebElement seeAllQaJobs;


    @FindBy(xpath = "//li[text()='Istanbul, Turkiye']")
    public WebElement istanbulTurkiye;

    @FindBy(xpath = "//a[@class='wt-cli-element medium cli-plugin-button wt-cli-accept-all-btn cookie_action_close_header cli_action_button']")
    public WebElement cookieAccept;





    public void selectLocationOption() {
        WebDriver driver = Driver.getDriver();

        // WebDriverWait ile öğenin tıklanabilir olmasını bekle
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Dropdown elementinin görünür hale gelmesini bekle
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(@class, 'select2-container')]")));

        // Dropdown'u tıklamak için kullanıyoruz
        dropdown.click();

        // İlk seçeneği tıklamak için XPath kullanarak öğeyi bul
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@class='select2-results__options']//li[1]")));

        // İlk seçeneğe tıklayın
        firstOption.click();
        System.out.println("firstOption.getText() = " + firstOption.getText());


    }
    }



