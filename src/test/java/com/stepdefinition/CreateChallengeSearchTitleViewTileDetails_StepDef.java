package com.stepdefinition;

import org.junit.Assert;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeInviteRecentlySearchedFriends;
import com.pom.CreateAChallengeSearchTitleResultsTileView;
import com.pom.CreateChallengeAddTitles;
import com.pom.CreateChallengeSearchTitleViewTitleDetails;
import com.pom.CreateaChallengeSearchTitleResultsListView;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateChallengeSearchTitleViewTileDetails_StepDef extends CapabilitiesAndWebDriverUtils{

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeInviteRecentlySearchedFriends searchfriends = new CreateAChallengeInviteRecentlySearchedFriends();
	CreateaChallengeSearchTitleResultsListView searchTitles = new CreateaChallengeSearchTitleResultsListView();
	CreateChallengeAddTitles addTitles = new CreateChallengeAddTitles();
	CreateAChallengeSearchTitleResultsTileView searchResultTileView = new CreateAChallengeSearchTitleResultsTileView();
	CreateChallengeSearchTitleViewTitleDetails searchTitleViewTitleDetails  = new CreateChallengeSearchTitleViewTitleDetails();
	
	@When("User taps on a title in the listing section")
	public void user_taps_on_a_title_in_the_listing_section() {
	
		if (searchResultTileView.getBookName().size()!=0) {	
			Assert.assertTrue(searchResultTileView.getBookName().get(0).isDisplayed());
			searchResultTileView.getBookName().get(0).click();
		}
		else {
			System.out.println("No search result listed");
			Assert.assertTrue(searchResultTileView.getBookName().get(0).isDisplayed());
		}
	}

	@Then("User should be able to view the Title details bottom drawer")
	public void user_should_be_able_to_view_the_Title_details_bottom_drawer() {
		Assert.assertEquals(searchTitleViewTitleDetails.getTitleName().isDisplayed(),true);
		swipeDown();
	}

	@Then("User should be able to view the title details such as Title Image Material Type icon Author Name Title Name Ratings Text to Speech capability Favorite icon")
	public void user_should_be_able_to_view_the_title_details_such_as_Title_Image_Material_Type_icon_Author_Name_Title_Name_Ratings_Text_to_Speech_capability_Favorite_icon() {
				
				Assert.assertEquals(searchTitleViewTitleDetails.getTitleName().isDisplayed(),true);
				Assert.assertEquals(searchTitleViewTitleDetails.getAuthorName().isDisplayed(),true);
				Assert.assertEquals(searchTitleViewTitleDetails.getMaterialTypeIcon().isDisplayed(),true);
				Assert.assertEquals(searchTitleViewTitleDetails.getTitleimage().isDisplayed(),true);
				Assert.assertEquals(searchTitleViewTitleDetails.getTextToSpeech().isDisplayed(),true);
				Assert.assertEquals(searchTitleViewTitleDetails.getRatingStar().isDisplayed(),true);
				
	}

	@Then("User should be able to tap on the Add to Challenge CTA to add the title to the challenge")
	public void user_should_be_able_to_tap_on_the_Add_to_Challenge_CTA_to_add_the_title_to_the_challenge() {
			Assert.assertEquals(searchTitleViewTitleDetails.getAddToChallenge().isDisplayed(),true);
			searchTitleViewTitleDetails.getAddToChallenge().click();
	}

	@Then("Application should replace the Add to Challenge CTA text with Remove from Challenge once a user adds a title to the challenge")
	public void application_should_replace_the_Add_to_Challenge_CTA_text_with_Remove_from_Challenge_once_a_user_adds_a_title_to_the_challenge() {
		String buttonText = searchTitleViewTitleDetails.getAddToChallenge().getText();
		Assert.assertTrue(buttonText.equalsIgnoreCase("Remove From Challenge"));
	}

	@Then("User should be able to tap on Checkout or Reserve for a particular material type and check out a copy or place a hold on a copy of the title")
	public void user_should_be_able_to_tap_on_Checkout_or_Reserve_for_a_particular_material_type_and_check_out_a_copy_or_place_a_hold_on_a_copy_of_the_title() {
		Assert.assertTrue(searchTitleViewTitleDetails.getCheckOut().isDisplayed());
		searchTitleViewTitleDetails.getCheckOut().click();
	}

	@Then("User should be able to tap on More CTA to be navigated to the title details screen")
	public void user_should_be_able_to_tap_on_More_CTA_to_be_navigated_to_the_title_details_screen() {
	   
	    
	}

}
