package com.epam.atm.Pages;

import org.openqa.selenium.By;
import com.epam.atm.Business.AdminUser;

import java.net.MalformedURLException;

public class LoginPage extends AbstractPage{


    public By loginInput = By.name("login");
    public By passwordInput = By.name("passwd");
    public By okButton = By.xpath("//button[@class='passport-Button']");
    public By otherAccountLink = By.xpath("//span[text()='Другой аккаунт']");

    public LoginPage() throws MalformedURLException {
    }


    public HomePage loginUser(AdminUser user) throws MalformedURLException {
        clickOn(otherAccountLink);
        fillIn(loginInput, user.getLogin());
        fillIn(passwordInput, user.getPassword());
        clickOn(okButton);
        return new HomePage();
    }




}


