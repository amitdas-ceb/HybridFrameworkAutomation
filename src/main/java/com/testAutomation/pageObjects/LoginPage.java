package com.testAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "txtloginemail")
    WebElement txt_email;

    @FindBy(id = "txtloginpassword")
    WebElement txt_password;

    @FindBy(className = "btn_yellow")
    WebElement btn_signin;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
