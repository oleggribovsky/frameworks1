package com.epam.atm.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Singletone {

    public static WebDriver driver;

    private Singletone(){
    }


    private static WebDriver init() throws MalformedURLException {
        System.setProperty("webdriver.ie.driver", "C:\\users\\aleg_hrybouski\\Desktop\\a\\IEDriverServer.exe" );
       //System.setProperty("webdriver.chrome.driver", "C:\\users\\aleg_hrybouski\\Desktop\\a\\chromedriver.exe"); // do not forget to add chromedriver.exe file to src/main/resources/
       //driver = new InternetExplorerDriver();
       WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.internetExplorer());
       driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       return driver;
    }

    public static WebDriver getDriver1() throws MalformedURLException {
        if (driver==null){
            return driver = Singletone.init();
        }
        return driver;
    }

    public static void killDriver(){
        driver.quit();
    }




}

