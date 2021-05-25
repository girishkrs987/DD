package com.run;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.CapabilitiesAndWebDriverUtils;
import com.base.JvmReportMobile;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features= {"Smoke"},
		glue= {"com.stepdefinition"},
		monochrome=true,
		dryRun=false,
		tags= {"@TC17"},
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/ResultsMobile/cucumber.json",
	"rerun:FailedTestCases\\failed.txt","pretty"})

//@TC02,@TC06,@TC11,@TC14,@TC15,@TC16,@TC17,@TC19,@TC19_1,@TC41,@TC43,@TC45,@TC99,@TC100,@TC101,@TC103,@TC105,@TC90,@TC92,@TC93,@TC94,@TC95,@TC86,TC89,@TC74,@TC75,@TC52,@TC55,@TC56,@TC60,@TC61,@TC65,@TC31,@TC36,@TC39,@TC107,@TC122

public class RunnerClass extends CapabilitiesAndWebDriverUtils{
	 @AfterClass         
	   public static void afterClass() throws IOException {                 
		   JvmReportMobile.generateReport(System.getProperty("user.dir")+"/target/ResultsMobile/cucumber.json");     
		   
		   }
}