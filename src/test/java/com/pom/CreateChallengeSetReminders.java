package com.pom;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CreateChallengeSetReminders extends CapabilitiesAndWebDriverUtils {
	
public CreateChallengeSetReminders()  {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

public static void iosSetReminder() {

		ClickOnMobileElement(CreateAChallengeBasicChallengeDetails.setReminderOpt);
		SendKeysWithoutClear(iosRemainderOptions, "Weekly");
		String actualremainder = iosRemainderOptions.getText();
		ClickOnMobileElement(CreateAChallengeBasicChallengeDetails.iosDoneBtn);
		String expectedremainder = addedremainderinccpage.getText();
		Assert.assertEquals(actualremainder, expectedremainder);
	}
public static void androidSetReminder() {
	swipeDown();
	ClickOnMobileElement(CreateAChallengeBasicChallengeDetails.setReminderOpt);
	String actualremainder = dailyOption.getText();
	ClickOnMobileElement(dailyOption);
	String expectedremainder = addedremainderinccpage.getText();
	Assert.assertEquals(actualremainder, expectedremainder);
}
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Weekly']")
	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/spinner_item_text")
	public static MobileElement addedremainderinccpage;
	
	@AndroidFindBy(xpath = "com.follett.fss.searchread.stage:id/spinner_item_text")
	public static List<MobileElement> reminderOptionList;

//	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"None\"]")
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")
	public static MobileElement noneOption;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
	public static MobileElement dailyOption;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")
	public static MobileElement weeklyOption;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]")
	public static MobileElement monthlyOption;
	
	@iOSXCUITFindBy(xpath="//*[@type='XCUIElementTypePickerWheel']")
	public static MobileElement iosRemainderOptions;
		
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/alertTitle\"]")
	public static MobileElement chooseOneText;

//	public List<MobileElement> getIosRemainderOptions() {
//		return iosRemainderOptions;
//	}

	public MobileElement getNoneOption() {
		return noneOption;
	}

	public MobileElement getDailyOption() {
		return dailyOption;
	}

	public MobileElement getWeeklyOption() {
		return weeklyOption;
	}

	public MobileElement getMonthlyOption() {
		return monthlyOption;
	}

	
	public MobileElement getChooseOneText() {
		return chooseOneText;
	}

}
