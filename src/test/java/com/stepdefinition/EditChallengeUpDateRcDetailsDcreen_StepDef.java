package com.stepdefinition;

import java.io.IOException;
import java.util.Date;

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
import com.pom.EditChallengeUpDateRcDetailsDcreen;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditChallengeUpDateRcDetailsDcreen_StepDef extends CapabilitiesAndWebDriverUtils{
	
	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeInviteRecentlySearchedFriends searchfriends = new CreateAChallengeInviteRecentlySearchedFriends();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeSetReminders setReminders = new CreateChallengeSetReminders();
	CreateAChallengeSetReadbyDate setReadbyDate = new CreateAChallengeSetReadbyDate();
	CreateAChallengeCreatorRCDetailsScreen creatorRCDetailsScreeen = new CreateAChallengeCreatorRCDetailsScreen();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateAChallengeCreatorRCDetailsScreenMoreIcon creatorRCDetailsScreenMoreIcon = new CreateAChallengeCreatorRCDetailsScreenMoreIcon();
	EditChallengeUpDateRcDetailsDcreen editchallenge = new EditChallengeUpDateRcDetailsDcreen();
	
	Date date = java.util.Calendar.getInstance().getTime();
	
	@When("User has created a Challenge")
	public void user_has_created_a_Challenge() throws IOException {
		ClickOnWebElement(bookClubLandingScreeen.getBookClubOption());
		Assert.assertEquals(fluentWaitDisplayed(bookClubLandingScreeen.getChallenges(), 20,2), true);
		fluentWaitDisplayed(bookClubLandingScreeen.getChallenges(), 30, 2);
		ClickOnWebElement(bookClubLandingScreeen.getAddCTA());
		SendKeysOnWebElement(createBasicChallenge.getChallengeName(),getData("rcName")+date);
		System.out.println("Challenge Name :"+createBasicChallenge.getChallengeName().getText());
		SendKeysOnWebElement(createBasicChallenge.getDescription(), getData("rcDesc"));
		System.out.println("Description :"+createBasicChallenge.getDescription().getText());
		ClickOnWebElement(createBasicChallenge.getAddFriendCTA());
		SendKeysOnWebElement(searchfriends.getSearchBox(),getData("rcinvitee"));
		ClickOnWebElement(searchfriends.getInviteOption());
		ClickOnWebElement(searchfriends.getAddToChallenge());
		System.out.println("Size after adding friends" +createBasicChallenge.addedFriendNameList.size());
		for (int i = 0; i < createBasicChallenge.addedFriendNameList.size(); i++) {
			Assert.assertEquals(createBasicChallenge.addedFriendNameList.get(i).isDisplayed(), true);
		} 
		ClickOnWebElement(createBasicChallenge.getSetReminderOpt());
		ClickOnWebElement(setReminders.getDailyOption());
		ClickOnWebElement(createBasicChallenge.getDateOpt());
		ClickOnWebElement(setReadbyDate.getNextMonthBtn());
		ClickOnWebElement(setReadbyDate.getEndDate());
		ClickOnWebElement(setReadbyDate.getCalenderIconOK());
		swipeDown();
		ClickOnWebElement(createBasicChallenge.getAddTitlesCTA());
		SendKeysOnWebElement(searchTitles.getIosSearchTextBox(), getData("rctitle"));
		ClickOnWebElement(searchTitles.getIosHorryPotter());
		// ClickOnWebElement(searchTitles.getIosBookName(), 30, 2);
		ClickOnWebElement(searchTitles.getMoreOptions());
		ClickOnWebElement(searchTitles.getIosAddToChallenge());
		ClickOnWebElement(searchTitles.getIosdoneBtn());
		ClickOnWebElement(addTitles.getTitleSearchPageBackbtn());
		swipeDown();
		System.out.println("Size after adding the book" +createBasicChallenge.addedBooks.size());
		for (int i = 0; i < createBasicChallenge.addedBooks.size(); i++) {
			Assert.assertEquals(createBasicChallenge.addedBooks.get(i).isDisplayed(), true);
		}
		isEnabled(createBasicChallenge.getStartChallengeBtn());
		ClickOnWebElement(createBasicChallenge.getStartChallengeBtn());
		isToastMessageDisplayed("Challenge Created Successfully");
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getReadImage(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getChallengeName(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.getChallengeDesc(), 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.readByDateValue, 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.reminderValue, 30, 2), true);

	}

	@When("User taps on the Edit Challenge")
	public void user_taps_on_the_Edit_Challenge() {
		creatorRCDetailsScreeen.getMoreIcon().click();
		ClickOnWebElement(creatorRCDetailsScreenMoreIcon.editChallenge);
	}

	@Then("User should be navigated to edit challenge screen")
	public void user_should_be_navigated_to_edit_challenge_screen() {
	
		System.out.println("Edit Challenge Screen Header : "+creatorRCDetailsScreenMoreIcon.editChallengeRCHeader.getText());
//		Assert.assertTrue(creatorRCDetailsScreenMoreIcon.editChallengeRCHeader.getText().contains("Edit"));
	    
	}

	@Then("User should be able to update challenge screen")
	public void user_should_be_able_to_update_challenge_screen() throws IOException {
		createBasicChallenge.getChallengeName().clear();
		SendKeysOnWebElement(createBasicChallenge.getChallengeName(),getData("ercName"));
		System.out.println("Edited Challenge Name :"+createBasicChallenge.getChallengeName().getText());
		createBasicChallenge.getDescription().clear();
		SendKeysOnWebElement(createBasicChallenge.getDescription(), getData("ercDesc"));
		System.out.println("Description :"+createBasicChallenge.getDescription().getText());
		ClickOnWebElement(createBasicChallenge.getAddFriendCTA());
		SendKeysOnWebElement(searchfriends.getSearchBox(),getData("ercinvitee"));
		ClickOnWebElement(searchfriends.getInviteOption());
		ClickOnWebElement(searchfriends.getAddToChallenge());
		System.out.println("Size after adding friends" +createBasicChallenge.addedFriendNameList.size());
		for (int i = 0; i < createBasicChallenge.addedFriendNameList.size(); i++) {
			Assert.assertEquals(createBasicChallenge.addedFriendNameList.get(i).isDisplayed(), true);
		} 
		ClickOnWebElement(createBasicChallenge.getSetReminderOpt());
		ClickOnWebElement(setReminders.getWeeklyOption());
		ClickOnWebElement(createBasicChallenge.getDateOpt());
		ClickOnWebElement(setReadbyDate.getNextMonthBtn());
		ClickOnWebElement(setReadbyDate.getNextMonthBtn());
		ClickOnWebElement(setReadbyDate.getEndDate());
		ClickOnWebElement(setReadbyDate.getCalenderIconOK());
		swipeDown();
		ClickOnWebElement(createBasicChallenge.getAddTitlesCTA());
		SendKeysOnWebElement(searchTitles.getIosSearchTextBox(), getData("erctitle"));
		ClickOnWebElement(searchTitles.getIosHorryPotter());
		ClickOnWebElement(searchTitles.getMoreOptions());
		ClickOnWebElement(searchTitles.getIosAddToChallenge());
		ClickOnWebElement(searchTitles.getIosdoneBtn());
		ClickOnWebElement(addTitles.getTitleSearchPageBackbtn());
		swipeDown();
		System.out.println("Size after adding the book" +createBasicChallenge.addedBooks.size());
		for (int i = 0; i < createBasicChallenge.addedBooks.size(); i++) {
			Assert.assertEquals(createBasicChallenge.addedBooks.get(i).isDisplayed(), true);
		}   
		ClickOnWebElement(editchallenge.CHSave);
		Assert.assertTrue(creatorRCDetailsScreeen.challengeName.getText().equalsIgnoreCase(getData("ercName")));
		Assert.assertTrue(creatorRCDetailsScreeen.challengeDesc.getText().equalsIgnoreCase(getData("ercDesc")));
	}

	@Then("User should be able to update, remove and add challenge description")
	public void user_should_be_able_to_update_remove_and_add_challenge_description() {
	   
	    
	}

	@Then("User should be able to add more friends to the challenge by tapping on Add CTA")
	public void user_should_be_able_to_add_more_friends_to_the_challenge_by_tapping_on_Add_CTA() {
	   
	    
	}

	@Then("User should be able to select and update Daily Weekly or Monthly Reminders")
	public void user_should_be_able_to_select_and_update_Daily_Weekly_or_Monthly_Reminders() {
	   
	    
	}

	@Then("User should be able to select and update read by date")
	public void user_should_be_able_to_select_and_update_read_by_date() {
	   
	    
	}

	@Then("User should be able to add more titles to the challenge by tapping on the Add Titles CTA")
	public void user_should_be_able_to_add_more_titles_to_the_challenge_by_tapping_on_the_Add_Titles_CTA() {
	   
	    
	}

	@Then("User should be able to tap done to save changes to navigate back to challenge screen")
	public void user_should_be_able_to_tap_done_to_save_changes_to_navigate_back_to_challenge_screen() {
	   
	    
	}

	@Then("User should be able to tap on back button to go back to challenge details screen without saving")
	public void user_should_be_able_to_tap_on_back_button_to_go_back_to_challenge_details_screen_without_saving() {
	   
	    
	}

}
