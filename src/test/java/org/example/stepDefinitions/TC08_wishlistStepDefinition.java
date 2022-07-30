package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P08_wishlist;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class TC08_wishlistStepDefinition {
    P08_wishlist wishlist = new P08_wishlist();
    int wishlistNum;

    @When("user adds product to his wishlist")
    public void user_adds_product_to_wishlist() {
        wishlist.wishlistBtn().get(2).click();
    }

    @Then("addition success message should be displayed")
    public void success_msg_displayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class='bar-notification success']")).isDisplayed());
        String backgroundColor = Hooks.driver.findElement(By.xpath("//*[@class='bar-notification success']")).getCssValue("background-color");
        String backgroundHex = Color.fromString(backgroundColor).asHex();
        softAssert.assertEquals(backgroundHex, "#4bb07a");
    }

    @Then("user gets number of products in wishlist")
    public void user_gets_number_of_products_in_wishlist() {

        String wishlistCount = Hooks.driver.findElement(By.cssSelector("span[class='wishlist-qty']")).getText();

        //Convert wishlistCount String to integer
        wishlistCount = wishlistCount.replaceAll("[^0-9]", "");
        wishlistNum = Integer.parseInt(wishlistCount);
    }

    @And("number of wishlist items increased")
    public void number_of_wishlist_items_increased() {
        Assert.assertTrue(wishlistNum > 0);
    }

}
