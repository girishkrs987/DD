package com.stepdefinition;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeSearchTitleResultsTileView;
import com.pom.CreateChallengeAddTitles;
import com.pom.CreateChallengeSearchTitleResultsMoreCTA;
import com.pom.CreateChallengeSearchTitleResultsSortFilter;
import com.pom.CreateaChallengeSearchTitleResultsListView;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;

public class CreateChallengeSearchTitleResultsMoreCTA_StepDef extends CapabilitiesAndWebDriverUtils{
	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateAChallengeSearchTitleResultsTileView searchResultTileView = new CreateAChallengeSearchTitleResultsTileView();
	CreateChallengeSearchTitleResultsSortFilter sortandfilter = new CreateChallengeSearchTitleResultsSortFilter();
	CreateChallengeSearchTitleResultsMoreCTA searchResultMoreCTA = new CreateChallengeSearchTitleResultsMoreCTA();
	
	Date date=java.util.Calendar.getInstance().getTime();  
	
	@When("User is on the Search Title Results Screen")
	public void user_is_on_the_Search_Title_Results_Screen() throws IOException {
		ClickOnWebElement(bookClubLandingScreeen.getBookClubOption());
		ClickOnWebElement(bookClubLandingScreeen.getAddCTA());
		SendKeysOnWebElement(createBasicChallenge.getChallengeName(),"QA testing"+date);
		hideMobileKeyboard();
		swipeDown();
		ClickOnWebElement(createBasicChallenge.getAddTitlesCTA());
		SendKeysOnWebElement(searchTitles.searchTextBox, getData("SearchInput"));
		searchTitles.searchTextBox.sendKeys(Keys.ENTER);
//		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.SEARCH));
		logger.info("Enter key pressed");
		waitFor(3000);
//		ClickOnWebElement(searchTitles.getIosHorryPotter(), 30, 2);
	}

	@When("User taps on the More icon on a particular title")
	public void user_taps_on_the_More_icon_on_a_particular_title() {
	    
		searchResultMoreCTA.getMoreOptions().get(0).click();
		
	}

	@Then("User should be able to view the more menu for the corresponding title")
	public void user_should_be_able_to_view_the_more_menu_for_the_corresponding_title() {
	    
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultMoreCTA.getAddToChallenge(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultMoreCTA.getCheckoutBtn(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultMoreCTA.getReadOnlineBtn(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultMoreCTA.getCancelBtn(),30,2));
		
	}

	@Then("User Can able view the more options Add to challenge checkout readonline cancel button")
	public void user_Can_able_view_the_more_options_Add_to_challenge_checkout_readonline_cancel_button() {
	 
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultMoreCTA.getAddToChallenge(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultMoreCTA.getCheckoutBtn(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultMoreCTA.getReadOnlineBtn(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultMoreCTA.getCancelBtn(),30,2));

	}
	
	@Then("User should be able to tap on the Add to Challenge option to add the title to the Reading challenge and be navigated back to the Search Title Results Screen")
	public void user_should_be_able_to_tap_on_the_Add_to_Challenge_option_to_add_the_title_to_the_Reading_challenge_and_be_navigated_back_to_the_Search_Title_Results_Screen() {
	   
		ClickOnWebElement(searchResultMoreCTA.getAddToChallenge());
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultTileView.getIosdoneBtn(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultTileView.getIosgridView(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultTileView.getSortandFilter(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(searchResultTileView.getSearchResults(),30,2));
		List<MobileElement> selectedBooks = searchResultMoreCTA.getSelectedBooks();
		if(selectedBooks.size()!=0) {
			for(int i=0;i<selectedBooks.size();i++) {	
				MobileElement book = selectedBooks.get(i);
				Assert.assertEquals(true, fluentWaitDisplayed(book, 30, 2));
			}
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@Then("User should be able to tap on the Read Online option and be navigated to the eBook reader screen with the book opened")
	public void user_should_be_able_to_tap_on_the_Read_Online_option_and_be_navigated_to_the_eBook_reader_screen_with_the_book_opened() {
	   
			//blocked aplication is not navigating to readonline page
	}

}
