package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeCreatorRCDetailsScreen;
import com.pom.CreateAChallengeCreatorRCDetailsScreenMoreIcon;
import com.pom.CreateAChallengeInviteRecentlySearchedFriends;
import com.pom.CreateAChallengeSetReadbyDate;
import com.pom.CreateChallengeAddTitles;
import com.pom.CreateChallengeSetReminders;
import com.pom.CreateaChallengeSearchTitleResultsListView;

import cucumber.api.java.en.When;

public class CreateAChallengeCreatorRCDetailsScreenMoreIcon_StepDef extends CapabilitiesAndWebDriverUtils {

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeInviteRecentlySearchedFriends searchfriends = new CreateAChallengeInviteRecentlySearchedFriends();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeSetReminders setReminders = new CreateChallengeSetReminders();
	CreateAChallengeSetReadbyDate setReadbyDate = new CreateAChallengeSetReadbyDate();
	CreateAChallengeCreatorRCDetailsScreenMoreIcon creatorDetailsScreenMoreIcon = new CreateAChallengeCreatorRCDetailsScreenMoreIcon();
	CreateAChallengeCreatorRCDetailsScreen creatorRCDetailsScreeen = new CreateAChallengeCreatorRCDetailsScreen();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	
	@When("User has created a challenge")
	public void user_has_created_a_challenge() throws InterruptedException, IOException {
		if (getData("platformName").equalsIgnoreCase("android")||getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			ClickOnMobileElement(bookClubLandingScreeen.getBookClubOption());
			ClickOnMobileElement(bookClubLandingScreeen.getAddCTA());
			SendKeysOnMobileElement(createBasicChallenge.getChallengeName(),"QATesting");
			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			SendKeysOnMobileElement(searchfriends.getSearchBox(),"Henry");
			ClickOnMobileElement(searchfriends.getInviteOption());
			ClickOnMobileElement(searchfriends.getAddToChallenge());
			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
			ClickOnMobileElement(setReminders.getDailyOption());
			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			ClickOnMobileElement(setReadbyDate.getNextMonthBtn());
			ClickOnMobileElement(setReadbyDate.getEndDate());
			ClickOnMobileElement(setReadbyDate.getCalenderIconOK());
			swipeDown();
			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
			SendKeysOnMobileElement(searchTitles.searchTextBox, "harry pot");
			ClickOnMobileElement(searchTitles.getIosHorryPotter());
			ClickOnMobileElement(searchTitles.getIosBookName());
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
			ClickOnMobileElement(addTitles.getTitleSearchPageBackbtn());
			Thread.sleep(2000);
			swipeDown();
			ClickOnMobileElement(createBasicChallenge.getStartChallengeBtn());
		} else {
			ClickOnMobileElement(bookClubLandingScreeen.getBookClubOption());
			ClickOnMobileElement(bookClubLandingScreeen.getAddCTA());
			ClickOnMobileElement(createBasicChallenge.getChallengeName());
			SendKeysOnMobileElement(createBasicChallenge.getChallengeName(),"QATesting");
			SendKeysOnMobileElement(createBasicChallenge.getDescription(),"QATesting");

			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			ClickOnMobileElement(searchfriends.getInviteOption());
			ClickOnMobileElement(searchfriends.getAddToChallenge());
			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
			SendKeysWithoutClear(setReminders.iosRemainderOptions,"Weekly");
			ClickOnMobileElement(createBasicChallenge.getIosDoneBtn());
			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(0),"June");
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(1),"25");
			SendKeysOnMobileElement(setReadbyDate.getIosYear(),"2021");
			ClickOnMobileElement(createBasicChallenge.getIosDontBtn());
			Assert.assertEquals(fluentWaitDisplayed(setReadbyDate.getIosEndDate(), 30, 2), true);
			swipeDown();
			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());// api not integrated
			SendKeysOnMobileElement(searchTitles.searchTextBox, "Horry Potter");
			ClickOnMobileElement(searchTitles.getIosHorryPotter());
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(createBasicChallenge.getStartChallengeBtn());

		}

	}

	@When("User is on the Challenge Details screen")
	public void user_is_on_the_Challenge_Details_screen() {

		// Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getCreatorAvatar(),
		// 30, 2), true); locator issue in ios
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getCreatorName(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getChallengeName(), 30, 2), true);

	}

	@When("User taps on the more icon")
	public void user_taps_on_the_more_icon() throws InterruptedException {

		ClickOnMobileElement(creatorDetailsScreenMoreIcon.getMoreIcon());

	}

	@When("User should be able to view the More menu Edit Challenge and Leave Challenge")
	public void user_should_be_able_to_view_the_More_menu_Edit_Challenge_and_Leave_Challenge() {

		Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getLeaveChallenge(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getEditChallenge(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getCancel(), 30, 2), true);

	}

	@When("User should be able to tap on Edit Challenge menu item and navigate to edit challenge screen")
	public void user_should_be_able_to_tap_on_Edit_Challenge_menu_item_and_navigate_to_edit_challenge_screen() {

		ClickOnMobileElement(creatorDetailsScreenMoreIcon.getEditChallenge());
		Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getEditChallengeRCHeader(), 30, 2), true);// locator
																														// issue
																														// in
																														// ios

	}

	@When("User should be able to tap on the Leave Challenge menu item to leave the challenge")
	public void user_should_be_able_to_tap_on_the_Leave_Challenge_menu_item_to_leave_the_challenge() {

		ClickOnMobileElement(creatorDetailsScreenMoreIcon.getLeaveChallenge());

	}

	@When("User should be able to tap on Cancel and navigate back to the Challenge details screen")
	public void user_should_be_able_to_tap_on_Cancel_and_navigate_back_to_the_Challenge_details_screen() {

		ClickOnMobileElement(creatorDetailsScreenMoreIcon.getCancel());
		// Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getCreatorAvatar(),
		// 30, 2), true); //locator issue in ios
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getCreatorName(), 30, 2), true);

	}

}
