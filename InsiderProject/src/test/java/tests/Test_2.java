package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.QAPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.Driver.driver;

public class Test_2 {

    QAPage qaPage = new QAPage();  // QAPage nesnesi doğru bir şekilde başlatıldı
    HomePage homePage = new HomePage();
    Actions actions = new Actions(driver);

    @Test
    public void insiderQualityAssuranceTest() throws InterruptedException {
        // Driver'ın başlatılması ve gerekli ayarlar

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Driver.getDriver().get(ConfigReader.getProperty("insiderhomePage"));
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//a[@id='wt-cli-accept-all-btn']")).click();

        homePage.companyTab.getText();

        //expected ve actual resultları yaz
        String expectedWriting = "Company";
        String actualResult = homePage.companyTab.getText();

        //Assert ile içeriği kontrol et
        Assert.assertTrue(actualResult.contains(expectedWriting));

        homePage.companyTab.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.careersTab);
        Thread.sleep(2000);

        for (int i = 0; i < 5; i++) {
            actions.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();
        }

        WebElement seeAllTeamsButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-outline-secondary.rounded.text-medium.mt-5.mx-auto.py-3.loadmore")));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", seeAllTeamsButton);


        WebElement customerSuccessTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[normalize-space()='Quality Assurance']")
        ));
        jsExecutor.executeScript("arguments[0].click();", customerSuccessTitle);

        WebElement seeAllQAJobsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[normalize-space()='See all QA jobs']")
        ));

        jsExecutor.executeScript("arguments[0].click();", seeAllQAJobsTitle);


        //qaPage.selectLocationOptionInIframe();





    }

}






