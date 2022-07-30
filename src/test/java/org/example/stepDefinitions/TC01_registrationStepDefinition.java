package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Registration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TC01_registrationStepDefinition {

    P01_Registration registerPage = new P01_Registration();

    @Given("user clicks on register button")
    public void user_clicks_on_register_button() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("a[class='ico-register']")).click();
        Thread.sleep(2000);
    }

    @When("user enters personal details")
    public void user_enters_personal_details() {
        registerPage.selectGender().click();
        registerPage.enterFName().sendKeys("Lamiaa");
        registerPage.enterLName().sendKeys("Abdel Hamid");
        registerPage.selectDayOB();
        registerPage.selectMonthOB();
        registerPage.selectYearOB();
        registerPage.emailAdd().sendKeys("automationtest@gmail.com");
    }

    @And("user enters company details")
    public void user_enters_company_details() {
        registerPage.enterCompany().sendKeys("FEPS");

    }

    @And("user enters password")
    public void user_enters_password() throws InterruptedException {
        registerPage.enterPassword().sendKeys("lamiaa123");
        registerPage.confirmPassword().sendKeys("lamiaa123");
        Thread.sleep(2000);
    }

    @And("user hits register")
    public void user_hits_register() throws InterruptedException {
        registerPage.registerBtn().click();
        Thread.sleep(2000);
    }

    @Then("user registers successfully to nop commerce")
    public void user_registers_to_nop_commerce() {
        SoftAssert softAssert = new SoftAssert();

        String expectedResult = "Your registration completed";
        String actualResult = Hooks.driver.findElement(By.xpath("//*[@class='result']")).getText();
        softAssert.assertEquals(actualResult,expectedResult);

        String fontColor = Hooks.driver.findElement(By.xpath("//*[@class='result']")).getCssValue("color");
        System.out.println(fontColor);
        softAssert.assertEquals(fontColor,"rgba(76, 177, 124, 1)" );
        softAssert.assertAll();
    }


}
