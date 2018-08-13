package com.epam.atm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;

public class RecycleBinPage extends AbstractPage{
    public static final By RECYCLE_BIN_LINE = By.xpath("//span[text()='Корзина']");
    public static final By RECOVER_ITEM = By.xpath("//span[text()='Восстановить']");

    public RecycleBinPage() throws MalformedURLException {
    }


    public RecycleBinPage openRecycleBin(){
        new Actions(driver).doubleClick(driver.findElement(RECYCLE_BIN_LINE)).perform();
        return this;
    }

    public RecycleBinPage selectPictures(){
        selectItems();
        return this;
    }

    public RecycleBinPage rightRecover(){
        new Actions(driver).contextClick(driver.findElement(LAST_ITEM_LOCATOR_IMG)).build().perform();
        highlightElement(RECOVER_ITEM);
        //driver.findElement(RECOVER_ITEM).click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(RECOVER_ITEM));
        return this;

    }
}
