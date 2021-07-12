package com.techproed.tests;

import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import com.techproed.utilities.TestBaseAnasayfa;
import org.testng.annotations.Test;

public class MainPageCheck_Islam extends TestBaseAnasayfa {
    MainPage mainPage;

    @Test
    public void tc_001()  {
    // Ana sayfadaki room linkini gorur
        mainPage=new MainPage();
        mainPage.room.isDisplayed();
    // room linkini tiklar
        mainPage.room.click();
    }
    @Test
    public void tc_002(){
    // Ana sayfadaki Restaurant linkini gorur
        mainPage=new MainPage();
        mainPage.restorant.isDisplayed();

    // restaurant linkini tiklar
        mainPage.restorant.click();
    }
    @Test
    public void tc_003() {

    // Ana sayfadaki About linkini gorur
        mainPage=new MainPage();
        mainPage.about.isDisplayed();

    // About linkini tiklar
        mainPage.about.click();
    }
    @Test
    public void tc_004() {
        //    Ana sayfadaki Blog linkini gorur
        mainPage=new MainPage();

        mainPage.blog.isDisplayed();
         //    Blog linkini tiklar
         mainPage.blog.click();
    }
    @Test
    public void tc_005() {
    //    Ana sayfadaki Contact linkini gorur
        mainPage=new MainPage();
        mainPage.contact.isDisplayed();

    //    Contact linkini tiklar
        mainPage.contact.click();
       }
    @Test
    public void tc_006()  {
    //    Ana sayfadaki Log in linkini gorur
        mainPage=new MainPage();
        mainPage.logIn.isDisplayed();

    //    Log in linkini tiklar
         mainPage.logIn.click();
    }
    @Test
    public void tc_007() {
    //    Ana sayfadaki KOALARESORT logosunu gorur
        mainPage=new MainPage();
        mainPage.koalaLogo.isDisplayed();
    //    KOALARESORT logosunu tiklar
        mainPage.koalaLogo.click();
    }
    @Test
    public void tc_008() {
    //    Ana sayfadaki home linkini gorur
        mainPage=new MainPage();
        mainPage.home.isDisplayed();
     //    Home logosunu tiklar
        mainPage.home.click();
    }
}
