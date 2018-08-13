package com.epam.atm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.net.MalformedURLException;

public class HomePage extends AbstractPage {

    public HomePage() throws MalformedURLException {
    }

    public HomePage drag(){
        waitForElementVisible(FIRST_ITEM_LOCATOR);
        new Actions(driver).dragAndDrop(driver.findElement(LAST_ITEM_LOCATOR_IMG), driver.findElement(RECYCLE_BIN)).build().perform();
        return this;
    }
}
