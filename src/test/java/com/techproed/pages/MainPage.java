package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Log in")
    public WebElement mainPageLoginLink;

    @FindBy(xpath = "(//*[@class='nav-link'])[2]")
    public WebElement room;

    @FindBy(xpath = "(//*[@class='nav-link'])[3]")
    public WebElement restorant;

    @FindBy(xpath = "(//*[@class='nav-link'])[4]")
    public WebElement about;

    @FindBy(xpath = "(//*[@class='nav-link'])[5]")
    public WebElement blog;

    @FindBy(xpath = "(//*[@class='nav-link'])[6]")
    public WebElement contact;

    @FindBy(xpath = "(//*[@class='nav-link'])[7]")
    public WebElement logIn;

    @FindBy(className = "navbar-brand")
    public WebElement koalaLogo;

    @FindBy(xpath = "(//*[@class='nav-link'])[1]")
    public WebElement home;

    @FindBy(xpath ="//*[@id='checkin_date']")
    public WebElement check_in_Date;
    @FindBy(xpath ="//*[@id='checkout_date']")
    public WebElement  check_out_Date;
    @FindBy(id="IDRoomType")
    public WebElement roomType;
    @FindBy(id="AdultCount")
    public WebElement adultCount;
    @FindBy(xpath="//*[@value='Check Availability']")
    public WebElement checkAvailable;

}
