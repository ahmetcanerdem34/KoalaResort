package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Register {

    public Register(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="(//a[@class='nav-link'])[7]")
    public WebElement firstLoginButton;

    @FindBy(partialLinkText = "Create a new account")
    public WebElement createNewAccount;

    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement userName;

    @FindBy(xpath = "//select[@title='Select Country']")
    public WebElement selectCountry;

    @FindBy(xpath = "//select[@name='IDState']")
    public WebElement selectState;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement address;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement saveButton;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement okButton;

    @FindBy(xpath = "//div[@id='DescriptionDiv']")
    public WebElement succesfullyInformation;


    public void registerList(){




    }
}