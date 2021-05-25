package com.stepdefinition;

import java.io.IOException;

import javax.xml.xpath.XPath;

import org.junit.Assert;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.base.CapabilitiesAndWebDriverUtils;

import com.pom.BookClubLandingScreen;

import com.pom.CreateAChallengeBasicChallengeDetails;

import com.pom.Login;

import com.pom.ReadingChallengeAcceptRejectChallenge;

import com.pom.ReadingChallengeChallengeAcceptedConfirmation;

import cucumber.api.java.en.When;

import io.appium.java_client.MobileBy;

import io.appium.java_client.MobileElement;

public class ReadingChallengeAcceptRejectChallenge_StepDef extends CapabilitiesAndWebDriverUtils {

	public static RemoteWebDriver driver;

	Login login = new Login();

	ReadingChallengeAcceptRejectChallenge accecptChallenge = new ReadingChallengeAcceptRejectChallenge();

	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();

	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();

	ReadingChallengeAcceptRejectChallenge acceptChallegePage = new ReadingChallengeAcceptRejectChallenge();

	ReadingChallengeChallengeAcceptedConfirmation acceptconfirmation = new ReadingChallengeChallengeAcceptedConfirmation();

	CreateAChallengeBasicChallengeDetails_StepDef createChallenge = new CreateAChallengeBasicChallengeDetails_StepDef();

	@When("User is on the Book Club landing screen")

	public void user_is_on_the_Book_Club_landing_screen() {

		waitFor(4000);

		System.out.println("inside book club");

		ClickOnWebElement(bookClubLandingScreeen.getBookClubOption());

	}

	@When("User has been invited to participate in a Reading Challenge")

	public void user_has_been_invited_to_participate_in_a_Reading_Challenge() {

		/*
		 * 
		 * Assert.assertEquals(createBasicChallenge.searchChallengeName.isDisplayed(),
		 * 
		 * true); String expected = createBasicChallenge.searchChallengeName.getText();
		 * 
		 * Assert.assertEquals(CreateAChallengeBasicChallengeDetails_StepDef.
		 * 
		 * actualchallenegeName, expected);
		 * 
		 */

	}

	@When("User taps on the You have been challenged CTA")

	public void user_taps_on_the_You_have_been_challenged_CTA() throws IOException, InterruptedException {

		String ChallengeName = createChallenge.actualchallenegeName;

		if ("ANDROID".equalsIgnoreCase(platformName)) {

			// scrollNClick(createBasicChallenge.ChallengeNameEle, ChallengeName);

		} else if ("IOS".equalsIgnoreCase(platformName)) {

			scrollAndClick(createBasicChallenge.ChallengeNameEle, ChallengeName);

		}

	}

	@When("User should be able to view Reading Challenge bottom drawer")

	public void user_should_be_able_to_view_Reading_Challenge_bottom_drawer() {

	}

	@When("User should be able to view Reading Challenge details such as Name Read By Date Description Challenge icon and Challenge Text")

	public void user_should_be_able_to_view_Reading_Challenge_details_such_as_Name_Read_By_Date_Description_Challenge_icon_and_Challenge_Text() {

		Assert.assertEquals(createBasicChallenge.searchChallengeName.isDisplayed(), true);

		String expectedChallengeName = createBasicChallenge.searchChallengeName.getText();

		Assert.assertEquals(CreateAChallengeBasicChallengeDetails_StepDef.actualchallenegeName, expectedChallengeName);

		String expectedChallengeDesc = acceptChallegePage.getDescription().getText();

		Assert.assertEquals(CreateAChallengeBasicChallengeDetails_StepDef.actualchallenegeDesc, expectedChallengeDesc);

		Assert.assertEquals(accecptChallenge.getChallengeicon().isDisplayed(), true);

		Assert.assertEquals(accecptChallenge.getCreatorName().isDisplayed(), true);

		Assert.assertEquals(acceptChallegePage.getReadByDateText().isDisplayed(), true);

		if (accecptChallenge.getParticipantsList().size() != 0) {

			for (int i = 0; i < accecptChallenge.getParticipantsList().size(); i++) {

				Assert.assertTrue(acceptChallegePage.getParticipantsList().get(i).isDisplayed());

			}

			System.out.println("Participant list is Displayed ");

		}

	}

	@When("User should be able to tap on Accept Challenge CTA to accept the reading challenge invite")

	public void user_should_be_able_to_tap_on_Accept_Challenge_CTA_to_accept_the_reading_challenge_invite() {

		ClickOnWebElement(accecptChallenge.getAccpetChallegeButton());

	}

	@When("User should be navigated to the accept challenge confirmation screen")

	public void user_should_be_navigated_to_the_accept_challenge_confirmation_screen() {

		Assert.assertEquals(fluentWaitDisplayed(acceptconfirmation.getAccpetedText(), 30, 2), true);

	}

	@When("User should be able to tap on No thanks CTA to reject the reading challenge invite")

	public void user_should_be_able_to_tap_on_No_thanks_CTA_to_reject_the_reading_challenge_invite() {

		ClickOnWebElement(accecptChallenge.getNoThanksButton());

		Assert.assertEquals(fluentWaitDisplayed(bookClubLandingScreeen.getAddCTA(), 30, 2), true);

	}

}