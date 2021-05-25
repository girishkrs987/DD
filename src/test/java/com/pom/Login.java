package com.pom;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Login extends CapabilitiesAndWebDriverUtils {
	
	public Login() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void selectSchool(String Location, String SchoolName) throws IOException, InterruptedException {
		if (getData("platformName").equalsIgnoreCase("android")|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {

			logger.info("Environment and school selection ");
			SendKeysOnMobileElement(getKeyWordEnter(), getData("appEnv"));
			SendKeysOnMobileElement(getKeyWordEnter(), SchoolName);
			ClickOnMobileElement(getSelectSchoolName());
			WaitForMobileElement(btn_Continue);
			ClickOnMobileElement(btn_Continue);
			logger.info("continue button clicked");
			ClickOnMobileElement(btn_Confirmation);
			logger.info("Environment and school selection done sucessfully");
			}

		else if (getData("platformName").equalsIgnoreCase("IOS")|| getData("platformName").equalsIgnoreCase("BrowserStackIOS")) {
			waitFor(5000);
			if(IsDisplayedMobileElement(btn_Allow)) {
				logger.info("Allow button is displayed ");
				ClickOnMobileElement(btn_Allow);
				System.out.println("Allow button is displayed and given permission");
			}
			logger.info("In to Environment and School selection");
			//ClickOnMobileElement(menu);
			ClickOnMobileElement(btn_info);
			ClickOnMobileElement(testingTools);
			ClickOnMobileElement(env_DLX);
			ClickOnMobileElement(iosDone);
			SendKeysOnMobileElement(typeYourSchoolName,SchoolName);
			keyboardReturn();
			//new Actions(driver).moveToElement(selectSchoolName).click().perform();
			//System.out.println("Action Class Working ");
			//Thread.sleep(4000);
			ClickOnMobileElement(selectSchoolName);
			ClickOnMobileElement(btn_continue);
			//ClickOnMobileElement(thatsMySchool);
			ClickOnMobileElement(IOSContinue);
			logger.info("Environment and School selection done");

		}
	}

	public void login(String UserName, String Password) throws IOException, InterruptedException {

		if (getData("platformName").equalsIgnoreCase("android")|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {

			logger.info("Entering Username and password");
			SendKeysOnMobileElement(userName,UserName);
			logger.info("Entering Username");
			SendKeysOnMobileElement(password,Password);
			logger.info("Entering Password");
			ClickOnMobileElement(getSubmit());
			logger.info("Successfully Logged in ");
			if (IsDisplayedMobileElement(setPreference)) {
			logger.info("Handling Set preference display");
			ClickOnMobileElement(setPreferenceCloseIcon);
			}

		}
		else if (getData("platformName").equalsIgnoreCase("IOS")|| getData("platformName").equalsIgnoreCase("BrowserStackIOS")) {
			System.out.println("Inside IOS login ");
			logger.info("Entering Username and password");
			SendKeysOnMobileElement(userName, UserName);
			SendKeysOnMobileElement(password, Password);
			ClickOnMobileElement(submit);
			logger.info("Successfully logged in");
			if (IsDisplayedMobileElement(btn_NoThanks)) {
				ClickOnMobileElement(btn_NoThanks);
				logger.info("Selected No Thanks !");
			}
		}
	}


	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Allow']")
	public MobileElement btn_Allow;
	
	@iOSXCUITFindBy(accessibility = "iconsCoreInfo")
	public MobileElement btn_info;
	
	@iOSXCUITFindBy(accessibility = "Continue")
	public MobileElement btn_continue;
	
	@iOSXCUITFindBy(accessibility = "Start Normally")
	public MobileElement menu_StartNormally;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"location list selection\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Any Location\"]")
	private MobileElement locationList;

	@AndroidFindBy(id = "android:id/search_src_text")
	@iOSXCUITFindBy(xpath = "//*[@value='Search School name']")
	private MobileElement typeYourSchoolName;

//	@AndroidFindBy(id = "android:id/search_src_text")
	@AndroidFindBy(accessibility = "Search School Name")
//	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/school_picker_content_school_name_edit_text")
	private MobileElement keyWordEnter;

	@AndroidFindBy(xpath = "//*[@text='New York (NY)']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"New York (NY)\"]")
	private MobileElement chooseState;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"School Name\"])[2]")
	@iOSXCUITFindBy(accessibility = "Dlx BnT Digital Site, McHenry, IL")
	private MobileElement selectSchoolName;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"That's my school\"]")
	private MobileElement thatsMySchool;

	@AndroidFindBy(id = "com.android.chrome:id/terms_accept")
	private MobileElement acceptContinue;

	@AndroidFindBy(id = "com.android.chrome:id/next_button")
	private MobileElement nextButton;

	@AndroidFindBy(id = "com.android.chrome:id/negative_button")
	private MobileElement negativeButton;

	@AndroidFindBy(xpath = "//*[@resource-id='userName' and @index='2']")
	@iOSXCUITFindBy(xpath ="//*[@type='XCUIElementTypeTextField']")
	private MobileElement userName;

	@AndroidFindBy(xpath = "//*[@resource-id='userPassword' and @index='4']")
	@iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeSecureTextField']")
	private MobileElement password;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[5]/android.view.View/android.view.View/android.view.View[5]/android.widget.Button[2]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Submit'])[2]")
	private MobileElement submit;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
	private MobileElement iosDone;

	@iOSXCUITFindBy(id = "Continue")
	private MobileElement IOSContinue;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Menu\"]")
	private MobileElement menu;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"DD BookClub\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
	private MobileElement testingTools;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DLY\"]")
	private MobileElement DLY;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UAT\"]")
	private MobileElement UAT;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='DLX']")
	private MobileElement env_DLX;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='")
	public static MobileElement iosButtonPre;
	
	@iOSXCUITFindBy(xpath = "\"']")
	public static MobileElement iosButtonPost;
	
	@iOSXCUITFindBy(xpath = "(//*[@name='No, Thanks'])[2]")
	private MobileElement btn_NoThanks;
    
	@AndroidFindBy(id="com.follett.fss.searchread.stage:id/close_image")
	public static MobileElement setPreferenceCloseIcon;
	    
	@AndroidFindBy(id="com.follett.fss.searchread.stage:id/tvTitle")
	public static MobileElement setPreference;
	
	@AndroidFindBy(id="com.follett.fss.searchread.stage:id/noThanksBt")
	public static MobileElement setPreferenceNoThanksBtn;
	
	@AndroidFindBy(id="com.follett.fss.searchread.stage:id/saveInterestBt")
	public static MobileElement setPreferenceSaveBtn;
	
	@AndroidFindBy(id="com.follett.fss.searchread.stage:id/school_picker_content_continue_button")
	public static MobileElement btn_Continue;

	@AndroidFindBy(xpath = "//android.widget.Button[@text =\"CONTINUE\"]")
	public static MobileElement btn_Confirmation;
	
	public MobileElement getIosDone() {
		return iosDone;
	}

	public MobileElement getUAT() {
		return UAT;
	}

	public MobileElement getLocationList() {
		return locationList;
	}

	public MobileElement getTypeYourSchoolName() {
		return typeYourSchoolName;
	}

	public MobileElement getKeyWordEnter() {
		return keyWordEnter;
	}

	public MobileElement getChooseState() {
		return chooseState;
	}

	public MobileElement getSelectSchoolName() {
		return selectSchoolName;
	}

	public MobileElement getThatsMySchool() {
		return thatsMySchool;
	}

	public MobileElement getAcceptContinue() {
		return acceptContinue;
	}

	public MobileElement getNextButton() {
		return nextButton;
	}

	public MobileElement getNegativeButton() {
		return negativeButton;
	}

	public MobileElement getUserName() {
		return userName;
	}

	public MobileElement getPassword() {
		return password;
	}

	public MobileElement getSubmit() {
		return submit;
	}

	public MobileElement getIOSContinue() {
		return IOSContinue;
	}

	public MobileElement getMenu() {
		return menu;
	}

	public MobileElement getTestingTools() {
		return testingTools;
	}

	public MobileElement getDLY() {
		return DLY;
	}

}
