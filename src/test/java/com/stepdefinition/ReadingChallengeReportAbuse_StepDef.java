package com.stepdefinition;

import org.junit.Assert;
import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeCreatorRCDetailsScreen;
import com.pom.CreateAChallengeCreatorRCDetailsScreenMoreIcon;
import com.pom.ReadingChallengeReportAbuse;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class ReadingChallengeReportAbuse_StepDef extends CapabilitiesAndWebDriverUtils {
	AppiumDriver appiumdriver;

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeCreatorRCDetailsScreen creatorRCDetailsScreeen = new CreateAChallengeCreatorRCDetailsScreen();
	ReadingChallengeReportAbuse reportabuse = new ReadingChallengeReportAbuse();

	@When("User is on the more menu options of Reading Challenge details screen")
	public void user_is_on_the_more_menu_options_of_Reading_Challenge_details_screen() throws InterruptedException {

		ClickOnMobileElement(bookClubLandingScreeen.getBookClubOption());
		scrollAndClick(createBasicChallenge.searchChallengeName);
		ClickOnMobileElement(creatorRCDetailsScreeen.moreIcon);
		Thread.sleep(2000);
	}

	private void scrollAndClick(io.appium.java_client.MobileElement searchChallengeName) {
		// TODO Auto-generated method stub
		
	}

	@When("User taps on Report Abuse CTA")
	public void user_taps_on_Report_Abuse_CTA() {

		ClickOnMobileElement(ReadingChallengeReportAbuse.reportAbuse);

	}

	@Then("User should be navigated to the Report Abuse screen")
	public void user_should_be_navigated_to_the_Report_Abuse_screen() throws InterruptedException {

		Assert.assertEquals(fluentWaitDisplayed(reportabuse.reportAbuseHeader, 30, 2), true);

	}

	@Then("User should be able to view brief description for reporting the abuse")
	public void user_should_be_able_to_view_brief_description_for_reporting_the_abuse() {

		Assert.assertEquals(fluentWaitDisplayed(reportabuse.viewBriefDescription, 30, 2), true);

	}

	@Then("User should be able to enter grievance details for the abuse with maximum and minimum character limit of X")
	public void user_should_be_able_to_enter_grievance_details_for_the_abuse_with_maximum_minimum_character_limit_of_X()
			throws InterruptedException {

		
		SendKeysOnMobileElement(ReadingChallengeReportAbuse.enterconcernTxtBox, RandomStringGenerate(5));
		ClickOnMobileElement(ReadingChallengeReportAbuse.viewBriefDescription);// for hiding keyboard
		Assert.assertEquals(ReadingChallengeReportAbuse.submitButton.isEnabled(), false);
		ReadingChallengeReportAbuse.textboxclear.clear();
		SendKeysOnMobileElement(ReadingChallengeReportAbuse.enterconcernTxtBox, RandomStringGenerate(15));
		ClickOnMobileElement(ReadingChallengeReportAbuse.viewBriefDescription);
		Assert.assertEquals(ReadingChallengeReportAbuse.submitButton.isEnabled(), true);
		ReadingChallengeReportAbuse.textboxclear.clear();
		SendKeysOnMobileElement(ReadingChallengeReportAbuse.enterconcernTxtBox, RandomStringGenerate(100));
		ClickOnMobileElement(ReadingChallengeReportAbuse.viewBriefDescription);
		Assert.assertEquals(ReadingChallengeReportAbuse.submitButton.isEnabled(), true);
		Assert.assertEquals(fluentWaitDisplayed(bookClubLandingScreeen.getAddCTA(), 30, 2), true);


	}

	@Then("User should be able to submit the abuse report")
	public void user_should_be_able_to_submit_the_abuse_report() {

		ClickOnMobileElement(ReadingChallengeReportAbuse.submitButton);
	}

	@Then("User should get confirmation message on successful submission of abuse report")
	public void user_should_get_confirmation_message_on_successful_submission_of_abuse_report() {

	
	}

	@Then("User should be able to tap on back button to navigate back to the Reading Challenge details screen")
	public void user_should_be_able_to_tap_on_back_button_to_navigate_back_to_the_Reading_Challenge_details_screen()
			throws InterruptedException {

		ClickOnMobileElement(ReadingChallengeReportAbuse.backIcon);
		//assertEquals(creatorRCDetailsScreeen.getChallengeName());
		Assert.assertTrue(creatorRCDetailsScreeen.getReadByDate().isDisplayed());
		Assert.assertTrue(creatorRCDetailsScreeen.moreIcon.isDisplayed());

	}
@When("User taps the Cancel button and it navigate to the Rc details screen")
	public void user_taps_the_Cancel_button_and_it_navigate_to_the_Rc_details_screen() {
	
	ClickOnMobileElement(CreateAChallengeCreatorRCDetailsScreenMoreIcon.cancel);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.readByDate, 30, 2), true);
		Assert.assertEquals(fluentWaitDisplayed(creatorRCDetailsScreeen.readImage, 30, 2), true);

	}

	@Then("User is navigated back to the Reading Challenge details screen")
	public void user_is_navigated_back_to_the_Reading_Challenge_details_screen() {

	}
}
