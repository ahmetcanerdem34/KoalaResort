package com.techproed.tests;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginPozitif_Ahmet extends TestBase {
    LoginPage loginPage;
    @Test
    public void test01(){
        extentTest=extentReports.createTest("Smoke", "Gecerli bilgilerle room creation pozitif test");
        loginPage=new LoginPage();
        loginPage.loginTest();
        //Sağ üst kösede `manager` yazısı görülmelidir
        Assert.assertTrue(loginPage.manager.isDisplayed(), "Maneger Yazısı Göründü");
        extentTest.pass("Koala Resort Hotel sayfasinda dogru bilgilerle manager yazisinin goruldugu test edildi");
        // Driver.closeDriver();
    }
}