package com.stepdefinition;

import java.io.IOException;
import io.appium.java_client.MobileElement;

import org.testng.Assert;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubLandingScreen;
import com.pom.CreateAChallengeBasicChallengeDetails;
import com.pom.Login;
import com.pom.ReadingChallengeAcceptRejectChallenge;
import com.pom.ReadingChallengeChallengeAcceptedConfirmation;
import com.pom.ReadingChallengeParticipantRCDetailsScreen;

import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;

public class ReadingChallengeParticipantRCDetailsScreen_StepDef  extends CapabilitiesAndWebDriverUtils{
	
	Login login = new Login();
	ReadingChallengeAcceptRejectChallenge accecptChallenge = new ReadingChallengeAcceptRejectChallenge();
	BookClubLandingScreen bookClubLandingScreeen = new BookClubLandingScreen();
	CreateAChallengeBasicChallengeDetails createBasicChallenge = new CreateAChallengeBasicChallengeDetails();
	ReadingChallengeAcceptRejectChallenge acceptChallegePage = new ReadingChallengeAcceptRejectChallenge();
	ReadingChallengeChallengeAcceptedConfirmation acceptConfirmation =new ReadingChallengeChallengeAcceptedConfirmation();
	ReadingChallengeParticipantRCDetailsScreen participantRCDetailsScreen = new ReadingChallengeParticipantRCDetailsScreen();
	
	
	@When("User has accepted the invitation to participate in a challenge")
	public void user_has_accepted_the_invitation_to_participate_in_a_challenge() throws IOException {
		ClickOnMobileElement(bookClubLandingScreeen.getBookClubOption());
		waitFor(3000);
//		createBasicChallenge.searchChallengeName.click();
		System.out.println(CreateAChallengeBasicChallengeDetails_StepDef.actualchallenegeName);
		String challengeNameToTap = CreateAChallengeBasicChallengeDetails_StepDef.actualchallenegeName;
		MobileElement findElement = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + 
														".scrollIntoView(new UiSelector().text(\""+challengeNameToTap+"\"))"));
		System.out.println(findElement.getText());
		ClickOnMobileElement(findElement);
		ClickOnMobileElement(accecptChallenge.getAccpetChallegeButton());	
		
	}

	@When("User taps on Go to Challenge CTA on the Challenge Accepted Screen")
	public void user_taps_on_Go_to_Challenge_CTA_on_the_Challenge_Accepted_Screen() {
	   
		Assert.assertTrue(acceptConfirmation.getGo_to_challeng().isDisplayed());
		acceptConfirmation.getGo_to_challeng().click();
			    
	}

	@When("User should be able to view the Challenge icon Challenge Text Challenge Name End date of the challenge and description of the challenge")
	public void user_should_be_able_to_view_the_Challenge_icon_Challenge_Text_Challenge_Name_End_date_of_the_challenge_and_description_of_the_challenge() throws IOException {
		waitFor(3000);
		participantRCDetailsScreen.getNavBackBtn().click();
		waitFor(2000);
		System.out.println(CreateAChallengeBasicChallengeDetails_StepDef.actualchallenegeName);
		String challengeNameToTap = CreateAChallengeBasicChallengeDetails_StepDef.actualchallenegeName;
		MobileElement findElement = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + 
														".scrollIntoView(new UiSelector().text(\""+challengeNameToTap+"\"))"));
		System.out.println("created challenge: "+findElement.getText());
		ClickOnMobileElement(findElement);
//		createBasicChallenge.searchChallengeName.click();
		Assert.assertEquals(participantRCDetailsScreen.getAvatarProfileImage().isDisplayed(),true);
		Assert.assertEquals(participantRCDetailsScreen.getChallengeReadbyTextEndDate().isDisplayed(),true);
		System.out.println("Challeneg End Date : "+participantRCDetailsScreen.getChallengeReadbyTextEndDate().getText());
		Assert.assertEquals(participantRCDetailsScreen.getProfileName().isDisplayed(),true);
		Assert.assertEquals(participantRCDetailsScreen.getChallenegIcon().isDisplayed(),true);
		Assert.assertEquals(participantRCDetailsScreen.getChallengeNameText().isDisplayed(),true);
		String expectedChallengeName = participantRCDetailsScreen.getChallengeNameText().getText();
		System.out.println("Displayed Name : "+expectedChallengeName);
//		Assert.assertEquals(CreateAChallengeBasicChallengeDetails_StepDef.actualchallenegeName, expectedChallengeName);
		Assert.assertEquals(participantRCDetailsScreen.getDescriptionText().isDisplayed(),true);
		String expectedChallenegeDesc = participantRCDetailsScreen.getDescriptionText().getText();
		System.out.println("Displayed Desc : "+expectedChallenegeDesc);
		swipeDown();
//		Assert.assertEquals(CreateAChallengeBasicChallengeDetails_StepDef.actualchallenegeDesc, expectedChallenegeDesc);
		

	}

	@When("User should be able to view the other participants of the challenge")
	public void user_should_be_able_to_view_the_other_participants_of_the_challenge() {
	   
	    
	}
	

}
