package com.stepdefinition;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookClubLandingScreen_StepDef extends CapabilitiesAndWebDriverUtils {

BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	
	@Given("User is on the Home screen or any other landing screen")
	public void user_is_on_the_Home_screen_or_any_other_landing_screen() throws IOException, InterruptedException {

			
			WaitForMobileElement(bookClubLandingScreeen.geteBooktext());
		
	}

	@When("User clicks on the Book Club menu item on the Bottom Navigation Menu")
	public void user_clicks_on_the_Book_Club_menu_item_on_the_Bottom_Navigation_Menu() throws IOException {

		
			ClickOnMobileElement(bookClubLandingScreeen.getBookClubOption());
		

	}

	@Then("User should be navigated to the Book Club Landing screen")
	public void user_should_be_navigated_to_the_Book_Club_Landing_screen() {
	
		WaitForMobileElement(bookClubLandingScreeen.getBreadCrumBookClub());

	}

	@Then("User should be able to view the Reading Challenges Reading Programs and Public Programs tabs")
	public void user_should_be_able_to_view_the_Reading_Challenges_Reading_Programs_and_Public_Programs_tabs() {
	
		WaitForMobileElement(bookClubLandingScreeen.getChallenges());
		WaitForMobileElement(bookClubLandingScreeen.getPrograms());
		WaitForMobileElement(bookClubLandingScreeen.getPublicPrograms());
	}

	@Then("User should be able to view the Challenges tab open by default")
	public void user_should_be_able_to_view_the_Challenges_tab_open_by_default() {
	
		isSelected(bookClubLandingScreeen.getChallenges());

	}

	@Then("User should be able to view list of challenges grouped as Active Challenges Draft Challenges and Closed Challenges")
	public void user_should_be_able_to_view_list_of_challenges_grouped_as_Active_Challenges_Draft_Challenges_and_Closed_Challenges() {

	}

	@Then("User should be only able to see challenges created by that user participating in invited to and completed by the user")
	public void user_should_be_only_able_to_see_challenges_created_by_that_user_participating_in_invited_to_and_completed_by_the_user() {

	}

	@Then("User should be able to view the option to Create a new Reading Challenge")
	public void user_should_be_able_to_view_the_option_to_Create_a_new_Reading_Challenge() {
	
		WaitForMobileElement(bookClubLandingScreeen.getAddCTA());

	}

	@Then("User should be able to view the label Reading Challenge that specifies this is a reading challenge")
	public void user_should_be_able_to_view_the_label_Reading_Challenge_that_specifies_this_is_a_reading_challenge() {
	
		WaitForMobileElement(bookClubLandingScreeen.getReadTextone());

	}

	@Then("User should be able to view the default icon specified for reading challenges")
	public void user_should_be_able_to_view_the_default_icon_specified_for_reading_challenges() {
	
				WaitForMobileElement(bookClubLandingScreeen.getReadChallengeDefaultIcon());// image

	}

	@Then("User should be able to view the challenge name")
	public void user_should_be_able_to_view_the_challenge_name() {
	
		WaitForMobileElement(bookClubLandingScreeen.getChallengeName());

	}

	@Then("User should be able to view read by date for the reading challenge")
	public void user_should_be_able_to_view_read_by_date_for_the_reading_challenge() {
		
		WaitForMobileElement(bookClubLandingScreeen.getReadTextone());

	}

	@Then("User should be able to view the title cover")
	public void user_should_be_able_to_view_the_title_cover() {
	
		WaitForMobileElement(bookClubLandingScreeen.getBookImageone());

	}

	@Then("Progress percentage should be calculated based on the book completion in the challenge If there are {int} books in the challenge and user completes reading one book the completion percentage is {int}")
	public void progress_percentage_should_be_calculated_based_on_the_book_completion_in_the_challenge_If_there_are_books_in_the_challenge_and_user_completes_reading_one_book_the_completion_percentage_is(
			Integer int1, Integer int2) {
	
		WaitForMobileElement(bookClubLandingScreeen.getProgressbartwo());
	}

	@Then("Application should be able to display the percentage ranging from {int} to {int} based on the reading progress")
	public void application_should_be_able_to_display_the_percentage_ranging_from_to_based_on_the_reading_progress(
			Integer int1, Integer int2) {
	
		WaitForMobileElement(bookClubLandingScreeen.getProgressTexttwo());
	}

	@Then("User should get to know the completion status from the icon where the percentage is displayed Circle should be colored appropriately")
	public void user_should_get_to_know_the_completion_status_from_the_icon_where_the_percentage_is_displayed_Circle_should_be_colored_appropriately() {

	}

	@Then("User should be able to view the time spent by the user in the specific challenge or program")
	public void user_should_be_able_to_view_the_time_spent_by_the_user_in_the_specific_challenge_or_program() {
	
		swipeDown();
		WaitForMobileElement(bookClubLandingScreeen.getHoursSpenttwo());

	}

	@Then("Application should display the time in HHMM format")
	public void application_should_display_the_time_in_HHMM_format() throws ParseException {
		
		// swipeDown();
		String spentHours = bookClubLandingScreeen.getHoursSpenttwo().getText();
		boolean valid = false;
		SimpleDateFormat s = new SimpleDateFormat("hh:mm");
		try {
			Date hours = s.parse(spentHours);
			String formatValid = s.format(hours);
			System.out.println("valid format:" + formatValid);
			valid = true;

		} catch (ParseException e) {

			valid = false;
		}

		Assert.assertEquals(valid, true);

	}

}
