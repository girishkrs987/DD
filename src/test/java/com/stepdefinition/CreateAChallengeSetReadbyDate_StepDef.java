package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateAChallengeSetReadbyDate;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAChallengeSetReadbyDate_StepDef extends CapabilitiesAndWebDriverUtils {

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateAChallengeSetReadbyDate setReadbyDate = new CreateAChallengeSetReadbyDate();

	@When("User taps on the Set read by date CTA")
	public void user_taps_on_the_Set_read_by_date_CTA() {
		logger.info("Taping on date option");
		ClickOnMobileElement(createBasicChallenge.getDateOpt());
	}

	@Then("User should be able to view the OS native calendar displayed as a bottom drawer")
	public void user_should_be_able_to_view_the_OS_native_calendar_displayed_as_a_bottom_drawer() throws IOException {
		if (getData("platformName").equalsIgnoreCase("android")||getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			logger.info("clicking ok button");
			Assert.assertEquals(fluentWaitDisplayed(setReadbyDate.getCalenderIconOK(), 30, 2), true);
		} else {
			Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getIosDontBtn(), 30, 2), true);
		}
	}

	@Then("User should be able to view the selected end date updated on the Create Challenge screen after selection")
	public void user_should_be_able_to_view_the_selected_end_date_updated_on_the_Create_Challenge_screen_after_selection()
			throws InterruptedException, IOException {
		if (getData("platformName").equalsIgnoreCase("android")||getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			logger.info("Selecting challenge end date");
			ClickOnMobileElement(setReadbyDate.getNextMonthBtn());
			ClickOnMobileElement(setReadbyDate.getEndDate());
			ClickOnMobileElement(setReadbyDate.getCalenderIconOK());
			Assert.assertEquals(fluentWaitDisplayed(createBasicChallenge.getDateOpt(), 20, 2), true);

		}

		else {

			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(0),"June");
			SendKeysOnMobileElementList(setReadbyDate.iOSDate.get(1),"25");
			//SendKeysOnMobileElement(setReadbyDate.getIosYear(), "2021");
			ClickOnMobileElement(createBasicChallenge.getIosDoneBtn());
			Assert.assertEquals(fluentWaitDisplayed(setReadbyDate.getIosEndDate(), 30, 2), true);
			Thread.sleep(4000);

		}
	}

}
