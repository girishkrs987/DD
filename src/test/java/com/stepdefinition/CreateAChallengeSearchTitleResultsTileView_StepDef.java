package com.stepdefinition;

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

public class CreateAChallengeSearchTitleResultsTileView_StepDef extends CapabilitiesAndWebDriverUtils {
	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateAChallengeSearchTitleResultsTileView searchResultTileView = new CreateAChallengeSearchTitleResultsTileView();
	CreateChallengeSearchTitleResultsSortFilter sortandfilter = new CreateChallengeSearchTitleResultsSortFilter();

	@When("User taps on the tile view icon to view the search results in the form of tiles")
	public void user_taps_on_the_tile_view_icon_to_view_the_search_results_in_the_form_of_tiles() throws InterruptedException {
		Thread.sleep(10000);

		ClickOnMobileElement(searchResultTileView.getListView());
	}

	@Then("User should be able to view and tap on the option to display the search results as a list")
	public void user_should_be_able_to_view_and_tap_on_the_option_to_display_the_search_results_as_a_list() throws InterruptedException {
		Thread.sleep(10000);

		ClickOnMobileElement(searchResultTileView.getListView());
	}

	@Then("User should be able to tap on the Sort & Filter CTA and view the sort and filter screen")
	public void user_should_be_able_to_tap_on_the_Sort_Filter_CTA_and_view_the_sort_and_filter_screen() {

		ClickOnMobileElement(searchResultTileView.getSortandFilter());
		Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosSortByTxt(), 30, 1));

	}

	@Then("Application should display {int} search results at a time, with the next {int} results displayed when the user taps on Load More CTA at the bottom of the listing")
	public void application_should_display_search_results_at_a_time_with_the_next_results_displayed_when_the_user_taps_on_Load_More_CTA_at_the_bottom_of_the_listing(
			Integer int1, Integer int2) {

	}
	

	@Then("User should be able to view the pagination details of the search results, along with the search input string or suggestion")
	public void user_should_be_able_to_view_the_pagination_details_of_the_search_results_along_with_the_search_input_string_or_suggestion() {

	}

}
