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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAChallengeCreatorRCDetailsScreen_StefDef extends CapabilitiesAndWebDriverUtils {

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeInviteRecentlySearchedFriends searchfriends = new CreateAChallengeInviteRecentlySearchedFriends();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeSetReminders setReminders = new CreateChallengeSetReminders();
	CreateAChallengeSetReadbyDate setReadbyDate = new CreateAChallengeSetReadbyDate();
	CreateAChallengeCreatorRCDetailsScreen creatorRCDetailsScreeen = new CreateAChallengeCreatorRCDetailsScreen();
	CreateAChallengeCreatorRCDetailsScreenMoreIcon creatorDetailsScreenMoreIcon = new CreateAChallengeCreatorRCDetailsScreenMoreIcon();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	
	@When("User adds the required details and taps on the Start Challenge")
	public void user_adds_the_required_details_and_taps_on_the_Start_Challenge() throws IOException {

		if (getData("platformName").equalsIgnoreCase("android")||getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {

			SendKeysOnMobileElement(createBasicChallenge.getChallengeName(),"QATesting");
			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			SendKeysOnMobileElement(searchfriends.getSearchBox(), "Henry");
			ClickOnMobileElement(searchfriends.getInviteOption());
			ClickOnMobileElement(searchfriends.getAddToChallenge());
			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
			ClickOnMobileElement(setReminders.getDailyOption());
			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			ClickOnMobileElement(setReadbyDate.getNextMonthBtn());
			ClickOnMobileElement(setReadbyDate.getEndDate());
			ClickOnMobileElement(setReadbyDate.getCalenderIconOK());
			Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getDateOpt(), 20, 2), true);
			swipeDown();
			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
			SendKeysOnMobileElement(searchTitles.searchTextBox, "harry pot");
			ClickOnMobileElement(searchTitles.getIosHorryPotter());
			// ClickOnMobileElement(searchTitles.getIosBookName(), 30, 2); Directly adding from
			// the suggestion list
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
			ClickOnMobileElement(addTitles.getTitleSearchPageBackbtn());
			swipeDown();
			Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getAddedBook(), 30, 2), true);
			ClickOnMobileElement(createBasicChallenge.getStartChallengeBtn());
		} else {
			ClickOnMobileElement(createBasicChallenge.getChallengeName());
			SendKeysOnMobileElement(createBasicChallenge.getChallengeName(), "QATesting");
			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			SendKeysOnMobileElement(searchfriends.getSearchBox(),"photon");
			ClickOnMobileElement(searchfriends.getSearchOption());
			ClickOnMobileElement(searchfriends.getInviteOption());
			ClickOnMobileElement(searchfriends.getAddToChallenge());
			
			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
			SendKeysWithoutClear(setReminders.iosRemainderOptions,"Weekly");
			ClickOnMobileElement(createBasicChallenge.getIosDoneBtn());
			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(0), "June");
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(1), "25");
			//SendKeysOnMobileElement(setReadbyDate.getIosYear(),"2021");
			ClickOnMobileElement(createBasicChallenge.getIosDontBtn());
			swipeDown();
			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());// api not integra
			SendKeysOnMobileElement(searchTitles.searchTextBox,"Horry Potter");
			ClickOnMobileElement(searchTitles.getIosHorryPotter());
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
			ClickOnMobileElement(createBasicChallenge.getStartChallengeBtn());		
		}
	}

	@Then("User should be navigated to the Challenge details screen")
	public void user_should_be_navigated_to_the_Challenge_details_screen() {

		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getCreatorAvatar(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getCreatorName(), 30, 2), true);

	}

	@Then("User should be able to view their avatar name and the date of creation of the challenge")
	public void user_should_be_able_to_view_their_avatar_name_and_the_date_of_creation_of_the_challenge() {
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getCreatorName(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getCreateDate(), 30, 2), true);

	}

	@Then("User should be able to view the Challenge icon Challenge Text Challenge Name End date of the challenge description of the challenge")
	public void user_should_be_able_to_view_the_Challenge_icon_Challenge_Text_Challenge_Name_End_date_of_the_challenge_description_of_the_challenge() {
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getReadImage(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getChallengeName(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getChallengeDesc(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getReadByDate(), 30, 2), true);

	}

	@Then("User should be able to view the list of participants invited to participate in the challenge")
	public void user_should_be_able_to_view_the_list_of_participants_invited_to_participate_in_the_challenge()
			throws IOException {

		if (getData("platformName").equalsIgnoreCase("android")||getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			swipeDown();
			Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getLeaderName(), 30, 2), true);

		}

		else {
			swipeDown();
			Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getIosParticipantsList(), 30, 2), true);
		}
	}

	@Then("User should be able to tap on the more icon and view the more menu related to the reading challenge")
	public void user_should_be_able_to_tap_on_the_more_icon_and_view_the_more_menu_related_to_the_reading_challenge()
			throws IOException {

		if (getData("platformName").equalsIgnoreCase("android")||getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			ClickOnMobileElement(creatorDetailsScreenMoreIcon.getMoreIcon());
			Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getLeaveChallenge(), 30, 2), true);
			// Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getReportAbuse(),30,
			// 2), true);
			Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getEditChallenge(), 30, 2), true);
			Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getCancel(), 30, 2), true);
		} else {
			ClickOnMobileElement(creatorDetailsScreenMoreIcon.getMoreIcon());
			Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getLeaveChallenge(), 30, 2), true);
			Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getReportAbuse(), 30, 2), true);
			Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getEditChallenge(), 30, 2), true);
			// Assert.assertEquals(fluentWaitDisplayed(creatorDetailsScreenMoreIcon.getCancel(),30,
			// 2), true);

		}
	}
}
