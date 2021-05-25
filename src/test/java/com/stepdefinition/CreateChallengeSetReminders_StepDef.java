package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.CreateChallengeSetReminders;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateChallengeSetReminders_StepDef extends CapabilitiesAndWebDriverUtils {

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	CreateChallengeSetReminders setReminder = new CreateChallengeSetReminders();

	@When("User taps on the Set reminders CTA")
	public void user_taps_on_the_Set_reminders_CTA() throws InterruptedException {
		logger.info("Tapping on set reminder option");
		ClickOnWebElement(createBasicChallenge.getSetReminderOpt());

	}

	@Then("User should be able to view the reminders options displayed in a bottom drawer")
	public void user_should_be_able_to_view_the_reminders_options_displayed_in_a_bottom_drawer() throws IOException {

		if (getData("platformName").equalsIgnoreCase("android")||getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
			logger.info("Validation reminder option");
			Assert.assertEquals(isDisplayed(setReminder.getNoneOption()), true);
			Assert.assertEquals(isDisplayed(setReminder.getDailyOption()), true);
			Assert.assertEquals(isDisplayed(setReminder.getWeeklyOption()), true);
			Assert.assertEquals(isDisplayed(setReminder.getMonthlyOption()), true);

		}

		else {
			
			//Assert.assertEquals(fluentWaitDisplayed(setReminder.getIosRemainderOptions(), 30, 5), true);

		}

	}

	@Then("User should be able to select Daily Weekly or Monthly Reminders by tapping on the required option")
	public void user_should_be_able_to_select_Daily_Weekly_or_Monthly_Reminders_by_tapping_on_the_required_option() throws IOException, InterruptedException {
		if (getData("platformName").equalsIgnoreCase("android")||getData("platformName").equalsIgnoreCase("BrowserStackandroid")) {
		logger.info("selecting reminder option");
		ClickOnMobileElement(setReminder.getDailyOption());
		}
		else {
			
			SendKeysWithoutClear(setReminder.iosRemainderOptions,"Weekly");
			Thread.sleep(3000);
		}
	}

}
