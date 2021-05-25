package com.stepdefinition;

import java.util.List;

import org.testng.Assert;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeInviteRecentlySearchedFriends;
import com.pom.CreateAChallengeSearchTitleResultsTileView;
import com.pom.CreateAChallengeSearchTitleResultsTitlesAdded;
import com.pom.CreateAChallengeSetReadbyDate;
import com.pom.CreateChallengeAddTitles;
import com.pom.CreateChallengeSearchTitleResultsMoreCTA;
import com.pom.CreateChallengeSetReminders;
import com.pom.CreateaChallengeSearchTitleResultsListView;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;

public class CreateAChallengeSearchTitleResultsTitlesAdded_StepDef extends CapabilitiesAndWebDriverUtils {

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateAChallengeSearchTitleResultsTileView searchResultTileView = new CreateAChallengeSearchTitleResultsTileView();
	CreateChallengeSearchTitleResultsMoreCTA searchResultMoreCTA = new CreateChallengeSearchTitleResultsMoreCTA();
	CreateAChallengeSearchTitleResultsTitlesAdded titlesAdded = new CreateAChallengeSearchTitleResultsTitlesAdded();
	
	@When("User adds a title to the Reading Challenge")
	public void user_adds_a_title_to_the_Reading_Challenge() {
//		ClickOnMobileElement(searchTitles.getIosHorryPotter());
		ClickOnMobileElement(searchResultTileView.getListView());
		waitFor(6000);
		logger.info("Adding titles to the challenge");
		List<MobileElement> moreOptions = searchResultMoreCTA.getMoreOptions();
		for (int j = 0; j < 2; j++) {
			swipeDown();
			for (int i = 0; i < moreOptions.size(); i++) {
				moreOptions.get(i).click();
				ClickOnMobileElement(searchResultMoreCTA.getAddToChallenge());
			}
		}
	}

	@Then("User should be able to view each title added to the challenge at the top of the Search Title Results listing section")
	public void user_should_be_able_to_view_each_title_added_to_the_challenge_at_the_top_of_the_Search_Title_Results_listing_section() {

		List<MobileElement> selectedBooks = searchResultMoreCTA.getSelectedBooks();
		if (selectedBooks.size() != 0) {
			for (int i = 0; i < selectedBooks.size(); i++) {
				MobileElement book = selectedBooks.get(i);
				Assert.assertEquals(true, fluentWaitDisplayed(book, 30, 2));
			}
			logger.info("Selected books diaplayed at the top of the page");
		}
		else {
			logger.info("Selected books are not diaplayed at the top of the page");
			Assert.assertTrue(false);
		}
	}

	@Then("User should be able to view each title added to the challenge in the form of a carousel if number of titles are more than that can be shown in single row")
	public void user_should_be_able_to_view_each_title_added_to_the_challenge_in_the_form_of_a_carousel_if_number_of_titles_are_more_than_that_can_be_shown_in_single_row() {

		List<MobileElement> selectedBooks = searchResultMoreCTA.getSelectedBooks();
		for (int i = 0; i < selectedBooks.size(); i++) {
			horizontalSwipe(searchResultMoreCTA.getSelectedBooks());
		}
		logger.info("Caurosal validation");
	}

	@Then("User should be able to tap on the X icon on each title in the carousel to remove it from the challenge")
	public void user_should_be_able_to_tap_on_the_X_icon_on_each_title_in_the_carousel_to_remove_it_from_the_challenge() {
		Boolean book = true;
		List<MobileElement> bookDisplayXIcon = titlesAdded.bookDisplayXIcon;
		logger.info("Displyed title size: "+bookDisplayXIcon.size());
		int before = bookDisplayXIcon.size();
		for (int i = 0; i <=2; i++) {
			Assert.assertTrue(bookDisplayXIcon.get(i).isDisplayed());
			bookDisplayXIcon.get(i).click();
		}
		int after = bookDisplayXIcon.size();
		if (before==after) {
			book = false;
			Assert.assertTrue(book);
		}
		else {
			logger.info("Titles displayed are removed");
			Assert.assertTrue(book);
		}
	}

	@Then("User should be able to tap on the Done CTA to add the selected titles to the challenge and return to the Create Challenge screen")
	public void user_should_be_able_to_tap_on_the_Done_CTA_to_add_the_selected_titles_to_the_challenge_and_return_to_the_Create_Challenge_screen() {

		ClickOnMobileElement(searchTitles.getIosdoneBtn());
		ClickOnMobileElement(addTitles.getTitleSearchPageBackbtn());
		swipeDown();
		List<MobileElement> addedBooks = createBasicChallenge.getAddedBooks();
		for (int i = 0; i < addedBooks.size(); i++) {
			Assert.assertTrue(createBasicChallenge.getAddedBooks().get(i).isDisplayed());
			horizontalSwipe(createBasicChallenge.getAddedBooks());
		}
		logger.info("Added books are displayed in create challenge Page");
	}
}
