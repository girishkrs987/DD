package com.stepdefinition;

import java.io.IOException;
import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeCreatorRCDetailsScreen;
import com.pom.CreateAChallengeInviteRecentlySearchedFriends;
import com.pom.CreateAChallengeSearchAndInviteFriends;
import com.pom.CreateAChallengeSetReadbyDate;
import com.pom.CreateChallengeAddTitles;
import com.pom.CreateChallengeSetReminders;
import com.pom.CreateaChallengeSearchTitleResultsListView;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAChallengeBasicChallengeDetails_StepDef extends CapabilitiesAndWebDriverUtils {

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeInviteRecentlySearchedFriends searchfriends = new CreateAChallengeInviteRecentlySearchedFriends();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeSetReminders setReminders = new CreateChallengeSetReminders();
	CreateAChallengeSetReadbyDate setReadbyDate = new CreateAChallengeSetReadbyDate();
	CreateAChallengeCreatorRCDetailsScreen creatorRCDetailsScreeen = new CreateAChallengeCreatorRCDetailsScreen();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();

	Date date = java.util.Calendar.getInstance().getTime();

	public static String actualchallenegeName;
	public static String actualchallenegeDesc;

	@When("User is on the Book club landing screen")
	public void user_is_on_the_Book_club_landing_screen() throws IOException {
		waitFor(1000);
		ClickOnMobileElement(bookClubLandingScreeen.getBookClubOption());
		Assert.assertEquals(fluentWaitDisplayed(bookClubLandingScreeen.getChallenges(), 30, 2), true);
		fluentWaitDisplayed(bookClubLandingScreeen.getChallenges(), 30, 2);

	}

	@When("User taps on the Create a Reading Challenge CTA")
	public void user_taps_on_the_Create_a_Reading_Challenge_CTA() throws IOException, InterruptedException {

		ClickOnMobileElement(bookClubLandingScreeen.getAddCTA());

	}

	@Then("User should be able to add friends to the challenge by tapping on Add CTA")
	public void user_should_be_able_to_add_friends_to_the_challenge_by_tapping_on_Add_CTA()
			throws InterruptedException, IOException {
		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			
			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			SendKeysOnMobileElement(searchfriends.getSearchBox(), getData("rcinvitee"));
			ClickOnMobileElement(searchfriends.getInviteOption());
			swipeDown();
			ClickOnMobileElement(searchfriends.getAddToChallenge());

		} else if (getData("platformName").equalsIgnoreCase("ios")) {

			Thread.sleep(5000);
			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			SendKeysOnMobileElement(searchfriends.getSearchBox(), "henry");
			ClickOnMobileElement(searchfriends.getSearchOption());
			ClickOnMobileElement(searchfriends.getInviteOption());
			// Assert.assertEquals(fluentWaitDisplayed(searchfriends.getAddedFriendNameCarosallist(),
			// 30, 2), true);
			ClickOnMobileElement(searchfriends.getAddToChallenge());
			Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getIosAddedFriendCreateChallengepage(), 30, 2),
					true);

			Thread.sleep(2000);

		}

	}

	@Then("User should be navigated to the Create Challenge Screen")
	public void user_should_be_navigated_to_the_Create_Challenge_Screen() throws IOException {

		Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getSetReadByText(), 30, 5), true);

	}

	@Then("User should be able to set reminders for the challenge by tapping on the Set reminders CTA")
	public void user_should_be_able_to_set_reminders_for_the_challenge_by_tapping_on_the_Set_reminders_CTA()
			throws InterruptedException, IOException {
		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {

			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
//			ClickOnMobileElement(setReminders.getDailyOption());
			
			logger.info("Setting Reminder for the challenge");
//			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
//			ClickOnMobileElement(setReminders.getDailyOption());
			setReminders.androidSetReminder();

		} else if (getData("platformName").equalsIgnoreCase("ios")) {

			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
			SendKeysWithoutClear(setReminders.iosRemainderOptions, "Weekly");
			ClickOnMobileElement(createBasicChallenge.getIosDoneBtn());
		}

	}

	@Then("User should be able to add the end date of the challenge by tapping on Set read by date CTA")
	public void user_should_be_able_to_add_the_end_date_of_the_challenge_by_tapping_on_Set_read_by_date_CTA()
			throws InterruptedException, IOException {
		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {

			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			ClickOnMobileElement(setReadbyDate.getNextMonthBtn());
			ClickOnMobileElement(setReadbyDate.getEndDate());
			ClickOnMobileElement(setReadbyDate.getCalenderIconOK());

		} else {

			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(0), "June");
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(1), "25");
			ClickOnMobileElement(createBasicChallenge.getIosDontBtn());
			Assert.assertEquals(fluentWaitDisplayed(setReadbyDate.getIosEndDate(), 30, 2), true);

		}
	}

	@Then("User should be able to add titles to the challenge by tapping on the Add Titles CTA")
	public void user_should_be_able_to_add_titles_to_the_challenge_by_tapping_on_the_Add_Titles_CTA()
			throws InterruptedException, IOException {

		swipeDown();

		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {

			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
			SendKeysOnMobileElement(searchTitles.getIosSearchTextBox(), getData("rctitle"));
			ClickOnMobileElement(searchTitles.getIosHorryPotter());
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
			ClickOnMobileElement(addTitles.getTitleSearchPageBackbtn());
			swipeDown();
			Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getAddedBook(), 30, 2), true);

		} else {

			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
			SendKeysOnMobileElement(searchTitles.getIosSearchTextBox(), "Harry Potter");
			ClickOnMobileElement(searchTitles.getIosHorryPotter());
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
			// fluentWaitDisplayed(createBasicChallenge.getTitesRemoveBtn(), 20, 2);
			Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getTitesRemoveBtn(), 30, 2), true);
		}
	}

	@When("When all the mandatory fields are Given")
	public String when_all_the_mandatory_fields_are_Given() throws IOException, InterruptedException {
		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			logger.info("Entering Challenge Name");
			SendKeysOnMobileElement(createBasicChallenge.getChallengeName(),challengeName());
			actualchallenegeName = createBasicChallenge.getChallengeName().getText();
			logger.info("Entering Challenge Description");
			SendKeysOnMobileElement(createBasicChallenge.getDescription(), getData("rcDesc"));
			actualchallenegeDesc = createBasicChallenge.getDescription().getText();
//			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
//			logger.info("Adding Friend to the challenge");
//			SendKeysOnMobileElement(searchfriends.getSearchBox(), getData("rcinvitee"));
//			ClickOnMobileElement(searchfriends.getInviteOption());
//			ClickOnMobileElement(searchfriends.getAddToChallenge());
			
			logger.info("Adding Friend to the challenge");
			CreateAChallengeSearchAndInviteFriends.addFriend(getData("rcinvitee"));
//			CreateAChallengeSearchAndInviteFriends.removeFriend(getData("removeFriend"));
			
			logger.info("Setting Reminder for the challenge");
//			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
//			ClickOnMobileElement(setReminders.getDailyOption());
			setReminders.androidSetReminder();
			
			logger.info("Setting end date for the challenge");
//			ClickOnMobileElement(createBasicChallenge.getDateOpt());
//			ClickOnMobileElement(setReadbyDate.getNextMonthBtn());
//			ClickOnMobileElement(setReadbyDate.getEndDate());
//			ClickOnMobileElement(setReadbyDate.getCalenderIconOK());
			setReadbyDate.androidSetReadByDate();
			swipeDown();
			logger.info("Tapping on add titile CTA");
			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
			logger.info("Adding Title to the challenge");
			SendKeysOnMobileElement(searchTitles.getIosSearchTextBox(), getData("rctitle"));
			ClickOnMobileElement(searchTitles.getIosHorryPotter());
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
//			ClickOnMobileElement(addTitles.getTitleSearchPageBackbtn());
			swipeDown();
			Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getAddedBook(), 30, 2), true);
			
		} else {
			Thread.sleep(2000);
			ClickOnMobileElement(createBasicChallenge.getChallengeName());
			SendKeysOnMobileElement(createBasicChallenge.getChallengeName(), challengeName());
			hideMobileKeyboard();
			actualchallenegeName = createBasicChallenge.getChallengeName().getText();

			ClickOnMobileElement(createBasicChallenge.getDescription());
			SendKeysOnMobileElement(createBasicChallenge.getDescription(), "automation ios mobile testing description");
			hideMobileKeyboard();
			actualchallenegeDesc = createBasicChallenge.getDescription().getText();

			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			SendKeysOnMobileElement(searchfriends.getSearchBox(), "ph6");
			ClickOnMobileElement(searchfriends.getSearchOption());
			Thread.sleep(3000);
			ClickOnMobileElement(searchfriends.getInviteOption());
			ClickOnMobileElement(searchfriends.getAddToChallenge());

			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
			//System.out.println(setReminders.iosRemainderOptions.size());
			SendKeysWithoutClear(setReminders.iosRemainderOptions, "Weekly");
			//ClickOnMobileElement(null);
			ClickOnMobileElement(createBasicChallenge.getIosDoneBtn());
			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(0), "25");
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(1), "June");
			//SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(0), "2021");
			//SendKeysOnMobileElement(setReadbyDate.getIoDate(), "25");
			//SendKeysOnMobileElement(setReadbyDate.getIosYear(), "2021");
			
        new Actions(driver).moveToElement(createBasicChallenge.getIosDontBtn()).click().perform();
				System.out.println("Action Class Work");
			swipeDown();
			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
			SendKeysOnMobileElement(searchTitles.getIosSearchTextBox(), "Police");
			
			searchTitles.getIosSearchTextBox().sendKeys(Keys.ENTER);

		//	ClickOnMobileElement(searchTitles.getMoreOptions());
			waitFor(5000);
			ClickOnMobileElement(searchTitles.inImage);
			
		//	new Actions(driver).moveToElement(searchTitles.inImage).click().perform();
			
			System.out.println("Adding the title  to challenge");
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
			swipeDown();
			Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getAddedBook(), 30, 2), true);

		}
		return actualchallenegeName;
	}

	@Then("User should be able to tap on the Start Challenge CTA which will be enabled after user enters the mandatory fields Challenge Name Read by Date & adding atleast {int} title")
	public void user_should_be_able_to_tap_on_the_Start_Challenge_CTA_which_will_be_enabled_after_user_enters_the_mandatory_fields_Challenge_Name_Read_by_Date_adding_atleast_title(
			Integer int1) {
		isEnabled(createBasicChallenge.getStartChallengeBtn());
		ClickOnMobileElement(createBasicChallenge.getStartChallengeBtn());
	}

	@Then("Challenge should be started and toast message should show up saying Challenge invites have been sent and starts now")
	public void challenge_should_be_started_and_toast_message_should_show_up_saying_Challenge_invites_have_been_sent_and_starts_now()
			throws IOException {

		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {

			isToastMessageDisplayed("Challenge Created Successfully");
			Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getReadImage(), 30, 2), true);
			Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getChallengeName(), 30, 2), true);
			Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getChallengeDesc(), 30, 2), true);
			Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getReadByDate(), 30, 2), true);

		}

		else {

			isToastMessageDisplayed("Challenge Created Successfully");
			Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getReadImage(), 30, 2), true);
			//Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getChallengeName(), 30, 2), true);
			Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getChallengeDesc(), 30, 2), true);
			Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.readByDate, 30, 2), true);
			//Login.invitedUserLogin();
			//ReadingChallengeAcceptRejectChallenge.acceptChallenge();

		}

	}

	@Then("User should be able to tap on the Save CTA to save the changes made in the challenge and start or publish it later")
	public void user_should_be_able_to_tap_on_the_Save_CTA_to_save_the_changes_made_in_the_challenge_and_start_or_publish_it_later()
			throws InterruptedException, IOException {
		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			
			logger.info("Entering Challenge Name");
			SendKeysOnMobileElement(createBasicChallenge.getChallengeName(), getData("rcName") + date);
			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			logger.info("Adding Friend to the challenge");
			SendKeysOnMobileElement(searchfriends.getSearchBox(), getData("rcinvitee"));
			ClickOnMobileElement(searchfriends.getInviteOption());
			ClickOnMobileElement(searchfriends.getAddToChallenge());
			logger.info("Setting Reminder for the challenge");
			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
			ClickOnMobileElement(setReminders.getDailyOption());
			logger.info("Setting end date for the challenge");
			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			ClickOnMobileElement(setReadbyDate.getNextMonthBtn());
			ClickOnMobileElement(setReadbyDate.getEndDate());
			ClickOnMobileElement(setReadbyDate.getCalenderIconOK());
			swipeDown();
			logger.info("Tapping on add titile CTA");
			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
			logger.info("Adding Title to the challenge");
			SendKeysOnMobileElement(searchTitles.getIosSearchTextBox(), getData("rctitle"));
			ClickOnMobileElement(searchTitles.getIosBookName());
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
			ClickOnMobileElement(addTitles.getTitleSearchPageBackbtn());
			swipeDown();
			ClickOnMobileElement(createBasicChallenge.getSaveChallengeBtn()); // api not integrated

		} else {

			ClickOnMobileElement(createBasicChallenge.getChallengeName());
			SendKeysOnMobileElement(createBasicChallenge.getChallengeName(), "QATesting" + date);
			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			SendKeysOnMobileElement(searchfriends.getSearchBox(), "photon");
			ClickOnMobileElement(searchfriends.getSearchOption());
			ClickOnMobileElement(searchfriends.getInviteOption());
			ClickOnMobileElement(searchfriends.getAddToChallenge());

			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
			SendKeysWithoutClear(setReminders.iosRemainderOptions, "Weekly");
			ClickOnMobileElement(createBasicChallenge.getIosDoneBtn());
			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(0), "June");
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(1), "25");
			swipeDown();
			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
			SendKeysOnMobileElement(searchTitles.getIosSearchTextBox(), "Horry Potter");
			ClickOnMobileElement(searchTitles.getIosHorryPotter());
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
			ClickOnMobileElement(createBasicChallenge.getSaveChallengeBtn());

		}
	}

	@Then("User should be able to tap on Delete CTA and discard the changes made  and return to Book Club landing screen")
	public void user_should_be_able_to_tap_on_Delete_CTA_and_discard_the_changes_made_and_return_to_Book_Club_landing_screen()
			throws IOException {
		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {

			logger.info("Entering Challenge Name");
			SendKeysOnMobileElement(createBasicChallenge.getChallengeName(), getData("rcName") + date);
			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			logger.info("Adding Friend to the challenge");
			SendKeysOnMobileElement(searchfriends.getSearchBox(), getData("rcinvitee"));
			ClickOnMobileElement(searchfriends.getInviteOption());
			ClickOnMobileElement(searchfriends.getAddToChallenge());
			logger.info("Setting Reminder for the challenge");
			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
			ClickOnMobileElement(setReminders.getDailyOption());
			logger.info("Setting end date for the challenge");
			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			ClickOnMobileElement(setReadbyDate.getNextMonthBtn());
			ClickOnMobileElement(setReadbyDate.getEndDate());
			ClickOnMobileElement(setReadbyDate.getCalenderIconOK());
			swipeDown();
			logger.info("Tapping on add titile CTA");
			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
			logger.info("Adding Title to the challenge");
			SendKeysOnMobileElement(searchTitles.getIosSearchTextBox(),getData("rctitle"));
			ClickOnMobileElement(searchTitles.getIosHorryPotter());
			// ClickOnMobileElement(searchTitles.getIosBookName(), 30, 2);
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge());
			ClickOnMobileElement(searchTitles.getIosdoneBtn());
			ClickOnMobileElement(addTitles.getTitleSearchPageBackbtn());
			swipeDown();
			ClickOnMobileElement(createBasicChallenge.getDeleteBtn());// delete btn not working

		} else {

			ClickOnMobileElement(createBasicChallenge.getChallengeName());
			SendKeysOnMobileElement(createBasicChallenge.getChallengeName(), "QATesting");
			ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());
			SendKeysOnMobileElement(searchfriends.getSearchBox(), "photon");
			ClickOnMobileElement(searchfriends.getSearchOption());
			ClickOnMobileElement(searchfriends.getInviteOption());
			ClickOnMobileElement(searchfriends.getAddToChallenge());

			ClickOnMobileElement(createBasicChallenge.getSetReminderOpt());
			SendKeysWithoutClear(setReminders.iosRemainderOptions, "Weekly");
			ClickOnMobileElement(createBasicChallenge.getIosDoneBtn());
			ClickOnMobileElement(createBasicChallenge.getDateOpt());
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(0), "June");
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(1), "25");
			ClickOnMobileElement(createBasicChallenge.getIosDontBtn());
			swipeDown();
			ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());// api not integra
			SendKeysOnMobileElement(searchTitles.getIosSearchTextBox(), "Horry Potter");
			ClickOnMobileElement(searchTitles.getIosHorryPotter());
			ClickOnMobileElement(searchTitles.getMoreOptions());
			ClickOnMobileElement(searchTitles.getIosAddToChallenge()); // need to verify the added title
			ClickOnMobileElement(createBasicChallenge.getDeleteBtn());// delete btn not working

		}
	}

}
