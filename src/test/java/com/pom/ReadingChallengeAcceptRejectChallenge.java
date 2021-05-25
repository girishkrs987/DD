package com.pom;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ReadingChallengeAcceptRejectChallenge extends CapabilitiesAndWebDriverUtils {
public ReadingChallengeAcceptRejectChallenge()  {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"You've been Challenged!\"])[1]")
private MobileElement youHaveBeenChallenged;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/challenge_name_text")
@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther/XCUIElementTypeStaticText)[2]")
private MobileElement readingChallengeName;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/challenge_read_by_text")
@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"READ BY\"]")
private MobileElement readByDateText;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/challenge_desc_text")
@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther/XCUIElementTypeStaticText)[3]")
private MobileElement description;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/profile_name_text")
@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther/XCUIElementTypeStaticText)[4]")
private MobileElement creatorName;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/illustration_image")
@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"illustrationsReadingChallenge\"]")
private MobileElement challengeicon;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/user_name_text")
@iOSXCUITFindBy(xpath="//*[@type='XCUIElementTypeCell'][1]")
private List<MobileElement> participantsList;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/ivBook")
@iOSXCUITFindBy(xpath="//*[@type='XCUIElementTypeCell'][2]")
private List<MobileElement> titleReadingChallenge;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/accept_challenge_text")
@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Accept Challenge\"]")
private MobileElement AccpetChallegeButton;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/illustration_image")
@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"No, Thanks\"]")
private MobileElement NoThanksButton;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/more_option")
private MobileElement homePageMoreIcon;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/title")
private List<MobileElement> logout;

@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Log In\"]")
private MobileElement login;


public MobileElement getYouHaveBeenChallenged() {
	return youHaveBeenChallenged;
}

public MobileElement getReadingChallengeName() {
	return readingChallengeName;
}

public MobileElement getReadByDateText() {
	return readByDateText;
}

public MobileElement getDescription() {
	return description;
}

public MobileElement getCreatorName() {
	return creatorName;
}

public MobileElement getChallengeicon() {
	return challengeicon;
}

public List<MobileElement> getParticipantsList() {
	return participantsList;
}

public List<MobileElement> getTitleReadingChallenge() {
	return titleReadingChallenge;
}

public MobileElement getAccpetChallegeButton() {
	return AccpetChallegeButton;
}

public MobileElement getNoThanksButton() {
	return NoThanksButton;
}

public MobileElement getHomePageMoreIcon() {
	return homePageMoreIcon;
}

public List<MobileElement> getLogout() {
	return logout;
}

public MobileElement getLogin() {
	return login;
}




}
