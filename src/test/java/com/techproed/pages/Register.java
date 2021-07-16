package com.techproed.pages;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
public class Register {
    public Register(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement login;
    @FindBy(xpath = "//span[text()='Create a new account']")
    public WebElement createAccount;
    @FindBy(id = "UserName")
    public WebElement userName;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id = "NameSurname")
    public WebElement fullName;
    @FindBy(id = "PhoneNo")
    public WebElement phoneNo;
    @FindBy(id = "SSN")
    public WebElement ssn;
    @FindBy(id = "DrivingLicense")
    public WebElement driverLicense;
    @FindBy(id = "IDCountry")
    public WebElement country;
    @FindBy(id = "IDState")
    public WebElement state;
    @FindBy(id = "Address")
    public WebElement adress;
    @FindBy(id = "WorkingSector")
    public WebElement workingSector;
    @FindBy(id = "BirthDate")
    public WebElement birthDate;
    @FindBy(id = "btnSubmit")
    public WebElement save;
    @FindBy(xpath = "//label[text()='Please select a username']")
    public WebElement userNameHata;
    @FindBy(xpath = "//label[text()='At least one uppercase character is required']")
    public WebElement passwordHata;
    @FindBy(xpath ="//label[text()='Please provide correct email address']")
    public WebElement emailHata;
    @FindBy(xpath = "//label[text()='This field is required.']")
    public WebElement hata;
    @FindBy(xpath = "//label[text()='Please enter phone number']")
    public WebElement phoneHata;
    @FindBy(xpath = "//label[text()='Select Country']")
    public WebElement countryHata;
    @FindBy(xpath = "//label[text()='Select State']")
    public WebElement stateHata;
    public void loginPage(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        login.click();
        createAccount.click();
    }
    @FindBy(xpath="(//a[@class='nav-link'])[7]")
    public WebElement firstLoginButton;
    @FindBy(partialLinkText = "Create a new account")
    public WebElement createNewAccount;
    // @FindBy(xpath = "//input[@placeholder='Username']")
    // public WebElement userName;
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