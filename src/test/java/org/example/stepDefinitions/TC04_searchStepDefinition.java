package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.example.pages.P04_Search;

import java.util.List;
import java.util.Locale;

public class TC04_searchStepDefinition {
    P04_Search searchPage = new P04_Search();

    @Given("guest user clicks on search tab")
    public void guest_user_clicks_on_search() {
        searchPage.searchTab().clear();
        searchPage.searchTab().click();
    }

    @When("^guest user enters search keyword \"(.*)\"$")
    public void guest_user_enters_search_keyword(String keyword) {

        searchPage.searchTab().sendKeys(keyword);
    }

    @And("guest user hits enter to search")
    public void guest_user_hits_enter_to_search() throws InterruptedException {
        searchPage.searchTab().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then("^search results are displayed for user with \"(.*)\"$")
    public void search_results_displayed(String keyword) {

        String expectedResult = "https://demo.nopcommerce.com/search?q=";
        String actualResult = Hooks.driver.getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualResult.contains(expectedResult));

        List <WebElement> searchList = searchPage.searchResults();
        for (int i = 0; i < searchList.size(); i++) {
            String keywordResult = searchList.get(i).getText().toLowerCase(Locale.ROOT);
            softAssert.assertEquals(keywordResult.contains(keyword),true);
        }
        int size = Hooks.driver.findElements(By.cssSelector("[class ='product-item']")).size();
        softAssert.assertTrue(size > 0);
        softAssert.assertAll();
    }

    @When("^guest user enters search sku \"(.*)\"$")
    public void guest_user_enters_search_sku(String sku) {
        searchPage.searchTab().sendKeys(sku);
    }

    @Then("guest user clicks on item to view details")
    public void user_clicks_on_item_view_details(){
    searchPage.searchResults().get(0).click();
    }

    @And("^product sku matches selected \"(.*)\"$")
    public void product_sku_matches_selected_sku(String sku){
        String actualResult = Hooks.driver.findElement(By.xpath("//*[@class='sku']")).getText();
        Assert.assertEquals(actualResult.contains(sku),true);
    }
}

