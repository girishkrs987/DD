package com.pom;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class EditChallengeUpDateRcDetailsDcreen extends CapabilitiesAndWebDriverUtils{
public EditChallengeUpDateRcDetailsDcreen()  {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
public static void editReadingChalleng() throws IOException {
//	CreateAChallengeBasicChallengeDetails.android_CreateReadingChallenge();
	ClickOnMobileElement(CreateAChallengeCreatorRCDetailsScreenMoreIcon.moreIcon);
	Assert.assertTrue(CreateAChallengeCreatorRCDetailsScreenMoreIcon.editChallenge.isDisplayed());
	logger.info("Changing challenge name");
	ClickOnMobileElement(CreateAChallengeCreatorRCDetailsScreenMoreIcon.editChallenge);
	CreateAChallengeBasicChallengeDetails.challengeName.clear();
	SendKeysOnMobileElement(CreateAChallengeBasicChallengeDetails.challengeName, getData("ercName"));
	logger.info("Changing challenge description");
	CreateAChallengeBasicChallengeDetails.description.clear();
	SendKeysOnMobileElement(CreateAChallengeBasicChallengeDetails.description, getData("ercDesc"));
	logger.info("Removing existing invitee");
	CreateAChallengeSearchAndInviteFriends.removeFriend(getData("rcinvitee"));
	logger.info("Adding new participants to challenge");
	CreateAChallengeSearchAndInviteFriends.addFriend(getData("ercinvitee"));
	CreateChallengeAddTitles.removeTitleFromChallenge();
	logger.info("Adding new titles to challenge");
	CreateChallengeAddTitles.addTitleToChallenge(getData("erctitle"));
	ClickOnMobileElement(EtrCHBtn);
}
@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/editText_challenge_name\"]")
@iOSXCUITFindBy(xpath="//*[@value='Enter Challenge Name']")
public static MobileElement ChNameTextBox;

@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/text_input_description\"]")
@iOSXCUITFindBy(xpath="//*[@value='Description (Optional)']")
public static MobileElement ChNameDescrip;

@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/add_invitees\"]")
@iOSXCUITFindBy(xpath="//*[@x='20']")
public static MobileElement ChAddInvFrds;

@AndroidFindBy(xpath =  "//*[@resource-id=\"com.follett.fss.searchread.stage:id/add_titles\"]")
@iOSXCUITFindBy(xpath="//*[@x='36']")
public static MobileElement ChAddTitles;

@AndroidFindBy(xpath =  "//*[@resource-id=\"com.follett.fss.searchread.stage:id/button_start_challenge\"]")
@iOSXCUITFindBy(xpath="//*[@x='16'']")
public static MobileElement EtrCHBtn;

@AndroidFindBy(xpath =  "//*[@resource-id=\"com.follett.fss.searchread.stage:id/button_save_challenge\"]")
@iOSXCUITFindBy(xpath="//*[@x='186']")
public static MobileElement CHSave;

@AndroidFindBy(xpath =  "//*[@resource-id=\"android:id/text1\"]")
@iOSXCUITFindBy(xpath="//*[@value='Enter Challenge Name']")
public static MobileElement SetRmdr;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/tvAddToExistingChallenge")
public static MobileElement addTOExistingChallengeBtn;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/tvIncludeInNewChallenge")
public static MobileElement includeinNewChallengeBtn;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/tvCheckout")
public static MobileElement checkoutBtn;

@AndroidFindBy(id="com.follett.fss.searchread.stage:id/tvReadOnline")
public static MobileElement readonlineBtn;



public MobileElement getChNameTextBox() {
	return ChNameTextBox;
}

public MobileElement getChNameDescrip() {
	return ChNameDescrip;
}

}

