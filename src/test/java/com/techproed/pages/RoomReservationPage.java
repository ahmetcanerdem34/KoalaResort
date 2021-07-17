package com.techproed.pages;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class RoomReservationPage {

    //1.webdriver olustur
    WebDriver driver;

    //2.parametreli public constructor
    //parametre olarak Webdriver driver tyaz

    public RoomReservationPage (WebDriver driver){

        //3. parametre olarak verilen driver ile WebDriver driver; eslestir
        this.driver =driver;

        //4.page fabrikasina git ve
        PageFactory.initElements(driver, this);
    }
//    public RoomReservationPage(){
//        PageFactory.initElements(Driver.getDriver(),this);
//    }

    @FindBy(className = "hidden-480")
    public WebElement addRoomReservationButton;

    @FindBy(id = "IDUser")
    public WebElement idUser;

    @FindBy(id = "IDHotelRoom")
    public WebElement idHotelRoom;

    @FindBy(id = "Price")
    public WebElement price;

    @FindBy(id="DateStart")
    public WebElement dateStart;

    @FindBy(id="DateEnd")
    public WebElement dateEnd;

    @FindBy(id="AdultAmount")
    public WebElement adultAmount;

    @FindBy(id="ChildrenAmount")
    public WebElement childrenAmount;

    @FindBy(id="ContactNameSurname")
    public WebElement nameAndSurname;

    @FindBy(id="ContactPhone")
    public WebElement contactPhone;

    @FindBy(id="ContactEmail")
    public WebElement contactEmail;

    @FindBy(id="Notes")
    public WebElement notes;

    @FindBy(id="Approved")
    public WebElement approved;

    @FindBy(id="IsPaid")
    public WebElement isPaid;

    @FindBy(id="btnSubmit")
    public WebElement saveButton;

    @FindBy(className = "bootbox-body")
    public WebElement actualSuccessMessage;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement okSuccesButton;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement lastOKButon;

    @FindBy(xpath = "//a[@class='remove']")
    public WebElement removeButtonRoomReservationPage;

    @FindBy(xpath = "//div[@class='col-md-12']")
    public WebElement emptyPageAfterRemove;

    RoomReservationPage roomReservationPage;
    DefaultPage defaultPage;
    LoginPage loginPage;

    //@BeforeMethod
    public void defaultLogin(){
        loginPage= new LoginPage();
        loginPage.koalaResortLogin();

        defaultPage =new DefaultPage();
        defaultPage.hotelManagement.click();
        defaultPage.roomReservations.click();
        roomReservationPage = new RoomReservationPage(driver);
        roomReservationPage.addRoomReservationButton.click();

    }

    @FindBy (xpath = "//label[@for='ContactEmail']")
    public WebElement contactEmailErrorMessage;

}
