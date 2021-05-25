package com.stepdefinition;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeCreatorRCDetailsScreen;
import com.pom.CreateAChallengeInviteRecentlySearchedFriends;
import com.pom.CreateAChallengeSearchTitleResultsTileView;
import com.pom.CreateAChallengeSetReadbyDate;
import com.pom.CreateChallengeAddTitles;
import com.pom.CreateChallengeSearchTitleResultsMoreCTA;
import com.pom.CreateChallengeSetReminders;
import com.pom.CreateaChallengeSearchTitleResultsListView;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CreateAChallenge_ChallengeUpdation_StepDef extends CapabilitiesAndWebDriverUtils {

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeInviteRecentlySearchedFriends searchfriends = new CreateAChallengeInviteRecentlySearchedFriends();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateAChallengeCreatorRCDetailsScreen creatorRCDetailsScreeen = new CreateAChallengeCreatorRCDetailsScreen();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateAChallengeSearchTitleResultsTileView searchResultTileView = new CreateAChallengeSearchTitleResultsTileView();
	CreateChallengeSearchTitleResultsMoreCTA searchResultMoreCTA = new CreateChallengeSearchTitleResultsMoreCTA();

	@Then("User should on book club option and navigated to the Create Challenge Screen")
	public void user_should_on_book_club_option_and_navigated_to_the_Create_Challenge_Screen() {
		ClickOnMobileElement(bookClubLandingScreeen.getBookClubOption());
		Assert.assertEquals(fluentWaitDisplayed(bookClubLandingScreeen.getChallenges(), 30, 2), true);
		fluentWaitDisplayed(bookClubLandingScreeen.getChallenges(), 30, 2);
		logger.info("Tapping Create Challenge CTA");
		ClickOnMobileElement(bookClubLandingScreeen.getAddCTA());
		logger.info("Ëntering create challenge page");
	}

	@Then("Check that user should be able to enter the Challenge name and view the character count below the field")
	public void check_that_user_should_be_able_to_enter_the_Challenge_name_and_view_the_character_count_below_the_field()
			throws IOException {
		SendKeysOnMobileElement(createBasicChallenge.getChallengeName(),getData("rcName"));
		Assert.assertTrue(createBasicChallenge.challenegeNameTextCount.isDisplayed());
		logger.info("Challenge name text count displayed");
	}

	@Then("Check that user able to enter challenge description and view the character count below the field")
	public void check_that_user_able_to_enter_challenge_description_and_view_the_character_count_below_the_field()
			throws IOException {
		SendKeysOnMobileElement(createBasicChallenge.getDescription(), getData("rcDesc"));
		Assert.assertTrue(createBasicChallenge.challenegeDescTextCount.isDisplayed());
		logger.info("Challenge desc text count displayed");
	}

	@Then("Check that user able to see X icon on each participents avatar and able to tap on X icon")
	public void check_that_user_able_to_see_X_icon_on_each_participents_avatar_and_able_to_tap_on_X_icon()
			throws IOException {
		ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
		SendKeysOnMobileElement(searchfriends.getSearchBox(),getData("SearchFriendInput"));
		logger.info("searching friend to add");
		List<MobileElement> inviteopt = CreateAChallengeInviteRecentlySearchedFriends.inviteOptionList;
		for (int i = 0; i < inviteopt.size(); i++) {
			inviteopt.get(i).click();
		}
		logger.info("adding friend to challenge");
		ClickOnMobileElement(searchfriends.getAddToChallenge());
		List<MobileElement> removeFriendXIcon = createBasicChallenge.removeFriendXIcon;
		for (int i = removeFriendXIcon.size() - 1; i >= 1; i--) {
			Assert.assertTrue(createBasicChallenge.removeFriendXIcon.get(i).isDisplayed());
		}
		logger.info("Checking X icon in friend avatar");
		for (int i = removeFriendXIcon.size() - 1; i >= 1; i--) {
			createBasicChallenge.removeFriendXIcon.get(i).click();
			break;
		}
	}

	@Then("Check that user able to view the remove friend confirmation model")
	public void check_that_user_able_to_view_the_remove_friend_confirmation_model() {
		Assert.assertTrue(CreateAChallengeBasicChallengeDetails.friendRemoveButton.isDisplayed());
		Assert.assertTrue(CreateAChallengeBasicChallengeDetails.friendCancelButton.isDisplayed());
		logger.info("Remove friend confirmation modal validation");
	}

	@Then("Tap on Remove CTA")
	public void tap_on_Remove_CTA() {
		CreateAChallengeBasicChallengeDetails.friendRemoveButton.click();
		logger.info("Remove friend from challenge");
	}

	@Then("Tap on Cancel CTA")
	public void tap_on_Cancel_CTA() {
		List<MobileElement> removeFriendXIcon = createBasicChallenge.removeFriendXIcon;
		for (int i = removeFriendXIcon.size() - 1; i >= 1; i--) {
			createBasicChallenge.removeFriendXIcon.get(i).click();
			break;
		}
		Assert.assertTrue(CreateAChallengeBasicChallengeDetails.friendRemoveButton.isDisplayed());
		Assert.assertTrue(CreateAChallengeBasicChallengeDetails.friendCancelButton.isDisplayed());
		CreateAChallengeBasicChallengeDetails.friendCancelButton.click();
	}

	@Then("Check that user able to view the titles added in the form of carousel")
	public void check_that_user_able_to_view_the_titles_added_in_the_form_of_carousel() throws IOException {
		swipeDown();
		ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
		SendKeysOnMobileElement(searchTitles.searchTextBox, getData("Searchinput3"));
		waitFor(5000);
//		searchTitles.searchTextBox.sendKeys(Keys.ENTER);
//		((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.ENTER);
		logger.info("Validating Search Suggestion");
		List<MobileElement> suggResult = searchTitles.getTitleSearchResult();
		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			if (suggResult.size() > 0) {
				for (int i = 0; i < suggResult.size(); i++) {
					suggResult.get(i).click();
					break;
				}
				Assert.assertEquals(true, fluentWaitDisplayed(searchTitles.getIosdoneBtn(), 30, 2));
				Assert.assertEquals(fluentWaitDisplayed(searchTitles.getIosgridView(), 30, 2), true);
				Assert.assertEquals(fluentWaitDisplayed(searchTitles.getSortandFilter(), 30, 2), true);
				Assert.assertEquals(fluentWaitDisplayed(searchTitles.pageCountText, 30, 2), true);
			}
			ClickOnMobileElement(searchResultTileView.getListView());
			waitFor(10000);
			logger.info("adding titles to the challenge");
			List<MobileElement> moreOptions = searchResultMoreCTA.getMoreOptions();
			for (int j = 0; j < 2; j++) {
				swipeDown();
				for (int i = 0; i < moreOptions.size(); i++) {
					moreOptions.get(i).click();
					ClickOnMobileElement(searchResultMoreCTA.getAddToChallenge());
				}
			}
			logger.info("Navigating back to create challenge screen");
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
			ClickOnMobileElement(addTitles.getTitleSearchPageBackbtn());
			swipeDown();
		
		List<MobileElement> addedBooks = createBasicChallenge.getAddedBooks();
		for (int i = 0; i < addedBooks.size(); i++) {
			horizontalSwipe(createBasicChallenge.getAddedBooks());
		}
	}
}
	@Then("Tap on X icon displayed on title image And Check that Title is removed from the carousel")
	public void tap_on_X_icon_displayed_on_title_image_And_Check_that_Title_is_removed_from_the_carousel()
			throws IOException {
		List<MobileElement> removeTitleXIcon = createBasicChallenge.removeTitleXIcon;
		for (int i = removeTitleXIcon.size()-1; i>1 ; i--) {
			removeTitleXIcon.get(i).click();
			break;
		}	
	}

	@Then("Check that user able to seee Remove Title confirmation model")
	public void check_that_user_able_to_seee_Remove_Title_confirmation_model() {
		logger.info("Validating Title remove modal");
		Assert.assertTrue(CreateAChallengeBasicChallengeDetails.friendRemoveButton.isDisplayed());
		Assert.assertTrue(CreateAChallengeBasicChallengeDetails.friendCancelButton.isDisplayed());
	}
	
	@Then("Tap on Remove CTA for titles")
	public void tap_on_Remove_CTA_for_titles() {
		logger.info("Removing title from the challenge");
		logger.info("Title Size: " + createBasicChallenge.removeTitleXIcon.size());
		CreateAChallengeBasicChallengeDetails.titleRemoveButton.click();
		logger.info("After Removing Title Size: " + createBasicChallenge.removeTitleXIcon.size());
	}

	@Then("Tap on Cancel CTA for titles")
	public void tap_on_Cancel_CTA_for_titles() {
		List<MobileElement> removeTitleXIcon = createBasicChallenge.removeTitleXIcon;
		removeTitleXIcon.get(0).click();
		logger.info("Validating Title remove modal");
		Assert.assertTrue(CreateAChallengeBasicChallengeDetails.friendRemoveButton.isDisplayed());
		Assert.assertTrue(CreateAChallengeBasicChallengeDetails.friendCancelButton.isDisplayed());
		logger.info("terminate remove challenge");
		CreateAChallengeBasicChallengeDetails.titleCancelButton.click();
		logger.info("Title Size: " + createBasicChallenge.removeTitleXIcon.size());
	}

	@Then("Check that user is navigated to create challenge screen without removing the titles")
	public void check_that_user_is_navigated_to_create_challenge_screen_without_removing_the_titles() {
		logger.info("Title Size after terminating removing title action : " + createBasicChallenge.removeTitleXIcon.size());
		List<MobileElement> removeTitleXIcon = createBasicChallenge.removeTitleXIcon;
		for (int i = 0; i < removeTitleXIcon.size(); i++) {
			removeTitleXIcon.get(i).isDisplayed();
		}
		Assert.assertTrue(createBasicChallenge.getSetReminderText().isDisplayed());
		Assert.assertTrue(createBasicChallenge.getSaveChallengeBtn().isDisplayed());
		Assert.assertTrue(createBasicChallenge.getStartChallengeBtn().isDisplayed());
	}
}
