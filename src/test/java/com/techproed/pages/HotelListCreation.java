package com.techproed.pages;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelListCreation {

    public HotelListCreation() {
        PageFactory.initElements(Driver.getDriver(), this);
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
    @FindBy(id = "Name")
    public WebElement name;
    @FindBy(id = "Address")
    public WebElement address;
    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id = "Phone")
    public WebElement phone;
    @FindBy(xpath = "//div[text()='Hotel was inserted successfully']")
    public WebElement successfullYazisi;

    @FindBy(xpath ="//div[@class='caption']")
    public WebElement yazi;

    public void login(){
        ilkLoginLinki.click();
     kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("admin_username"));
     passwordTextBox.sendKeys(ConfigReader.getProperty("admin_password"));
     loginButonu.click();


    }


}