package com.testAutomation.pageObjects;

import com.testAutomation.base.BaseTest;
import com.testAutomation.base.DriverFactory;
import com.testAutomation.base.ExtentFactory;
import com.testAutomation.helpers.CommonHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Properties;

public class HomePage extends BaseTest {

    WebDriver driver = null;
    CommonHelpers commonHelpers = new CommonHelpers();
    Properties HomePageProperties = commonHelpers.getFileProperties("locator.properties");

    By btn_login = By.id("login_top1");
    By from_click = By.xpath("//input[@id='flying_from_N']");
    By from_dropdown = By.xpath("//input[@id='flying_from']");
    By blr = By.xpath("//li[@class='ac_odd ac_over']//span[1]");
    By to_click = By.xpath("//input[@id='flying_to_N']");
    By to_dropdown = By.xpath("//input[@id='flying_to']");
    By del  = By.xpath("//li[@class='ac_odd ac_over']//b[1]");
    By btn_submit = By.xpath("//input[@id='searchengine_btn']");

    //Click on login/sign up button
    public void click_login_button(){
        WebDriver driver = DriverFactory.getInstance().getDriver();
        clickElement(driver.findElement(btn_login), "Login Button" );
    }

    //Search for a Ticket
    public void searchFlight(String from, String to){
        WebDriver driver = DriverFactory.getInstance().getDriver();
        clickElement(driver.findElement(from_click), "From Button" );
        send_keys(driver.findElement(from_dropdown), "From Dropdown", from);
        clickElement(driver.findElement(blr),from);
        clickElement(driver.findElement(to_click), "To Button" );
        send_keys(driver.findElement(to_dropdown), "To Dropdown", to);
        clickElement(driver.findElement(del),to);
        clickElement(driver.findElement(btn_submit),"Submit Button" );
    }

}
