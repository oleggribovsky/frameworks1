package com.epam.atm;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.epam.atm.Class.Steps;

import java.net.MalformedURLException;

/**
 * Unit test for simple Browser.
 */
public class AppTest extends Steps
{
    public AppTest() throws MalformedURLException {
    }

    @AfterClass
    public void killMyDriver(){
        endDriver();


    }
    @Test
    public void administratorSmoke() throws MalformedURLException {
        loginAsAdministrator();
        chooseAllPictures();
        moveToRecycleBin();
        extractFromRecycleBin();
        userLogout();
    }



}
