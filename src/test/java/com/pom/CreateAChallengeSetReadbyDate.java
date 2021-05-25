package com.pom;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CreateAChallengeSetReadbyDate extends CapabilitiesAndWebDriverUtils {
public CreateAChallengeSetReadbyDate()  {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

public static void setReadByDate() {
	
	ClickOnMobileElement(CreateAChallengeBasicChallengeDetails.dateOpt);
	SendKeysOnMobileElementList(iOSDate.get(0), "April");
	SendKeysOnMobileElement(ioDate, "25");
	SendKeysOnMobileElement(iosYear, "2021");
	ClickOnMobileElement(CreateAChallengeBasicChallengeDetails.iosDontBtn);
	Assert.assertEquals(fluentWaitDisplayed(iosEndDate, 30, 2), true);
	
	
}
public static void androidSetReadByDate() {
	
	ClickOnMobileElement(CreateAChallengeBasicChallengeDetails.dateOpt);
	ClickOnMobileElement(CreateAChallengeSetReadbyDate.nextMonthBtn);
	ClickOnMobileElement(CreateAChallengeSetReadbyDate.endDate);
	ClickOnMobileElement(CreateAChallengeSetReadbyDate.calenderIconOK);
	Assert.assertEquals(fluentWaitDisplayed(CreateAChallengeBasicChallengeDetails.dateOpt, 20, 2), true);
}

@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.follett.fss.searchread.stage:id/value_date_picker\"]")
public static MobileElement calenderIcon;

@AndroidFindBy(xpath = "//*[@resource-id=\"android:id/button1\"]")
public static MobileElement calenderIconOK;

@AndroidFindBy(xpath = "//*[@resource-id=\"android:id/button2\"]")
public static MobileElement calenderIconCancel;

@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id=\"android:id/next\"]")
public static MobileElement nextMonthBtn;

@AndroidFindBy(xpath = "//android.view.View[@text=\"15\"]")
public static MobileElement endDate;

@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Set read by date\"]")
public static MobileElement iosSetReadByDateText;

@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"iconsInsightsDays\"]")
public static MobileElement iosCalender;

@iOSXCUITFindBy(xpath="//*[@value='May 25, 2021']")
public static MobileElement iosEndDate;

@iOSXCUITFindBy(xpath="//*[@type='XCUIElementTypePickerWheel']")
public static List<MobileElement> iOSDate;

@iOSXCUITFindBy(xpath="//*[@type='XCUIElementTypePickerWheel'][1]")
public static MobileElement ioDate;

@iOSXCUITFindBy(xpath="xpath=//*[@type='XCUIElementTypePickerWheel'][3]")
public static MobileElement iosYear;



public MobileElement getCalenderIcon() {
	return calenderIcon;
}

public MobileElement getCalenderIconOK() {
	return calenderIconOK;
}

public MobileElement getCalenderIconCancel() {
	return calenderIconCancel;
}

public MobileElement getNextMonthBtn() {
	return nextMonthBtn;
}

public MobileElement getEndDate() {
	return endDate;
}
//
//public List<MobileElement> getIosMonth() {
//	return iosDate;
//}

public MobileElement getIoDate() {
	return ioDate;
}

public MobileElement getIosYear() {
	return iosYear;
}

public MobileElement getIosSetReadByDateText() {
	return iosSetReadByDateText;
}

public MobileElement getIosCalender() {
	return iosCalender;
}

public MobileElement getIosEndDate() {
	return iosEndDate;
}



}
