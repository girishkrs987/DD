package com.pom;

import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ReadingChallengeReportAbuse extends CapabilitiesAndWebDriverUtils {

	public ReadingChallengeReportAbuse() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


@AndroidFindBy(id = "com.follett.fss.searchread.develop:id/sub_title_text")
@iOSXCUITFindBy(accessibility ="Please provide details about your concern regarding the Reading Challenge.")
public static MobileElement viewBriefDescription;

@AndroidFindBy(id = "com.follett.fss.searchread.develop:id/report_edit_text")
@iOSXCUITFindBy(xpath="//*[@height='251']")
public static  MobileElement reportEditText;

@AndroidFindBy(id = "com.follett.fss.searchread.develop:id/submit_text")
@iOSXCUITFindBy(xpath="//*[@value='Submit']")
public static  MobileElement submitButton;

@AndroidFindBy(id = "com.follett.fss.searchread.develop:id/back_icon")
@iOSXCUITFindBy(accessibility="NavigationBackButton")
public static MobileElement backIcon;

@iOSXCUITFindBy(xpath="//*[@name=\"Report Abuse\"]")
public static MobileElement reportAbuse;

@iOSXCUITFindBy(accessibility="Leave Challenge")
public static MobileElement leaveChallenge;

@iOSXCUITFindBy(accessibility="Cancel")
public static MobileElement cancel;

@iOSXCUITFindBy(xpath ="//*[@value='Enter your concern']")
public static MobileElement enterconcernTxtBox;

@iOSXCUITFindBy(xpath="//*[@name=\"Report Abuse\"]")
public static MobileElement reportAbuseHeader;

@iOSXCUITFindBy(xpath="//*[@name='iconsCoreRemove']")
public static MobileElement moreIcon;

@iOSXCUITFindBy(xpath="//*[@type='XCUIElementTypeTextView']")
public static MobileElement textboxclear;


public MobileElement getViewBriefDescription() {
	return viewBriefDescription;
}

public MobileElement getReportEditText() {
	return reportEditText;
}

public MobileElement getSubmitButton() {
	return submitButton;
}

public MobileElement getBackIcon() {
	return backIcon;
}

}
