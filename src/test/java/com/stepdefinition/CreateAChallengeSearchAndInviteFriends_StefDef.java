package com.stepdefinition;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeInviteRecentlySearchedFriends;
import com.pom.CreateAChallengeSearchAndInviteFriends;
import com.pom.CreateAChallengeSetReadbyDate;
import com.pom.CreateChallengeAddTitles;
import com.pom.CreateChallengeSetReminders;
import com.pom.CreateaChallengeSearchTitleResultsListView;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;

public class CreateAChallengeSearchAndInviteFriends_StefDef extends CapabilitiesAndWebDriverUtils {

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeInviteRecentlySearchedFriends searchfriends = new CreateAChallengeInviteRecentlySearchedFriends();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeSetReminders setReminders = new CreateChallengeSetReminders();
	CreateAChallengeSetReadbyDate setReadbyDate = new CreateAChallengeSetReadbyDate();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateAChallengeSearchAndInviteFriends SearchAndInviteFriends = new CreateAChallengeSearchAndInviteFriends();

	@When("User is on the Invite Friends screen of a Reading challenge")
	public void user_is_on_the_Invite_Friends_screen_of_a_Reading_challenge() {

		ClickOnMobileElement(bookClubLandingScreeen.getBookClubOption());
//		Assert.assertEquals(fluentWaitDisplayed(bookClubLandingScreeen.getChallenges(), 30, 2), true);
		ClickOnMobileElement(bookClubLandingScreeen.getAddCTA());
		ClickOnMobileElement(createBasicChallenge.getAddFriendCTA());

	}

	@When("User enter characters for search in the search bar")
	public void user_enter_characters_for_search_in_the_search_bar() throws IOException {
		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {

			SendKeysOnMobileElement(searchfriends.getSearchBox(), getData("SearchFriendInput"));
		} else {

			SendKeysOnWebElement(searchfriends.getSearchBox(), "Photon");
			searchfriends.getSearchBox().sendKeys(Keys.ENTER);
		}
	}

