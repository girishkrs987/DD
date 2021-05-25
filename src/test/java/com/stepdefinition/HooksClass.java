package com.stepdefinition;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.base.CapabilitiesAndWebDriverUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

public class HooksClass extends CapabilitiesAndWebDriverUtils {

	Scenario scenario;
	String screenshotdir = System.getProperty("user.dir") + "/target/test-output/Screenshots/";

	@Before
	public void beforMethodSetUp(Scenario scenario) throws Throwable {
		this.scenario = scenario;
		if ((new File(screenshotdir)).exists())
			FileUtils.cleanDirectory(new File(screenshotdir));
		
		appiumStart();
		System.out.println("Get In To Invoke app");
		initiateNativeAPP();

	}

	@AfterStep
	public void attach_screenshot(Scenario scenario) throws Throwable {
		if (scenario.isFailed()) {
			// ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getBase64Screenshot(driver,screenshotdir));
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");

		}

	}

	@After
	public void tearDown(Scenario s) throws Exception {
			driver.quit();
	}

}
