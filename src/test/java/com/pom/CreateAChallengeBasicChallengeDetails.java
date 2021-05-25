package com.pom;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CreateAChallengeBasicChallengeDetails extends CapabilitiesAndWebDriverUtils {

	
	public CreateAChallengeBasicChallengeDetails() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public static void android_CreateReadingChallenge() throws IOException {
		
		logger.info("Validating the Page Header Text");
		Assert.assertTrue(lbl_CreateChallengeHeader.isDisplayed());
		Assert.assertTrue(lbl_CreateChallengeHeader.getText().contains("Create Challenge"));
		Assert.assertTrue(challengeName.isDisplayed());
		Assert.assertTrue(challengeName.getText().contains("Enter Challenge Name"));
		logger.info("Entering Challenge Name");
		SendKeysOnMobileElement(challengeName,challengeName());
		Assert.assertTrue(challenegeNameTextCount.isDisplayed());
		Assert.assertTrue(description.getText().contains("Description (Optional)"));
		logger.info("Entering Challenge Description");
		SendKeysOnMobileElement(description, getData("rcDesc"));
		Assert.assertTrue(challenegeDescTextCount.isDisplayed());
		Assert.assertTrue(inviteText.isDisplayed());
		Assert.assertTrue(inviteText.getText().contains("INVITE FRIENDS"));
		logger.info("Adding Friend to the challenge");
		CreateAChallengeSearchAndInviteFriends.addFriend(getData("rcinvitee"));
		Assert.assertTrue(setReminderText.isDisplayed());
		Assert.assertTrue(setReminderText.getText().contains("Set Reminders"));
		logger.info("Setting Reminder for the challenge");
		CreateChallengeSetReminders.androidSetReminder();
		Assert.assertTrue(setReadByText.isDisplayed());
		Assert.assertTrue(setReadByText.getText().contains("Set Read by Date"));
		logger.info("Setting end date for the challenge");
		CreateAChallengeSetReadbyDate.androidSetReadByDate();
		swipeDown();
		logger.info("Tapping on add titile CTA");
		CreateChallengeAddTitles.addTitleToChallenge(getData("rctitle"));
		isEnabled(startChallengeBtn);
		ClickOnMobileElement(startChallengeBtn);	
		isToastMessageDisplayed("Challenge Created Successfully");
		Assert.assertEquals(fluentWaitDisplayed(CreateAChallengeCreatorRCDetailsScreen.readImage, 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(CreateAChallengeCreatorRCDetailsScreen.challengeName, 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(CreateAChallengeCreatorRCDetailsScreen.challengeDesc, 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(CreateAChallengeCreatorRCDetailsScreen.readByDateValue, 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(CreateAChallengeCreatorRCDetailsScreen.reminderValue, 30, 2), true);
}
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/challenge_title_edit_text\"]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView['index=1'][1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"CC_EnterChallengeName\"]")
	public static MobileElement challengeName;
	
	@AndroidFindBy(id="com.follett.fss.searchread.stage:id/nav_toolbar_center_title")
	public static MobileElement lbl_CreateChallengeHeader;
	

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/challenge_details_edit_text")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView['index=1'][2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"CC_EnterChallengeDescription\"]")
	public static MobileElement description;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/title_invite_friends\"])[8]")
	@iOSXCUITFindBy(id = "INVITE FRIENDS")
	public static MobileElement inviteText;

//	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/add_invitees\"])[1]")
	@AndroidFindBy(xpath ="//*[@resource-id=\"com.follett.fss.searchread.stage:id/ic_remove_users\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add\"]")
	public static MobileElement addFriendCTA;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/title_set_remainder\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Set Reminder\"]")
	public static MobileElement setReminderText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 2 pages\"]")
	public static MobileElement setReminderOptions;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PV_Done\"]")
	public static MobileElement iosDoneBtn;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Photon\"]")
	public static MobileElement iosAddedFriendCreateChallengepage;

	@AndroidFindBy(xpath = "//*[@resource-id='com.follett.fss.searchread.stage:id/spinner_item_text']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='CC_SetReminderText']")
	public static MobileElement setReminderOpt;
	
	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/title_set_read_by_date\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Set Read By Date\"]")
	public static MobileElement setReadByText;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/value_date_picker\"])[1]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CalendarIcon\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CC_SetDate']")
	public static MobileElement dateOpt;

	//@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CC_DatePickerDone\"]")
	@iOSXCUITFindBy(xpath = "//*[@label='Done']")
	public static MobileElement iosDontBtn;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/title_add_titles\"])[1]")
	@iOSXCUITFindBy(id = "ADD TITLES")
	public static MobileElement addTitlesText;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"ADD TITLES\"]")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"CC_AddOrRemoveTitle\"]")
	public static MobileElement addTitlesCTA;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/button_start_challenge\"])[1]")
	@iOSXCUITFindBy(xpath= "//*[@name=\"CC_StartChallenge\"]")
	public static MobileElement startChallengeBtn;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/button_save_challenge\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Save\"]")
	public static MobileElement saveChallengeBtn;

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/book_club_toolbar_right_action_button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Menu\"]")
	public static MobileElement deleteBtn;

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/book_club_navigation_icon")
	@iOSXCUITFindBy(id = "Book Club")
	public static MobileElement backBtn;

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/ivBook")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CC_AddOrRemoveTitle\"])")
	public static MobileElement addedBook;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='RemoveItemMedium']")
	public static MobileElement TitesRemoveBtn;
	
	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/ivBook")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CC_AddOrRemoveTitle\"])[2]")
	public static List<MobileElement> addedBooks;
	
	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/tv_header_desc")
	public static List<MobileElement> challengeNameList;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Smoke May06\"))")
	@iOSXCUITFindBy(xpath= "//*[@name=\"AutomationTesting\"]")
	public static MobileElement searchChallengeName;
	
	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/ic_remove_users")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CC_AddOrRemoveFriend\"])")
	public static List<MobileElement> removeFriendXIcon;
	
	@AndroidFindBy(id ="com.follett.fss.searchread.stage:id/ivUsers")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Photon\"])[1]")
	public static List<MobileElement> addedFriendavatarList;
	
	@AndroidFindBy(id ="com.follett.fss.searchread.stage:id/txt_user_name")
	public static List<MobileElement> addedFriendNameList;
	
	@AndroidFindBy(id ="com.follett.fss.searchread.stage:id/remove_friend_remove_button")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Remove\"]")
	public static MobileElement friendRemoveButton;
	
	@AndroidFindBy(id ="com.follett.fss.searchread.stage:id/remove_friend_cancel_button")
	public static MobileElement friendCancelButton;
	
	@AndroidFindBy(id ="com.follett.fss.searchread.stage:id/ic_remove_titles")
	public static List<MobileElement> removeTitleXIcon;
	
	@AndroidFindBy(id ="com.follett.fss.searchread.stage:id/remove_book_remove_button")
	public static MobileElement titleRemoveButton;
	
	@AndroidFindBy(id ="com.follett.fss.searchread.stage:id/remove_friend_cancel_button")
	public static MobileElement titleCancelButton;
	
	@AndroidFindBy(id="com.follett.fss.searchread.stage:id/challenge_title_count_text")
	public static MobileElement challenegeNameTextCount;
	
	@AndroidFindBy(id="com.follett.fss.searchread.stage:id/challenge_details_count_text")
	public static MobileElement challenegeDescTextCount;
	
	public MobileElement getTitesRemoveBtn() {
		return TitesRemoveBtn;
	}

	public MobileElement getSearchChallengeName(String challangeName) {
		return searchChallengeName;
	}

	public List<MobileElement> getChallengeNameList() {
		return challengeNameList;
	}

	public MobileElement getChallengeName() {
		return challengeName;
	}

	public List<MobileElement> getAddedBooks() {
		return addedBooks;
	}
	
	public MobileElement getAddedBook() {
		return addedBook;
	}

	public MobileElement getDescription() {
		return description;
	}

	public MobileElement getInviteText() {
		return inviteText;
	}

	public MobileElement getAddFriendCTA() {
		return addFriendCTA;
	}

	public MobileElement getSetReminderText() {
		return setReminderText;
	}

	public MobileElement getSetReminderOptions() {
		return setReminderOptions;
	}

	public MobileElement getIosDoneBtn() {
		return iosDoneBtn;
	}

	public MobileElement getSetReminderOpt() {
		return setReminderOpt;
	}

	public MobileElement getSetReadByText() {
		return setReadByText;
	}

	public MobileElement getDateOpt() {
		return dateOpt;
	}

	public MobileElement getIosDontBtn() {
		return iosDontBtn;
	}

	public MobileElement getAddTitlesText() {
		return addTitlesText;
	}

	public MobileElement getDeleteBtn() {
		return deleteBtn;
	}

	public MobileElement getBackBtn() {
		return backBtn;
	}

	public MobileElement getIosAddedFriendCreateChallengepage() {
		return iosAddedFriendCreateChallengepage;
	}

	public MobileElement getAddTitlesCTA() {
		return addTitlesCTA;
	}

	public MobileElement getStartChallengeBtn() {
		return startChallengeBtn;
	}

	public MobileElement getSaveChallengeBtn() {
		return saveChallengeBtn;
	}

}
