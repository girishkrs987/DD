package com.stepdefinition;

import java.io.IOException;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.time.StopWatch;
import org.apache.velocity.runtime.directive.Stop;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.base.CapabilitiesAndWebDriverUtils;
import com.google.common.collect.ImmutableMap;
import com.pom.Login;

import cucumber.api.event.WriteEvent;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Login_StepDef extends CapabilitiesAndWebDriverUtils {
	Login login = new Login();

	@Given("Launch the  Application")
	public void launch_the_Application() throws IOException {
		

	}

	@When("Click location dropdown and enter the location and enter the school Name {string} and {string}")
	public void click_location_dropdown_and_enter_the_location_and_enter_the_school_Name_and(String Location,
			String SchoolName) throws IOException, InterruptedException {
		
		login.selectSchool(Location, SchoolName);

	}

	@When("Enter the User Name and Password {string} and {string} click submit button")
	public void enter_the_User_Name_and_Password_and_click_submit_button(String UserName, String Password)
			throws InterruptedException, IOException {
		
			login.login(UserName, Password);

	}
	
}
