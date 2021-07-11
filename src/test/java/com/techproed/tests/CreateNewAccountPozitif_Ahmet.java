package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.pages.LoginPage;
import com.techproed.pages.Register;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.TreeMap;

public class CreateNewAccountPozitif_Ahmet extends TestBase {



        Register register =new Register();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Faker faker=new Faker();


        @Test
        public void creatNewRegistration() throws InterruptedException {

                register.firstLoginButton.click();
                js.executeScript("javascript:window.scrollBy(250,350)");
                Thread.sleep(2000);
                register.createNewAccount.click();

        String email=faker.internet().emailAddress();

                Actions actions=new Actions(Driver.getDriver());
                actions.click(register.userName).
                        sendKeys(faker.name().name()).
                        sendKeys(Keys.TAB).
                        sendKeys(ConfigReader.getProperty("registration_password")).
                        sendKeys(Keys.TAB).sendKeys(email).
                        sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                        sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("registration_phoneNo")).
                        sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("registration_ssn")).
                        sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("registration_drivingLicense")).
                        sendKeys(Keys.TAB).click().perform();
                Select select = new Select(register.selectCountry);
                select.selectByVisibleText(ConfigReader.getProperty("registration_idCountry"));
                actions.sendKeys(Keys.TAB).perform();
                Select select1 = new Select(register.selectState);
                select1.selectByVisibleText(ConfigReader.getProperty("registration_idState"));

                actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("registration_address")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("registration_workingSector")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("registration_birthDate")).
                sendKeys(Keys.TAB).
                click(register.saveButton).click().perform();
                Thread.sleep(2000);
                actions.contextClick(register.okButton).click().perform();
                Thread.sleep(2000);
                actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();
                Thread.sleep(200);
                Assert.assertTrue(register.succesfullyInformation.isDisplayed(),"Mesaj göründü" );

        }

    }

