package com.techproed.pages;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelListCreation {

    public HotelListCreation() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")
    public WebElement kullaniciAdiTextBox;

    @FindBy(id = "Password")
    public WebElement passwordTextBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[contains(text(),'Hotel Management')]")
    public WebElement hotelManangement;

    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelList;

    @FindBy(xpath = "//span [text()='Add Hotel ']")
    public WebElement addHotel;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement code;

    @FindBy(id = "IDGroup")
    public WebElement selectGroup;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;

    @FindBy(xpath = "//div[text()='Hotel was inserted successfully']")
    public WebElement successfullYazisi;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement OKButtonu;

    @FindBy(id = "Name")
    public WebElement name;

    @FindBy(id = "Address")
    public WebElement address;

    @FindBy(id = "Phone")
    public WebElement phone;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(xpath = "//label[@class='error']")
    public WebElement errorMessage;

    TestBase testBase = new TestBase();



//    public void koalaResortLogin(){
//    Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
//        ilkLoginLinki.click();
//        kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
//        passwordTextBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
//        loginButonu.click();
//
//    }

    public void hotelManangement(){
        hotelManangement.click();
    }
    public void hotelList(){
        hotelList.click();
    }
        
    }



