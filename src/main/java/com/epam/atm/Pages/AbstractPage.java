package com.epam.atm.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.epam.atm.utils.Singletone;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;


public class AbstractPage{

    WebDriver driver;

    public static final By FIRST_ITEM_LOCATOR = By.xpath("//div[@class='listing__items']//img/../../following-sibling::div[1]//span");//By.xpath("//span[text()='Горы.jpg']");
    public static final By LAST_ITEM_LOCATOR = By.xpath("//div[@class='listing__items']//img/../../../following-sibling::div[5]");//By.xpath("//span[contains(text(),'Санкт')]");
    public static final By LAST_ITEM_LOCATOR_IMG = By.xpath("//div[@class='listing__items']//img/../../../following-sibling::div[5]//img"); //By.xpath("//span[contains(text(),'Санкт')]/parent::div/parent::div/parent::div//img");
    public static final By RECYCLE_BIN = By.xpath("//span[text()='Корзина']");
    public static By userPicture = By.xpath("//div[@class='header__side-right']/div/a");
    public static By quiteMenuItem = By.xpath("//li[@class='menu__list-item']/a[text()='Выйти']");
    private final String ADDRESS = "https://disk.yandex.ru";

    public AbstractPage() throws MalformedURLException {

        this.driver = Singletone.getDriver1();
    }

    public void waitForElementVisible(By locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void getInitialPage(){
        driver.get(ADDRESS);
    }

    public void fillIn(By locator, String text){
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public void clickOn (By locator){
        waitForElementVisible(locator);
        highlightElement(locator);
        driver.findElement(locator).click();

    }

    public void selectItems(){

        waitForElementVisible(FIRST_ITEM_LOCATOR);
        //Screenshoter.takeScreenshot();
        driver.findElement(FIRST_ITEM_LOCATOR).click();
        new Actions(driver).clickAndHold(driver.findElement(FIRST_ITEM_LOCATOR)).moveToElement(driver.findElement(LAST_ITEM_LOCATOR)).release().build().perform();
        //Screenshoter.takeScreenshot();
    }

    public void highlightElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid green'", driver.findElement(locator));
    }

    public void logout() {
        highlightElement(userPicture);
        driver.findElement(userPicture).click();
        highlightElement(quiteMenuItem);
        driver.findElement(quiteMenuItem).click();
    }

    public void killDriver(){
        driver.quit();
    }








}
