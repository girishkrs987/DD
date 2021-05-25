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

public class CreateAChallengeInviteRecentlySearchedFriends_StefDef extends CapabilitiesAndWebDriverUtils {

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeInviteRecentlySearchedFriends searchfriends = new CreateAChallengeInviteRecentlySearchedFriends();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeSetReminders setReminders = new CreateChallengeSetReminders();
	CreateAChallengeSetReadbyDate setReadbyDate = new CreateAChallengeSetReadbyDate();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateAChallengeSearchAndInviteFriends SearchAndInviteFriends = new CreateAChallengeSearchAndInviteFriends();

	@When("User taps on the Add CTA under the Challenge Friends section")
	public void user_taps_on_the_Add_CTA_under_the_Challenge_Friends_section() throws InterruptedException, Exception {
	   if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
				ClickOnWebElement(createBasicChallenge.getAddFriendCTA());
//		SendKeysOnWebElement(searchfriends.getSearchBox(), 30, 1, "Photon Student15");
				}
				else{
				
		ClickOnWebElement(createBasicChallenge.getAddFriendCTA());
		//SendKeysOnWebElement(searchfriends.getSearchBox(), 30, 1, "Photon");
		//searchfriends.getSearchBox().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
		}
	}

	@Then("User should be able to add as many friends as required to the invitees list without any limit")
	public void user_should_be_able_to_add_as_many_friends_as_required_to_the_invitees_list_without_any_limit() {
		List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
		List<MobileElement> inviteOption = SearchAndInviteFriends.getInviteOptionList();
		for (int i = 0; i < userNamelist.size(); i++) {
				inviteOption.get(i).click();
			}
	}

	@When("User adds few friends by tapping on Invite button")
	public void user_adds_few_friends_by_tapping_on_Invite_button() throws InterruptedException, IOException {
	   if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
				
				List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
		List<MobileElement> inviteOption = SearchAndInviteFriends.getInviteOptionList();
		for (int i = 0; i < userNamelist.size()-1; i++) {	
//			for (int j = 0; j <inviteOption.size(); j++) {
				inviteOption.get(i).click();
				String addChallengeTxt = searchfriends.getAddToChallenge().getText();
				int addedFriendcount = i + 1;
				boolean lableTxt = addChallengeTxt.equalsIgnoreCase("Add to Challenge(" + addedFriendcount + ")");
				System.out.println(addChallengeTxt);
				Assert.assertTrue(lableTxt);
				
				}}
	   
				else{
				
		SendKeysOnWebElement(searchfriends.getSearchBox(), "Photon");
		searchfriends.getSearchBox().sendKeys(Keys.ENTER);
		List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
		int usersize = userNamelist.size()/2;
		System.out.println(usersize);
		
	List<MobileElement> inviteOption = SearchAndInviteFriends.getInviteOptionList();
		for (int i = 0; i <usersize ; i++) {
			for (int j = 0; j <inviteOption.size(); j++) {
				Thread.sleep(2000);
				inviteOption.get(j).click();
		}
	}
		}}

	@Then("User should be able to tap on the Add to challenge CTA to add invitees to the challenge")
	public void user_should_be_able_to_tap_on_the_Add_to_challenge_CTA_to_add_invitees_to_the_challenge() {
		swipeDown();
		ClickOnMobileElement(searchfriends.getAddToChallenge());
		waitFor(5000);
		Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getSetReadByText(), 30, 5), true);
	}

	@Then("User should be taken to the search page where friends can be invited to join the challenge")
	public void user_should_be_taken_to_the_search_page_where_friends_can_be_invited_to_join_the_challenge() {
		Assert.assertTrue(fluentWaitDisplayed(searchfriends.searchHeader, 30, 2));
		Assert.assertTrue(fluentWaitDisplayed(searchfriends.recentsearchText, 30, 2));
		Assert.assertTrue(fluentWaitDisplayed(searchfriends.addToChallenge, 30, 2));
		System.out.println("User is on search friend screen");
		
	}

	@Then("User should be navigated to the Invite Friends screen")
	public void user_should_be_navigated_to_the_Invite_Friends_screen() throws InterruptedException, IOException {
	
	if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
				Assert.assertTrue(fluentWaitDisplayed(searchfriends.searchHeader, 30, 2));
		Assert.assertTrue(fluentWaitDisplayed(searchfriends.recentsearchText, 30, 2));
		Assert.assertTrue(fluentWaitDisplayed(searchfriends.addToChallenge, 30, 2));
		System.out.println("User is on search friend screen");
		SendKeysOnWebElement(searchfriends.getSearchBox(), "Photon");
		List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
		List<MobileElement> inviteOption = SearchAndInviteFriends.getInviteOptionList();
		for (int i = 0; i < userNamelist.size(); i++) {
				inviteOption.get(i).click();
			}		
			ClickOnWebElement(searchfriends.getAddToChallenge());
		List<MobileElement> removeFriendXIcon = createBasicChallenge.removeFriendXIcon;		
		for (int i = removeFriendXIcon.size()-1; i>=1; i--) {
		createBasicChallenge.removeFriendXIcon.get(i).click();
	    CreateAChallengeBasicChallengeDetails.friendRemoveButton.click();	
		}
		ClickOnWebElement(createBasicChallenge.getAddFriendCTA());
				searchfriends.getSearchBox().clear();
				
				
				}
				
				else{
				
		Assert.assertTrue(fluentWaitDisplayed(searchfriends.searchHeader, 30, 2));
		//Assert.assertTrue(fluentWaitDisplayed(searchfriends.recentsearchText, 30, 2));
		Assert.assertTrue(fluentWaitDisplayed(searchfriends.addToChallenge, 30, 2));
		System.out.println("User is on search friend screen");
		SendKeysOnWebElement(searchfriends.getSearchBox(), "Photon");
		searchfriends.getSearchBox().sendKeys(Keys.ENTER);
		
		List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
		int usersize = userNamelist.size()/2;
		List<MobileElement> inviteOption = SearchAndInviteFriends.getInviteOptionList();
		for (int i = 1; i < usersize; i++) {
			for (int j = 0; j <inviteOption.size(); j++) {
				inviteOption.get(j).click();

			}
		
			}
		
		Thread.sleep(2000);
		
		ClickOnWebElement(searchfriends.getAddToChallenge());
		List<MobileElement> removeFriendXIcon = createBasicChallenge.removeFriendXIcon;
		System.out.println(removeFriendXIcon.size());
		//int removefriiendsize = removeFriendXIcon.size()/2;
		
		for (int i = removeFriendXIcon.size()-1;i>=1; i--) {
				createBasicChallenge.removeFriendXIcon.get(i).click();
				createBasicChallenge.friendRemoveButton.click();
		}
		ClickOnWebElement(createBasicChallenge.getAddFriendCTA());
		searchfriends.getSearchBox().clear();
		hideMobileKeyboard();
		}
	}

	@Then("User should be able to view the list of {int} recently searched friends")
	public void user_should_be_able_to_view_the_list_of_recently_searched_friends(Integer int1) {
		logger.info("Verifying recently searched list");
		boolean searchListSize = true;
		if(searchfriends.recentSearchfriendList.size()!=0) {
			if (searchfriends.recentSearchfriendList.size() <= 5) {
				for (int i = 0; i < searchfriends.recentSearchfriendList.size(); i++) {
				Assert.assertTrue(searchfriends.recentSearchfriendList.get(i).isDisplayed());
				}
				System.out.println("Recent Friend List is Less than or Equal to five");
		} else if (searchfriends.recentSearchfriendList.size() > 5) {
			searchListSize = false;
			Assert.assertTrue(searchListSize);
			System.out.println("Recent Friend List size is greater than five");
			} 
		}
	}

	@Then("User should be able to view only the recently searched {int} friends")
	public void user_should_be_able_to_view_only_the_recently_searched_friends(Integer int1) {
		boolean searchListSize = true;
		if(searchfriends.recentSearchfriendList.size()!=0) {
			if (searchfriends.recentSearchfriendList.size() <= 5) {
				for (int i = 0; i < searchfriends.recentSearchfriendList.size(); i++) {
				Assert.assertTrue(searchfriends.recentSearchfriendList.get(i).isDisplayed());
				}
				System.out.println("Recent Friend List is Less than or Equal to five");
		} else if (searchfriends.recentSearchfriendList.size() > 5) {
			searchListSize = false;
			Assert.assertTrue(searchListSize);
			System.out.println("Recent Friend List size is greater than five");
			} 
		}
	}

	@Then("User should be able to tap on Invite button and the specific friend should be added to the list of invitees")
	public void user_should_be_able_to_tap_on_Invite_button_and_the_specific_friend_should_be_added_to_the_list_of_invitees() throws IOException {
	logger.info("Adding friends to challenge");
		if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
	
		if (searchfriends.recentSearchfriendList.size() != 0) {
			List<MobileElement> inviteOption = SearchAndInviteFriends.getInviteOptionList();
			List<MobileElement> recentSearchfriendList = searchfriends.recentSearchfriendList;
			for (int i = 0; i < recentSearchfriendList.size(); i++) {
					inviteOption.get(i).click();
					Assert.assertTrue(searchfriends.addedFriendInSearchPage.get(i).isDisplayed());
			}
			System.out.println("Added friends are Displyed at the top of the page");
		} 
		else {
			System.out.println("No recent search friend available");
	
		}}
	
	else{
		if (searchfriends.recentSearchfriendList.size() != 0) {
		
			List<MobileElement> inviteOption = SearchAndInviteFriends.getInviteOptionList();
			
			
			List<MobileElement> recentSearchfriendList = searchfriends.recentSearchfriendList;
			int searchsize = recentSearchfriendList.size()/2;

			
			for (int i = 0; i < searchsize; i++) {
					inviteOption.get(i).click();
					Assert.assertTrue(searchfriends.addedFriendInSearchPage.get(i).isDisplayed());
					break;
			}
		
			System.out.println("Added friends are Displyed at the top of the page");
		} else {
			System.out.println("No recent search friend available");
		}
	}}
	
	@Then("User can add the invites button clicking invite button")
	
	public void user_can_add_the_invites_button_clicking_invite_button() {
		SendKeysOnWebElement(searchfriends.getSearchBox(), "Photon");
		searchfriends.getSearchBox().sendKeys(Keys.ENTER);
		
		List<MobileElement> userNamelist = SearchAndInviteFriends.getUserNameText();
		int usersize = userNamelist.size()/2;
		System.out.println(usersize);
		
	List<MobileElement> inviteOption = SearchAndInviteFriends.getInviteOptionList();
	
		for (int i = 0; i <usersize ; i++) {
			for (int j = 0; j <inviteOption.size(); j++) {
				inviteOption.get(j).click();
		}
				break;
		}
	}

	@When("User adds invitees by tapping on Add to challenge button")
	public void user_adds_invitees_by_tapping_on_Add_to_challenge_button() {
		swipeDown();
		Assert.assertTrue(searchfriends.getAddToChallenge().isEnabled());
		ClickOnMobileElement(searchfriends.getAddToChallenge());
	}

	@Then("User should be navigated back to the Create challenge screen with the list of invitees added")
	public void user_should_be_navigated_back_to_the_Create_challenge_screen_with_the_list_of_invitees_added() {
		waitFor(2000);
		for (int i = 0; i < createBasicChallenge.addedFriendavatarList.size(); i++) {
			Assert.assertTrue(createBasicChallenge.addedFriendavatarList.get(i).isDisplayed());
		}
		logger.info("Navigating back to create challenge page");
		System.out.println("Added friends are displayed in Create challenge Page");
	}
	
	@Then("User should be allowed to remove the friend by clicking on the close button in search screen")
	public void user_should_be_allowed_to_remove_the_friend_by_clicking_on_the_close_button_in_search_screen() throws IOException {

if (getData("platformName").equalsIgnoreCase("android")
				|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
//		SendKeysOnMobileElement(searchfriends.getSearchBox(), 30, 1, "ph1");
		ClickOnMobileElement(searchfriends.getInviteOption());
		List<MobileElement> addedFriendInSearchFriendList = searchfriends.addedFriendInSearchFriend;
		int before = addedFriendInSearchFriendList.size();
		logger.info("added friend list size :" +addedFriendInSearchFriendList.size());
		for (int i = 0; i < addedFriendInSearchFriendList.size(); i++) {
			Assert.assertTrue(searchfriends.addedFriendInSearchFriend.get(i).isDisplayed());
		}
		ClickOnMobileElement(searchfriends.removeFriendInSearchPage);
		int after = addedFriendInSearchFriendList.size();
		logger.info("added friend list size after removing :" +addedFriendInSearchFriendList.size());
		if(before==after) {
			System.out.println("Selected user is not removed");
		}else {
		
		
					logger.info("invitee removed from the list");		
					}}
					
					else{
					
					SendKeysOnWebElement(searchfriends.getSearchBox(), "Photon");
		searchfriends.getSearchBox().sendKeys(Keys.ENTER);

		ClickOnWebElement(searchfriends.getInviteOption());
		List<MobileElement> addedFriendInSearchFriendList = searchfriends.addedFriendInSearchFriend;
		for (int i = 0; i < addedFriendInSearchFriendList.size(); i++) {
			Assert.assertTrue(searchfriends.addedFriendInSearchFriend.get(i).isDisplayed());
		}
		ClickOnWebElement(searchfriends.removeFriendInSearchPage);
		if(addedFriendInSearchFriendList.size()!=0) {
			System.out.println("Selected user is not removed");
		}
	}	}
					
@Then("User should be able to view the Add to challenge CTA comprising of the number of invitees selected")
	public void user_should_be_able_to_view_the_Add_to_challenge_CTA_comprising_of_the_number_of_invitees_selected() {
		Assert.assertTrue(fluentWaitDisplayed(searchfriends.friendSelectedCount, 30, 2));

	    
	}
	
}

