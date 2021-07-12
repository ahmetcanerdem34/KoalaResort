package com.techproed.tests;
import com.techproed.pages.DefaultPage;
import com.techproed.pages.HotelListCreation;
import com.techproed.pages.LoginPage;
import com.techproed.pages.HotelRoomPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HotelListCreationNegatif_Merve extends TestBase {



    LoginPage loginPage;
    DefaultPage defaultPage;
    HotelListCreation hotelListCreation;

    @BeforeMethod
    public void setUp(){
        loginPage = new LoginPage();
        loginPage.koalaResortLogin();

        hotelListCreation = new HotelListCreation();
        hotelListCreation.hotelManangement();
        hotelListCreation.hotelList();
        hotelListCreation.addHotel.click();

    }
    @Test(dataProvider = "yanlisDatalarlaHotelOlusturma")
    public void yanlisDataileHotelOlusturma(String code, String name, String address, String phone, String email, String group) throws InterruptedException {
        hotelListCreation = new HotelListCreation();
        hotelListCreation.hotelManangement();
        hotelListCreation.hotelList();
        hotelListCreation.addHotel.click();
        hotelListCreation.code.sendKeys(code);
        hotelListCreation.name.sendKeys(name);
        hotelListCreation.address.sendKeys(address);
        hotelListCreation.phone.sendKeys(phone);
        hotelListCreation.email.sendKeys(email);
        Thread.sleep(1000);
        Select groupDropdown = new Select(hotelListCreation.selectGroup);
        groupDropdown.selectByVisibleText(group);
        Thread.sleep(2000);
        hotelListCreation.saveButton.click();
        Thread.sleep(2000);
     //  Assert.assertFalse(hotelListCreation.successfullYazisi.isDisplayed());
        Assert.assertTrue(hotelListCreation.errorMessage.isDisplayed());
    }
    @DataProvider
    public Object[][] yanlisDatalarlaHotelOlusturma() {
        String[][] data = {
                {"", "Sheraton", "Boston, MA USA", " 1234567890", "sheraton@hotmail.com", "Hotel Type1"},
                {"101", "", "Boston, MA USA", " 1234567890", "sheraton@hotmail.com", "Hotel Type1"},
                {"101", "Sheraton", "", " 1234567890", "sheraton@hotmail.com", "Hotel Type1"},
                {"101", "Sheraton", "Boston, MA USA", "", "sheraton@hotmail.com", "Hotel Type1"},
                {"101", "Sheraton", "Boston, MA USA", " 1234567890", "", "Hotel Type1"},
                {"101", "Sheraton", "Boston, MA USA", " 1234567890", "sheraton@hotmail.com", "Select Group"},
        };
        return data;
    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}