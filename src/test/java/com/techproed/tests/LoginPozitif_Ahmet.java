package com.techproed.tests;

import com.techproed.pages.LoginPage;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPozitif_Ahmet {

            LoginPage loginPage=new LoginPage();


    @Test
            public void test01(){

        loginPage.loginTest();

            //Sağ üst kösede `manager` yazısı görülmelidir
            Assert.assertTrue(loginPage.manager.isDisplayed(), "Maneger Yazısı Göründü");

            Driver.closeDriver();



    }
}