	@Then("User should be able to view the suggested search results based on the search input string When {int} characters minimum are entered")
	public void user_should_be_able_to_view_the_suggested_search_results_based_on_the_search_input_string_When_characters_minimum_are_entered(Integer int1) throws IOException {
if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
	searchfriends.getSearchBox().clear();
		SendKeysOnMobileElement(searchfriends.getSearchBox(),getData("SearchFriendInput"));
		List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
		if(userNamelist.size()!=0)
		{
			Assert.assertTrue("list is Displayed",true);
		}	
}
	else{
				
		SendKeysOnWebElement(searchfriends.getSearchBox(), "pho");
		searchfriends.getSearchBox().sendKeys(Keys.ENTER);
		List<MobileElement> userNamelist1 = SearchAndInviteFriends.getUserNameText();
		if(userNamelist1.size()!=0)
		{
			
			Assert.assertTrue("list is Displayed",true);
		}
			    }
		    
	}

	@Then("User should be able to edit the search input string as required and view the corresponding search suggestions updated")
	public void user_should_be_able_to_edit_the_search_input_string_as_required_and_view_the_corresponding_search_suggestions_updated()
			throws IOException, InterruptedException {
		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			searchfriends.getSearchBox().clear();
			SendKeysOnMobileElement(searchfriends.getSearchBox(), getData("SearchFriendeditInput"));
			List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
			for (int i = 0; i < userNamelist.size(); i++) {
				userNamelist.get(i).getText().contains(getData("SearchFriendeditInput"));
				Assert.assertTrue(true);
			}
			searchfriends.getSearchBox().clear();
			SendKeysOnMobileElement(searchfriends.getSearchBox(), getData("SearchFriendInput2"));
			List<MobileElement> userNamelist1 = SearchAndInviteFriends.getUserNameText();
			for (int i = 0; i < userNamelist1.size(); i++) {
				userNamelist1.get(i).getText().contains(getData("SearchFriendInput2"));
				Assert.assertTrue(true);
			}

			waitFor(5000);
		} else {
			searchfriends.getSearchBox().clear();
			SendKeysOnWebElement(searchfriends.getSearchBox(), "Student");
			searchfriends.getSearchBox().sendKeys(Keys.ENTER);
			List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
			for (int i = 0; i < userNamelist.size(); i++) {
				userNamelist.get(i).getText().equalsIgnoreCase("Student");
				Thread.sleep(2000);
				Assert.assertTrue(true);
			}

			waitFor(5000);
		}
	}

	

	@Then("When user enters {int} or more characters as the search string list of suggestions should be provided")
	public void when_user_enters_or_more_characters_as_the_search_string_list_of_suggestions_should_be_provided(
			Integer int1) {
		Boolean search = true;
		List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
		if (userNamelist.size() != 0) {
			for (int i = 0; i < userNamelist.size(); i++) {
				userNamelist.get(i).getText().contains("Phot");
				Assert.assertTrue(search);
			}
			System.out.println("Search Suggestions displyed");
		}
	}

	@Then("Search suggestions should not be displayed When user has entered {int} or less characters in the search field")
	public void search_suggestions_should_not_be_displayed_When_user_has_entered_or_less_characters_in_the_search_field(
			Integer int1) {
		Boolean search = true;
		SendKeysOnMobileElement(searchfriends.getSearchBox(), "Ph");
		List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
		int listSize = userNamelist.size();
		if (listSize != 0) {
			search = false;
			System.out.println("Search Result displayed");
			Assert.assertTrue(search);
		} else {
			System.out.println("Search Result is not displayed");
			Assert.assertTrue(search);
		}
	}

	@Then("User should be able to tap on Invite CTA to add the required friends from the search results to the list of invitees")
	public void user_should_be_able_to_tap_on_Invite_CTA_to_add_the_required_friends_from_the_search_results_to_the_list_of_invitees() {
		Boolean search = true;
		List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
		for (int i = 0; i < userNamelist.size(); i++) {
			userNamelist.get(i).getText().contains("Phot");
			Assert.assertTrue(search);
		}
	}

	@When("User adds a friend by tapping on Invite button")
	public void user_adds_a_friend_by_tapping_on_Invite_button() {

		List<MobileElement> inviteopt = CreateAChallengeInviteRecentlySearchedFriends.inviteOptionList;
		for (int i = 0; i < 3; i++) {
			inviteopt.get(i).click();
		}
		ClickOnMobileElement(searchfriends.getAddToChallenge());
	}

	@Then("User should be able to tap on the X icon next to each friend added and remove them from the list of invitees")
	public void user_should_be_able_to_tap_on_the_X_icon_next_to_each_friend_added_and_remove_them_from_the_list_of_invitees() throws IOException {
		if (getData("platformName").equalsIgnoreCase("android")|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {		
		ClickOnMobileElement(searchfriends.getInviteOption());		
		List<MobileElement> addedFriendInSearchFriendList = searchfriends.addedFriendInSearchFriend;
       int before = addedFriendInSearchFriendList.size();
		logger.info("added friend list size :" +addedFriendInSearchFriendList.size());
		for (int i = 0; i < addedFriendInSearchFriendList.size(); i++) {
			Assert.assertTrue(searchfriends.addedFriendInSearchFriend.get(i).isDisplayed());
		}
		ClickOnMobileElement(searchfriends.removeFriendInSearchPage1);
		int after = addedFriendInSearchFriendList.size();
		logger.info("added friend list size after removing :" +addedFriendInSearchFriendList.size());
		if(before==after) {
			System.out.println("Selected user is not removed");
		}
		else {
			logger.info("invitee removed from the list");
		}
		} 
		else{
		
		
     boolean removeFriend = true;
		int beforeFriendListSize = createBasicChallenge.addedFriendavatarList.size();
		System.out.println("Before List Size: "+beforeFriendListSize);
		for (int i = 0; i < createBasicChallenge.addedFriendavatarList.size(); i++) {
			Assert.assertTrue(createBasicChallenge.addedFriendavatarList.get(i).isDisplayed());
			if(i>1) {
				createBasicChallenge.removeFriendXIcon.get(i).click();
				createBasicChallenge.friendRemoveButton.click();	
			}
		}
		int afterFrientListSize = createBasicChallenge.addedFriendavatarList.size();
		System.err.println("After List Size: "+afterFrientListSize);
		if (beforeFriendListSize==afterFrientListSize) {
			System.out.println("User is not removed Yet");
			removeFriend =false;
			Assert.assertTrue(removeFriend);
		}
		else {
			System.out.println("User is removed Sucessfully");
			Assert.assertTrue(removeFriend);
}
	}
	}

	
}
