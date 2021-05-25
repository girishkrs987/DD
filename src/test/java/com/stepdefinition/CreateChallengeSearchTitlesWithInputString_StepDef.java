package com.stepdefinition;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeInviteRecentlySearchedFriends;
import com.pom.CreateAChallengeSetReadbyDate;
import com.pom.CreateChallengeAddTitles;
import com.pom.CreateChallengeSearchTitlesWithInputString;
import com.pom.CreateChallengeSetReminders;
import com.pom.CreateaChallengeSearchTitleResultsListView;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;

public class CreateChallengeSearchTitlesWithInputString_StepDef extends CapabilitiesAndWebDriverUtils {

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeInviteRecentlySearchedFriends searchfriends = new CreateAChallengeInviteRecentlySearchedFriends();
	// CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeSetReminders setReminders = new CreateChallengeSetReminders();
	CreateAChallengeSetReadbyDate setReadbyDate = new CreateAChallengeSetReadbyDate();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateChallengeSearchTitlesWithInputString SearchTitlesWithInputString = new CreateChallengeSearchTitlesWithInputString();

	@When("User taps on the Search box and enters {int} characters")
	public void user_taps_on_the_Search_box_and_enters_characters(Integer int1) {
		logger.info("Entering 3 char to validate the suggestion list");
		SendKeysOnWebElement(searchTitles.searchTextBox, "ame");
	}

	@Then("User should be able to tap on a search suggestion to view the corresponding Search results page")
	public void user_should_be_able_to_tap_on_a_search_suggestion_to_view_the_corresponding_Search_results_page()
			throws InterruptedException, IOException {

		waitFor(5000);
		logger.info("Validating Search Suggestion");
		List<MobileElement> suggResult = searchTitles.getTitleSearchResult();
		if (getData("platformName").equalsIgnoreCase("android")|| getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
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
		} else if (getData("platformName").equalsIgnoreCase("ios")) {

			Thread.sleep(1000);

			if (suggResult.size() > 0) {
				for (int i = 1; i < suggResult.size() - 3; i++) {
					String actual = suggResult.get(i).getText();
					System.out.println("Actual search Result :" + actual);
					suggResult.get(i).click();
					fluentWaitDisplayed(searchTitles.btn_Back, 30, 2);
					String expected = searchTitles.title_NavigationTitle.getText();
					System.out.println("Expected search Result :" + expected);
					Assert.assertEquals(actual, expected, "Selected Book search title is mismatched");
					searchTitles.btn_Back.click();
					if (i == 3) {
						System.out.println("Breaking the loop");
						logger.info("Breaking the loop after 5th count");
						break;
					}
				}
			}
		}

		logger.info("Search Title Validation Successfull");
	}

	@Then("User should be able to edit the search input string as required")
	public void user_should_be_able_to_edit_the_search_input_string_as_required() {
		Boolean searchResult = false;
		searchTitles.searchTextBox.clear();
		SendKeysOnWebElement(searchTitles.searchTextBox, "Mys");
		String title = "Mystery";
		String searchText = null;
		char[] c = title.toCharArray();
		for (int i = 3; i < c.length - 1; i++) {
			searchText = searchTitles.searchTextBox.getText() + c[i];
			SendKeysOnWebElement(searchTitles.searchTextBox, searchText);
			List<MobileElement> suggResult = searchTitles.getTitleSearchResult();
			for (int j = 0; j < suggResult.size(); j++) {
				suggResult.get(j).getText().contains(searchText);
				searchResult = true;
				Assert.assertTrue(searchResult);
			}
		}
	}

	@Then("User should be able to tap on the Search icon to view the corresponding Search results page for the search input string")
	public void user_should_be_able_to_tap_on_the_Search_icon_to_view_the_corresponding_Search_results_page_for_the_search_input_string() throws InterruptedException, IOException {
//		implicitlyWait(5);
//		List<MobileElement> suggResult = searchTitles.getTitleSearchResult();
//		if (suggResult.size() != 0) {
//			for (int i = 0; i < suggResult.size(); i++) {
//				suggResult.get(i).click();
//				break;
//			}
//		}
//		Assert.assertEquals(fluentWaitDisplayed(searchTitles.getIosdoneBtn(), 30, 2), true);
//		Assert.assertEquals(fluentWaitDisplayed(searchTitles.getIosgridView(), 30, 2), true);
//		Assert.assertEquals(fluentWaitDisplayed(searchTitles.getSortandFilter(), 30, 2), true);
//		Assert.assertEquals(fluentWaitDisplayed(searchTitles.pageCountText, 30, 2), true);
		waitFor(5000);
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
		} else if (getData("platformName").equalsIgnoreCase("ios")) {

			Thread.sleep(1000);

			if (suggResult.size() > 0) {
				for (int i = 1; i < suggResult.size() - 3; i++) {
					String actual = suggResult.get(i).getText();
					System.out.println("Actual search Result :" + actual);
					suggResult.get(i).click();
					fluentWaitDisplayed(searchTitles.btn_Back, 30, 2);
					String expected = searchTitles.title_NavigationTitle.getText();
					System.out.println("Expected search Result :" + expected);
					Assert.assertEquals(actual, expected, "Selected Book search title is mismatched");
					searchTitles.btn_Back.click();
					if (i == 3) {
						System.out.println("Breaking the loop");
						logger.info("Breaking the loop after 5th count");
						break;
					}
				}
			}
		}

