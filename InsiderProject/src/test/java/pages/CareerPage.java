package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static utilities.Driver.driver;

public class CareerPage {



    @FindBy( xpath = "(//*[@class='nav-link dropdown-toggle'])[5]")
    public WebElement companyTab;

    @FindBy(xpath = "//img[@alt='Customer Success']")
    public WebElement customerSuccessTabImg;

    @FindBy(xpath = "//h1[normalize-space()='Customer Success']")
    public WebElement customerSuccessTabText;

    @FindBy(xpath = "//h3[text()='Sales']")
    public WebElement salesTab;

    @FindBy(xpath = "//h3[text()='Product & Engineering']")
    public WebElement productTab;

    @FindBy(xpath= ("//p[normalize-space()='London']"))
    public WebElement locationOfLondon;


    public void verifyCustomerSuccessSectionIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Customer Success başlığını bul
        WebElement customerSuccessTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(), 'Customer Success')]")
        ));

        // Elementin görünür olduğunu doğrula
        Assert.assertTrue(customerSuccessTitle.isDisplayed());
        System.out.println("customerSuccessTitle.getText() = " + customerSuccessTitle.getText());
    }
    public void verifySalesIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Customer Success başlığını bul
        WebElement salesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[text()='Sales']")
        ));

        // Elementin görünür olduğunu doğrula
        Assert.assertTrue(salesTitle.isDisplayed());
        System.out.println("SalesTitle.getText() = " + salesTitle.getText());
    }

    public void verifyLondonIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Customer Success başlığını bul
        WebElement locationTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[normalize-space()='London']")
        ));

        // Elementin görünür olduğunu doğrula
        Assert.assertTrue(locationTitle.isDisplayed());
        System.out.println("LocationTitle.getText() = " + locationTitle.getText());
    }
}
