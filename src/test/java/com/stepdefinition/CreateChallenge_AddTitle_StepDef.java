package com.stepdefinition;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateChallengeAddTitles;
import com.pom.CreateaChallengeSearchTitleResultsListView;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CreateChallenge_AddTitle_StepDef extends CapabilitiesAndWebDriverUtils{
	
	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();  
    public String challengeName = "QATesting"+date;
		
	@When("User is on the Create Challenge Screen")
	public void user_is_on_the_Create_Challenge_Screen() {
		
		ClickOnMobileElement(bookClubLandingScreeen.getBookClubOption());
		ClickOnMobileElement(bookClubLandingScreeen.getAddCTA());
//		Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getSetReminderText(), 30, 5), true);
		
	}

	@When("User taps on the Add Titles CTA")
	public void user_taps_on_the_Add_Titles_CTA() {
	    
		SendKeysOnMobileElement(createBasicChallenge.getChallengeName(), "QATesting"+date);
		swipeDown();
		hideMobileKeyboard();
		ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());
			
	}

	@Then("User should be navigated to the Add Titles screen, with the challenge name as the screen title")
	public void user_should_be_navigated_to_the_Add_Titles_screen_with_the_challenge_name_as_the_screen_title() {
	   		
		Assert.assertTrue(fluentWaitDisplayed(addTitles.getAddTitleSearchHeader(), 30, 2));
		Assert.assertTrue(addTitles.getAddTitleSearchHeader().getText().contains("QATesting"));
		logger.info("Validating the search page header");
		Assert.assertTrue(fluentWaitDisplayed(addTitles.getTitleSearchPageBackbtn(), 30, 2));
		Assert.assertTrue(fluentWaitDisplayed(addTitles.getIosRecommendationsText(), 30, 2));
		Assert.assertTrue(fluentWaitDisplayed(addTitles.getIosSearchTitle(), 30, 2));
	}
	
	
	@When("User taps on the Add Titles CTA Then User should be able to view the carousel of titles, with the Favorites carousel displayed")
	public void user_taps_on_the_Add_Titles_CTA_Then_User_should_be_able_to_view_the_carousel_of_titles_with_the_Favorites_carousel_displayed() {
	    
		Assert.assertTrue(fluentWaitDisplayed(addTitles.getIosYourFavorite(), 30, 2));
		if(addTitles.favTitleBooklist.size()!=0)
		for (int i = 0; i < addTitles.favTitleBooklist.size(); i++) {
			Assert.assertTrue(addTitles.favTitleBooklist.get(i).isDisplayed());
		}
		System.out.println("Fav Title list is Displyed");
		horizontalSwipe(addTitles.favTitleBooklist);
	}

	@When("User should be able to view the Search bar to enter the title name to be searched")
	public void user_should_be_able_to_view_the_Search_bar_to_enter_the_title_name_to_be_searched() {
		Assert.assertEquals(true,fluentWaitDisplayed(searchTitles.searchTextBox,30,2));
	}
	
	@Then("User should be able to view the carousel of titles, with the Recommendation carousel displayed at the top")
	public void user_should_be_able_to_view_the_carousel_of_titles_with_the_Recommendation_carousel_displayed_at_the_top() {
		Assert.assertTrue(fluentWaitDisplayed(addTitles.getIosRecommendationsText(), 30, 2));
		if(addTitles.recommendTitleBooklist.size()!=0)
		for (int i = 0; i < addTitles.recommendTitleBooklist.size(); i++) {
			Assert.assertTrue(addTitles.recommendTitleBooklist.get(i).isDisplayed());
		}
		logger.info("Recommended title are displayed");
	}

	@Then("Check with adding more than {int} carosels and how the performance is")
	public void check_with_adding_more_than_carosels_and_how_the_performance_is(Integer int1) {
		if(addTitles.recommendTitleBooklist.size()!=0)
			for (int i = 0; i < addTitles.recommendTitleBooklist.size(); i++) {
				horizontalSwipe(addTitles.recommendTitleBooklist);
				Assert.assertTrue(addTitles.recommendTitleBooklist.get(i).isDisplayed());
			}
		logger.info("Recommended title carousel list is displyed");	
		
	}
	@Then("User should be able to view the carousel of titles, with the Favorites carousel displayed")
	public void user_should_be_able_to_view_the_carousel_of_titles_with_the_Favorites_carousel_displayed() {	 
		Assert.assertTrue(fluentWaitDisplayed(addTitles.getIosYourFavorite(), 30, 2));
		if(addTitles.favTitleBooklist.size()!=0)
		for (int i = 0; i < addTitles.favTitleBooklist.size(); i++) {
			horizontalSwipe(addTitles.favTitleBooklist);
			Assert.assertTrue(addTitles.favTitleBooklist.get(i).isDisplayed());
		}
		System.out.println("Fav Title list is Displyed");
	}

}
