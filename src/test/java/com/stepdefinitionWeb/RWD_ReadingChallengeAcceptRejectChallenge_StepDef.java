package com.stepdefinitionWeb;

import java.io.IOException;

import com.pom_RWD.RWD_BookClubLandingScreen;
import com.pom_RWD.RWD_CreateAChallengeCreatorRCDetailsScreen;
import org.junit.Assert;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom_RWD.RWD_ReadingChallengeAcceptRejectChallenge;
import com.pom_RWD.RWD_ReadingChallengeChallengeAcceptedConfirmation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RWD_ReadingChallengeAcceptRejectChallenge_StepDef extends CapabilitiesAndWebDriverUtils  {
	
	RWD_BookClubLandingScreen rwdbookclub=new RWD_BookClubLandingScreen ();
	RWD_ReadingChallengeAcceptRejectChallenge accept=new RWD_ReadingChallengeAcceptRejectChallenge();
	RWD_ReadingChallengeChallengeAcceptedConfirmation acceptconfirmation=new RWD_ReadingChallengeChallengeAcceptedConfirmation();
	RWD_CreateAChallengeCreatorRCDetailsScreen rcdetails=new RWD_CreateAChallengeCreatorRCDetailsScreen();


	@Given("User has been invited to participate in a Reading Challenge​")
	public void user_has_been_invited_to_participate_in_a_Reading_Challenge​() throws IOException, InterruptedException {
		//driver.get(getData("invitedURL"));
		System.out.println("InvitedURl="+driver.getCurrentUrl());
		Thread.sleep(8000);

	   
	}

	@When("User taps on the ”You have been challenged\" CTA​")
	public void user_taps_on_the_You_have_been_challenged_CTA​() throws IOException, InterruptedException {
		//javascriptScroll(rwdbookclub.getRWDchallengeNamebookclub());
		Thread.sleep(4000);

		//Assert.assertEquals(IsDisplayedWebElement(rwdbookclub.getRWDyouHavebeenChallenged(), 30, 2), true);
	//	ClickOnWebElement(rwdbookclub.getRWDchallengeNamebookclub(), 30, 2);

		Thread.sleep(2000);
		for(int i=0;i<=rwdbookclub.getRWDchallengeNameList().size();i++) {
			
			String name = rwdbookclub.getRWDchallengeNameList().get(i).getText();
			if(name.contains("AutomationWebMay6")){
				
				ClickOnWebElement(rwdbookclub.getRWDchallengeNamebookclub());

				
				
			}
			
			
		}
	    
	}
	
	@When("User taps on the You have been challenged CTA RWD")
	public void user_taps_on_the_You_have_been_challenged_CTA() throws IOException, InterruptedException {
		//javascriptScroll(rwdbookclub.getRWDchallengeNamebookclub());
		waitFor(1000);
		for(int i=0;i<=rwdbookclub.getRWDchallengeNameList().size();i++) {
			
			String name = rwdbookclub.getRWDchallengeNameList().get(i).getText();
			String RCname = RWD_CreateAChallengeBasicChallengeDetails_StepDef.challengeNameActual;
			if(name.contains(RCname))
			{
				ClickOnWebElement(rwdbookclub.getRWDchallengeNameList().get(i));
				waitFor(1000);
				break;
			}
		}
	}


	@Then("User should be able to view Reading Challenge overlay")
	public void user_should_be_able_to_view_Reading_Challenge_overlay() {
		
		Assert.assertEquals(IsDisplayedWebElement(accept.getRWDchallengeBoard()), true);

	}

	@Then("Check that user able to tap on {string} CTA and user should navigate to accept challenge confirmation screen​")
	public void check_that_user_able_to_tap_on_CTA_and_user_should_navigate_to_accept_challenge_confirmation_screen​(String string) throws InterruptedException {
		
		ClickOnWebElement(accept.getRWDacceptChallengeBtn());
		Thread.sleep(2000);
		Assert.assertEquals(IsDisplayedWebElement(acceptconfirmation.getRWDChallengeAcceptedText()), true);
		Thread.sleep(2000);


	}
	
	@Then("Check that user able to tap on Accept Challenge CTA and user should navigate to accept challenge confirmation screen")
	public void check_that_user_able_to_tap_on_CTA_and_user_should_navigate_to_accept_challenge_confirmation_screen() throws InterruptedException {
		
		ClickOnWebElement(accept.getRWDacceptChallengeBtn());
		Thread.sleep(2000);
		Assert.assertEquals(IsDisplayedWebElement(acceptconfirmation.getRWDChallengeAcceptedText()), true);
		Thread.sleep(2000);


	}
	
	
}
