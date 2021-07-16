package com.techproed.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;
import com.techproed.pages.Register;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    protected static ExtentHtmlReporter extentHtmlReporter;
    @BeforeTest(alwaysRun = true)
    public void setUpTest() {
        //BeforeTest will run only once before all test.
        //1. create object to set the location of the report
        //1. create object to set the location of the report
        extentReports = new ExtentReports();
        //create a custom report in the current project.
        String filePath = System.getProperty("user.dir") + "/test-output/Rapor.html";
        //Folder name = test-output, File name = report.html
        //String filePath = System.getProperty("user.dir") + "\\test-output\\report.html";//THIS IS FOR WINDOWS USER
        //2. creating the report with the path we created
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        //3. attaching the html report to our custom report
        extentReports.attachReporter(extentHtmlReporter);
        //WE CAN ADD CUSTOM INFO. NOT NECESSARY. JUST TO GIVE MORE INFORMATION TO THE USER OR TEAM
        extentReports.setSystemInfo("Environment", "QA Environment");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Automation Engineer", "Team-1");
        extentHtmlReporter.config().setDocumentTitle("KoalaResort Reports");
        extentHtmlReporter.config().setReportName("KoalaResort Automation Reports");



    }

    @BeforeMethod(alwaysRun = true)
    public void setupMethod() {
<<<<<<< HEAD
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
=======
        //Creating Driver, and going to the application Login URL before each method
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("kr_url"));
        extentTest=extentReports.createTest("KoalaResort extendReportsTest");
>>>>>>> master

    }


    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result)  {

        Driver.closeDriver();
    }

}