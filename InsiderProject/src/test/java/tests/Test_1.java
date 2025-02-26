package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareerPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;


import static utilities.Driver.driver;

public class Test_1 {
    JavascriptExecutor js = (JavascriptExecutor)driver;
    HomePage homePage = new HomePage();
    CareerPage careerPage = new CareerPage();
    Actions actions = new Actions(driver);


    @Test
    public void insidertest() throws InterruptedException {

        //Driver ile sayfayı aç
        Driver.getDriver().get(ConfigReader.getProperty("insiderhomePage"));
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//a[@id='wt-cli-accept-all-btn']")).click();

        //homePageteki company text yazısını al
        homePage.companyTab.getText();

        //expected ve actual resultları yaz
        String expectedWriting = "Company";
        String actualResult = homePage.companyTab.getText();

        //Assert ile içeriği kontrol et
        Assert.assertTrue(actualResult.contains(expectedWriting));

        homePage.companyTab.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",homePage.careersTab);
        Thread.sleep(2000);

        for (int i = 0; i < 4; i++) {
            actions.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();
        }
        careerPage.verifyCustomerSuccessSectionIsVisible();

        Thread.sleep(3);

        careerPage.verifySalesIsVisible();

        Thread.sleep(3);

        careerPage.verifyLondonIsVisible();

        driver.close();
    }



}
