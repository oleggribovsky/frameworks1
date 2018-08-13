package com.epam.atm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class YandexDiskPage extends AbstractPage{


    private final By signInButton = By.xpath("//a[@class='button header__login-link']");

    public YandexDiskPage() throws MalformedURLException {
    }

    public LoginPage openLoginPage() throws MalformedURLException {
        getInitialPage();
        clickOn(signInButton);
        return new LoginPage();
    }




}
