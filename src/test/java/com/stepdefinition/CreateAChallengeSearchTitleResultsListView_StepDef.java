package com.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeSearchTitleResultsTileView;
import com.pom.CreateChallengeAddTitles;
import com.pom.CreateChallengeSearchTitleResultsSortFilter;
import com.pom.CreateaChallengeSearchTitleResultsListView;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAChallengeSearchTitleResultsListView_StepDef extends CapabilitiesAndWebDriverUtils{
	
	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateAChallengeSearchTitleResultsTileView searchResultTileView = new CreateAChallengeSearchTitleResultsTileView();
	CreateChallengeSearchTitleResultsSortFilter sortandfilter = new CreateChallengeSearchTitleResultsSortFilter();
	
	@When("User is on the Add Titles Screen")
	public void user_is_on_the_Add_Titles_Screen() {
		
		ClickOnMobileElement(bookClubLandingScreeen.getBookClubOption());
		ClickOnMobileElement(bookClubLandingScreeen.getAddCTA());
		swipeDown();
		swipeDown();
		ClickOnMobileElement(createBasicChallenge.getAddTitlesCTA());		
	}

	@When("User performs a search by entering a search input string and tapping the search icon or selecting a search suggestion")
	public void user_performs_a_search_by_entering_a_search_input_string_and_tapping_the_search_icon_or_selecting_a_search_suggestion() throws IOException {
		
		SendKeysOnMobileElement(searchTitles.searchTextBox,getData("SearchInput"));
		searchTitles.searchTextBox.sendKeys(Keys.ENTER); 
	}

	@Then("User should be able to view and tap on the option to display the search results as tiles")
	public void user_should_be_able_to_view_and_tap_on_the_option_to_display_the_search_results_as_tiles() {
	   
		ClickOnMobileElement(searchResultTileView.getListView());
		
	}

	@Then("User should be able to tap on the Sort & Filter icon and view the sort and filter screen")
	public void user_should_be_able_to_tap_on_the_Sort_Filter_icon_and_view_the_sort_and_filter_screen() {
	   
	    ClickOnMobileElement(searchResultTileView.getSortandFilter());
	    Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosSortByTxt(), 30, 1));	
	}
}
