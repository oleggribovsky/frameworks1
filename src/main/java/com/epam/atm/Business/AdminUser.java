package com.epam.atm.Business;

import com.epam.atm.utils.PropertyManager;

public class AdminUser {

    private String login;
    private String password;

    public AdminUser(){
        PropertyManager propertyManager = new PropertyManager();
        this.login= propertyManager.propFile("login");
        this.password = propertyManager.propFile("password");
    }

    public String getLogin(){

        return this.login;
    }

    public String getPassword(){

        return this.password;

    }

}
