package com.epam.atm.Class;

import com.epam.atm.Business.AdminUser;
import com.epam.atm.Pages.*;

import java.net.MalformedURLException;

public class Steps {

    AbstractPage abstractPage;
    YandexDiskPage yandexDiskPage;
    LoginPage loginPage;
    HomePage homePage;
    RecycleBinPage recycleBinPage;


    public Steps() throws MalformedURLException {
        this.abstractPage = new AbstractPage();
        this.yandexDiskPage = new YandexDiskPage();
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.recycleBinPage = new RecycleBinPage();
    }


    public void loginAsAdministrator() throws MalformedURLException {
      yandexDiskPage.openLoginPage().loginUser(new AdminUser());
    }

    public void userLogout(){
        homePage.logout();
    }

    public void chooseAllPictures(){
        homePage.selectItems();
    }

    public void moveToRecycleBin(){
        homePage.drag();

    }

    public void extractFromRecycleBin(){
        recycleBinPage.openRecycleBin().selectPictures().rightRecover();
    }

    public void endDriver(){
        abstractPage.killDriver();
    }



}