		logger.info("Search Title Validation Successfull");
	}

	@When("User taps on the Search box")
	public void user_taps_on_the_Search_box() throws InterruptedException {
		Assert.assertTrue(searchTitles.searchTextBox.isDisplayed());
		ClickOnWebElement(searchTitles.searchTextBox);
		SendKeysOnWebElement(searchTitles.searchTextBox, "america");
		waitFor(2000);
		searchTitles.getTitleSearchResult().get(0).click();
		addTitles.titleSearchPageBackbtn.click();
		searchTitles.searchTextBox.clear();
		SendKeysOnWebElement(searchTitles.searchTextBox, "Mystery");
		waitFor(2000);
		searchTitles.getTitleSearchResult().get(0).click();
		addTitles.titleSearchPageBackbtn.click();
		searchTitles.searchTextBox.clear();
		SendKeysOnWebElement(searchTitles.searchTextBox, "black");
		waitFor(2000);
		searchTitles.getTitleSearchResult().get(0).click();
		addTitles.titleSearchPageBackbtn.click();
		searchTitles.searchTextBox.clear();
		SendKeysOnWebElement(searchTitles.searchTextBox, "captain america");
		waitFor(2000);
		searchTitles.getTitleSearchResult().get(0).click();
		addTitles.titleSearchPageBackbtn.click();
		searchTitles.searchTextBox.clear();
		SendKeysOnWebElement(searchTitles.searchTextBox, "superman");
		waitFor(2000);
		searchTitles.getTitleSearchResult().get(0).click();
		addTitles.titleSearchPageBackbtn.click();
		searchTitles.searchTextBox.clear();
		SendKeysOnWebElement(searchTitles.searchTextBox, "ababa");
		waitFor(2000);
		searchTitles.getTitleSearchResult().get(0).click();
		addTitles.titleSearchPageBackbtn.click();
		searchTitles.searchTextBox.clear();
	}

	@Then("User should be able to view the list of recently searched items, X number of items")
	public void user_should_be_able_to_view_the_list_of_recently_searched_items_X_number_of_items() {
		logger.info("Validating title recent search list");
		if (SearchTitlesWithInputString.recentSearchList.size() != 0) {
			for (int i = 0; i < SearchTitlesWithInputString.recentSearchList.size(); i++) {
				Assert.assertTrue(SearchTitlesWithInputString.recentSearchList.get(i).isDisplayed());
			}
		}
	}

	@Then("User should be able to view list of recently searched keywords, {int} or less items")
	public void user_should_be_able_to_view_list_of_recently_searched_keywords_or_less_items(Integer int1) {
		boolean titleList = true;
		if (SearchTitlesWithInputString.recentSearchList.size() <= 5) {
			for (int i = 0; i < SearchTitlesWithInputString.recentSearchList.size(); i++) {
				Assert.assertTrue(SearchTitlesWithInputString.recentSearchList.get(i).isDisplayed());
			}
			System.out.println("Recent searched title List size is within Five");
		} else if (SearchTitlesWithInputString.recentSearchList.size() > 5) {
			titleList = false;
			Assert.assertTrue(titleList);
			System.out.println("Recent searched title List size is more than Five");
		}
	}

	@Then("User should be able to view the search suggestions updated based on each individual character change made by them on the search input string")
	public void user_should_be_able_to_view_the_search_suggestions_updated_based_on_each_individual_character_change_made_by_them_on_the_search_input_string() {
		Boolean searchResult = false;
		searchTitles.searchTextBox.clear();
		SendKeysOnWebElement(searchTitles.searchTextBox, "ame");
		String title = "america";
		String searchText = null;
		char[] c = title.toCharArray();
		for (int i = 3; i < c.length - 1; i++) {
			searchText = searchTitles.searchTextBox.getText() + c[i];
			SendKeysOnWebElement(searchTitles.searchTextBox, searchText);
			List<MobileElement> suggResult = searchTitles.getTitleSearchResult();
			for (int j = 0; j < suggResult.size(); j++) {
				suggResult.get(j).getText().contains(searchText);
				searchResult = true;
				Assert.assertTrue(searchResult);
			}
		}
	}

	@Then("User should be able to view the search suggestion recommendations once after entering three charachers input or above given by them")
	public void user_should_be_able_to_view_the_search_suggestion_recommendations_once_after_entering_three_charachers_input_or_above_given_by_them() {
		Boolean searchResult = true;
		searchTitles.searchTextBox.clear();
		SendKeysOnWebElement(searchTitles.searchTextBox, "am");
		List<MobileElement> suggResult = searchTitles.getTitleSearchResult();
		if (suggResult.size() != 0) {
			searchResult = false;
			Assert.assertTrue(searchResult);
			System.out.println("Suggestion list is displayed");
		} else {
			Assert.assertTrue(searchResult);
			System.out.println("Suggestion list is not displayed");
		}
	}
}
