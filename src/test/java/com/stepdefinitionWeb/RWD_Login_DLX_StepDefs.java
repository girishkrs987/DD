package com.stepdefinitionWeb;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.Login;
import com.pom_RWD.Login_RWD;
import com.pom_RWD.RWD_BookClubLandingScreen;
import com.pom_RWD.RWD_CreateaChallenge_AddTitles;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class RWD_Login_DLX_StepDefs extends CapabilitiesAndWebDriverUtils  {

   Login_RWD login_RWD = new Login_RWD();

//    public void loginRWD(String UserName, String Password) throws IOException {
//
//        if (getData("platformName").equalsIgnoreCase("android")|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
//
//            fluentWaitEnter(getUserName(), 30, 2, UserName);
//            fluentWaitEnter(getPassword(), 30, 2, Password);
//            swipeDown();
//            fluentWaitClick(getSubmit(), 30, 2);
//
//        }
//        else if (getData("platformName").equalsIgnoreCase("IOS")|| getData("platformName").equalsIgnoreCase("BrowserStackIOS")) {
//
//            userName.click();
//            userName.sendKeys(UserName);
//            password.click();// browser stack we need click
//            password.sendKeys(Password);
//            hideMobileKeyboard();
//            submit.click();
//        }
//
//    }

    @Given("User is logged in user name {string} and password on DLX env")
    public void userIsLoggedInDLX(String user) throws InterruptedException, IOException {
        String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
        System.out.println(uAgent);
        String username =getData(user); String password = user;
        if(IsDisplayedWebElement(login_RWD.getRWD_DLX_Login_button()))
        {System.out.println("DLX login page is shown");
        ClickOnWebElement(login_RWD.getRWD_DLX_Login_button());
            if(IsDisplayedWebElement(login_RWD.getRWD_DLX_UserName()))
            {
                login_RWD.getRWD_DLX_UserName().sendKeys(username);
                waitFor(500);
                System.out.println("DLX login , Username entered");
                login_RWD.getRWD_DLX_Password().sendKeys(username);
                waitFor(500);
                System.out.println("DLX login , Password entered");
                ClickOnWebElement(login_RWD.getRWD_DLX_Submit());
                System.out.println("DLX login , Submit clicked ");
                waitFor(1000);
                ClickOnWebElement(login_RWD.getRWD_DLX_Hambugermenu());
                System.out.println("DLX login , Clicked Hamburgermenu");
                ClickOnWebElement(login_RWD.getRWD_DD_BookClub());
                System.out.println("DLX login , Clicked DD Book Club");
                waitFor(1000);

            }else
            {
                System.out.println("DLX login username and password page is not shown");
                Assert.assertFalse("DLX login username and password page is not shown",true);

            }

        }
        else
        {
            System.out.println("DLX login page is not shown");
            Assert.assertFalse("DLX login page is not shown",true);

        }

    }



}
