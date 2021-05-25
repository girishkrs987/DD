package com.stepdefinition;

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

public class CreateChallengeSearchTitleResultsSortFilter_StepDef extends CapabilitiesAndWebDriverUtils{

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateAChallengeSearchTitleResultsTileView searchResultTileView = new CreateAChallengeSearchTitleResultsTileView();
	CreateChallengeSearchTitleResultsSortFilter sortandfilter = new CreateChallengeSearchTitleResultsSortFilter();
	CreateChallengeSearchTitleResultsMoreCTA searchResultMoreCTA = new CreateChallengeSearchTitleResultsMoreCTA();

	
	@When("User taps on the sort and filter icon")
	public void user_taps_on_the_sort_and_filter_icon() {
	   
		ClickOnWebElement(searchResultTileView.getSortandFilter());
			    
	}

	@Then("User Navigate to the Sort&Filter Screen")
	public void user_Navigate_to_the_Sort_Filter_Screen() {
		
		Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosSortFilterHeader(), 30, 1));
		Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosSortByTxt(), 30, 1));
		Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosCancel(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosResetAll(),30,2));

	}

	@Then("User Should view the Sort by Options Relavancy Subject Title Author Available Now with right side radio button")
	public void user_Should_view_the_Sort_by_Options_Relavancy_Subject_Title_Author_Available_Now_with_right_side_radio_button() {
		Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosRelevancyRadioBtn(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosSubjectRadioBtn(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosTitleRadioBtn(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosAuthorRadioBtn(),30,2));
		Assert.assertEquals(true, fluentWaitDisplayed(sortandfilter.getIosAvailableRadioBtn(),30,2));
	    
	}

	@Then("User should able to Click the radio button")
	public void user_should_able_to_Click_the_radio_button() {
	   
	    ClickOnWebElement(sortandfilter.getIosSubjectRadioBtn());
	    ClickOnWebElement(sortandfilter.getIosAuthorRadioBtn());
	    ClickOnWebElement(sortandfilter.getIosTitleRadioBtn());
	    ClickOnWebElement(sortandfilter.getIosSubjectRadioBtn());
	    ClickOnWebElement(sortandfilter.getIosSubjectRadioBtn());
	}

	@Then("Relavancy radio button should be default select")
	public void relavancy_radio_button_should_be_default_select() {
	   
		ClickOnWebElement(sortandfilter.getIosResetAll());
		Assert.assertEquals(true, isSelected(sortandfilter.getIosRelevancyRadioBtn()));
	    
	}

	@Then("User Click the any one radio button in sort by options it sholud display related books")
	public void user_Click_the_any_one_radio_button_in_sort_by_options_it_sholud_display_related_books() {
	   
	    
	}

	@Then("User Should View Format Options AudioBook E-Book Lightbox Magazine NewsPaper with right side checkboxes")
	public void user_Should_View_Format_Options_AudioBook_E_Book_Lightbox_Magazine_NewsPaper_with_right_side_checkboxes() {
	   
	    
	}

	@Then("User can able to select more that one checkbox")
	public void user_can_able_to_select_more_that_one_checkbox() {
	   
	    
	}

	@Then("Click AudiobookE-Book it should display only audio,ebook only")
	public void click_AudiobookE_Book_it_should_display_only_audio_ebook_only() {
	   
	    
	}

	@Then("Uncheck audioebook and check  the Newpaper and Magazine it should not display Audiobook E-Book and should  display newpaper and magazine")
	public void uncheck_audioebook_and_check_the_Newpaper_and_Magazine_it_should_not_display_Audiobook_E_Book_and_should_display_newpaper_and_magazine() {
	   
	    
	}

	@Then("Uncheck newspaper and magazine and check  the light box it should display related book  should not display  audiobook ebook newpaper and magazine")
	public void uncheck_newspaper_and_magazine_and_check_the_light_box_it_should_display_related_book_should_not_display_audiobook_ebook_newpaper_and_magazine() {
	   
	    
	}


}
