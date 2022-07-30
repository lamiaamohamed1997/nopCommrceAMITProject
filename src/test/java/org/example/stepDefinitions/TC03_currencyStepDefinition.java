package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_Currency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC03_currencyStepDefinition {

    P03_Currency currency = new P03_Currency();

    //Capture the static menu of currencies
    Select selCurrency = new Select(Hooks.driver.findElement(By.id("customerCurrency")));

    @Given("guest user clicks on currency menu")
    public void guest_user_clicks_on_currency_menu() throws InterruptedException {
        selCurrency.selectByVisibleText("US Dollar");
        Thread.sleep(2000);
    }

    @When("guest user selects Euro currency")
    public void guest_user_selects_Euro_currency() {
        selCurrency.selectByVisibleText("Euro");
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Then("currency should be changed to Euro")
    public void currency_changed_to_Euro() {
        String euro = "€";
        List <WebElement> elements = currency.currencyList();
        for (int i=0; i<elements.size(); i++){
            String elementText = elements.get(i).getText();
            Assert.assertEquals(elementText.contains(euro),true);
        }

    }
}
