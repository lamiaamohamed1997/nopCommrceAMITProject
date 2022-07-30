package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_Currency {

    public List <WebElement> currencyList(){

        return Hooks.driver.findElements(By.xpath("//*[@class='prices']"));
    }
}
