package com.pom;

import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CreateAChallengeCreatorRCDetailsScreen extends CapabilitiesAndWebDriverUtils{
public CreateAChallengeCreatorRCDetailsScreen() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/profile_image\"])[1]")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeApplication[@name=\"DD BookClub\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther[1]")
	public static  MobileElement creatorAvatar;
	
	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/created_date_text\"])[1]")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"CREATED 08/04/2021\"]")
	public static  MobileElement createDate;

	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/profile_name_text\"]")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Jennifer Piazza\"]")
	public static  MobileElement creatorName;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/challenge_readby_text\"]")
	@iOSXCUITFindBy(xpath="//*[@name=\"READ BY\"]")
	public static MobileElement readByDate;

//	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/challenge_readby_text\"]")
	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/tv_readby_label")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"READING CHALLENGE: READ BY 08/04/2021\"]")
	public static  MobileElement readByDateText;
	
	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/tv_readby_date")
	public static  MobileElement readByDateValue;
	
	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/tv_reminders_label")
	public static  MobileElement reminderText;
	
	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/tv_reminders")
	public static  MobileElement reminderValue;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/challenge_name_text\"]")
	@iOSXCUITFindBy( xpath="(//XCUIElementTypeStaticText[@name=\"AutomationMobile\"])[2]")
	public static MobileElement challengeName;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/description_text\"]")
	@iOSXCUITFindBy(xpath="//*[@name='automation ios mobile testing description']")
	public static MobileElement challengeDesc;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/illustration_image\"]")
	@iOSXCUITFindBy(xpath="//*[@name=\"ChallengeProfileIconMedium\"]")
	public static MobileElement readImage;
	
	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/leaderboard_profile_image\"])[1]")
	public static  MobileElement leaderAvatar;
	
	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/leaderboard_name_text\"])[1]")
	@iOSXCUITFindBy(id="Henry")
	public static  MobileElement leaderName;
	
	@AndroidFindBy(xpath = "ett.fss.searchread.stage:id/leaderboard_perc_text\"])[1]")
	@iOSXCUITFindBy(xpath="82%")
	public static  MobileElement leaderpercent;
	
	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/rc_book_image\"])[1]")
	public static  MobileElement readListBook;
	
	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/read_progressBar\"])[1]")
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeProgressIndicator[@name=\"Progress\"])[1]")
	public static  MobileElement readProgressBar;
	
	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/progress_Percentage_text\"])[1]")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"50%\"]")
	public static  MobileElement readProgressPercent;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='IN'])[1]")
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"IN\"])[3]")
	public static  MobileElement readIn;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='IN'])[1]")
	public static  MobileElement readInImage;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/more_option\"]")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Menu\"]")
	public static  MobileElement moreIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Reading List\"]")
	public static  MobileElement iosreadingListText;
	
	@iOSXCUITFindBy(xpath="noReadingChallenge")
	public static  MobileElement iosreadingChallengeImage;
	
	@iOSXCUITFindBy(xpath="//*[@type='XCUIElementTypeButton'][1]")
	public static MobileElement backBtn;
	
	@iOSXCUITFindBy(xpath="//*[@type='XCUIElementTypeButton'][2]")
	public static MobileElement moreBtn;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeButton[@name=\"controlsButtonsCardsMore\"])[1]")
	public static MobileElement IOScontrolButtton;
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeApplication[@name=\"DD BookClub\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]")
	public static  MobileElement iosParticipantsList; //need to update android locator
	
	
	public MobileElement getIosParticipantsList() {
		return iosParticipantsList;
	}

	public MobileElement getIosreadingListText() {
		return iosreadingListText;
	}

	public MobileElement getIosreadingChallengeImage() {
		return iosreadingChallengeImage;
	}

	public MobileElement getIOScontrolButtton() {
		return IOScontrolButtton;
	}

	public MobileElement getCreatorAvatar() {
		return creatorAvatar;
	}

	public MobileElement getCreateDate() {
		return createDate;
	}

	public MobileElement getCreatorName() {
		return creatorName;
	}

	public MobileElement getReadByDate() {
		return readByDateText;
	}

	public MobileElement getChallengeName() {
		return challengeName;
	}

	public MobileElement getChallengeDesc() {
		return challengeDesc;
	}

	public MobileElement getReadImage() {
		return readImage;
	}

	public MobileElement getLeaderAvatar() {
		return leaderAvatar;
	}

	public MobileElement getLeaderName() {
		return leaderName;
	}

	public MobileElement getLeaderpercent() {
		return leaderpercent;
	}

	public MobileElement getReadListBook() {
		return readListBook;
	}

	public MobileElement getReadProgressBar() {
		return readProgressBar;
	}

	public MobileElement getReadProgressPercent() {
		return readProgressPercent;
	}

	public MobileElement getReadIn() {
		return readIn;
	}

	public MobileElement getReadInImage() {
		return readInImage;
	}

	public MobileElement getMoreIcon() {
		return moreIcon;
	}
	
	// 
	
	
	
	
}
