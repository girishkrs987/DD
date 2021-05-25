package com.stepdefinition;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubProgramsLandingScreenPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class BookClubProgramsLandingScreenStepDef extends CapabilitiesAndWebDriverUtils {
    BookClubProgramsLandingScreenPage landscreen=new BookClubProgramsLandingScreenPage();
    @And("User taps on the My Programs tab on the landing screen")
    public void userTapsOnTheMyProgramsTabOnTheLandingScreen() {
        ClickOnMobileElement(landscreen.getProgramsTab());
    }

    @And("verify that User should be able to view the programs listed based on the programs opted in by the user")
    public void verifyThatUserShouldBeAbleToViewTheProgramsListedBasedOnTheProgramsOptedInByTheUser() {
        System.out.println("the total number of programs displayed: "+landscreen.getclosedProgramList().size());
    }

    @And("User should be able to view the Reading Challenge, Reading Programs and Public Programs tabs")
    public void userShouldBeAbleToViewTheReadingChallengeReadingProgramsAndPublicProgramsTabs() {
        Assert.assertTrue(landscreen.getChallengesTab().isEnabled());
        Assert.assertTrue(landscreen.getpublicProgramsTab().isEnabled());
        Assert.assertTrue(landscreen.getProgramsTab().isEnabled());
    }

    @Then("verify User should be able to view list of Programs grouped as Active Programs, Draft Programs and Closed Programs are displayed")
    public void verifyUserShouldBeAbleToViewListOfProgramsGroupedAsActiveProgramsDraftProgramsAndClosedProgramsAreDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(landscreen.getactiveProgramsSection().isEnabled());
       // scrollAndClick(landscreen.getclosedProgramsSection());
        Thread.sleep(3000);
        Assert.assertTrue(landscreen.getclosedProgramsSection().isEnabled());
//        scrollAndClick(landscreen.getdraftProgramasSection());
//        Assert.assertTrue(landscreen.getdraftProgramasSection().isEnabled());
    }

    @And("Verify User should be able to view Published Programs which user is participant of assigned to or created by that User grouped under Active Programs displayed")
    public void verifyUserShouldBeAbleToViewPublishedProgramsWhichUserIsParticipantOfAssignedToOrCreatedByThatUserGroupedUnderActiveProgramsDisplayed() {
            if(landscreen.getactiveProgramList().size()>=1){
                System.out.println("the total number of programs displayed: "+landscreen.getactiveProgramList().size());
            }
    }

    @And("User should be able to view unpublished programs created by that user grouped under Draft Programs displayed")
    public void userShouldBeAbleToViewUnpublishedProgramsCreatedByThatUserGroupedUnderDraftProgramsDisplayed() {
    }

    @Then("Verify User should be able to view Closed Programs which user was participant of or were created by that User grouped under Closed Programs displayed")
    public void verifyUserShouldBeAbleToViewClosedProgramsWhichUserWasParticipantOfOrWereCreatedByThatUserGroupedUnderClosedProgramsDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        if(landscreen.closedProgramsListSection.size()>=1){
            System.out.println("the total number of programs displayed: "+landscreen.getclosedProgramList().size());
        }else{
            System.out.println("the total number of programs displayed: "+landscreen.getclosedProgramList().size());
        }
    }

    @Then("verify ser should not view Draft Programs section if there are no programs to be displayed in draft section")
    public void verifySerShouldNotViewDraftProgramsSectionIfThereAreNoProgramsToBeDisplayedInDraftSection() {

    }

    @And("verify User should not be able to see unpublished Programs if user is not creator of that Program")
    public void verifyUserShouldNotBeAbleToSeeUnpublishedProgramsIfUserIsNotCreatorOfThatProgram() {

    }

    @And("Verify that User should be able to view the label Reading Program that specifies this is a reading program")
    public void verifyThatUserShouldBeAbleToViewTheLabelReadingProgramThatSpecifiesThisIsAReadingProgram() {

    }

    @And("verify user should be able to view Read by Date for the Reading Program")
    public void verifyUserShouldBeAbleToViewReadByDateForTheReadingProgram() {

    }

    @And("User should be able to view the default icon specified for the reading program")
    public void userShouldBeAbleToViewTheDefaultIconSpecifiedForTheReadingProgram() {

    }

    @And("verify User should be able to view the program title based on the type pf program")
    public void verifyUserShouldBeAbleToViewTheProgramTitleBasedOnTheTypePfProgram() {

    }

    @And("Verify User should be able to view the book cover default image")
    public void verifyUserShouldBeAbleToViewTheBookCoverDefaultImage() {

    }

    @And("verify User should be able to view the program description provided during creation of program")
    public void verifyUserShouldBeAbleToViewTheProgramDescriptionProvidedDuringCreationOfProgram() {

    }

    @And("Verify User should not be able to view any information if there was no description available during creation")
    public void verifyUserShouldNotBeAbleToViewAnyInformationIfThereWasNoDescriptionAvailableDuringCreation() {

    }

    @And("verify User should be able to view the percentage of completion based on the progress made")
    public void verifyUserShouldBeAbleToViewThePercentageOfCompletionBasedOnTheProgressMade() {

    }

    @And("Verify that Application should be able to display the % ranging from {int}% to {int}%")
    public void verifyThatApplicationShouldBeAbleToDisplayTheRangingFromTo(int arg0, int arg1) {
    }

    @And("verify that Application should calculate the progress percentage based on the book completion in the Program \\(ex: if there are {int} books in the Program and user completes reading one book, the completion percentage is {int}%)")
    public void verifyThatApplicationShouldCalculateTheProgressPercentageBasedOnTheBookCompletionInTheProgramExIfThereAreBooksInTheProgramAndUserCompletesReadingOneBookTheCompletionPercentageIs(int arg0, int arg1) {

    }

    @And("Verify User should be able to view the time spent by the user in the specific program for digital content only")
    public void verifyUserShouldBeAbleToViewTheTimeSpentByTheUserInTheSpecificProgramForDigitalContentOnly() {

    }

    @And("Verify Application should be able to display the time in HH:MM format")
    public void verifyApplicationShouldBeAbleToDisplayTheTimeInHHMMFormat() {

    }

    @And("Verify User should be able to tap on a Program that they have created and be navigated to the Creator RP Details Screen")
    public void verifyUserShouldBeAbleToTapOnAProgramThatTheyHaveCreatedAndBeNavigatedToTheCreatorRPDetailsScreen() {

    }

    @And("Verify User should be able to tap on a Program that they are participating in and be navigated to the Participant RP details screen")
    public void verifyUserShouldBeAbleToTapOnAProgramThatTheyAreParticipatingInAndBeNavigatedToTheParticipantRPDetailsScreen() {

    }

    @And("Verify User should be able to view a message saying there are no Reading Programs available if they are not participating in or has not been invited to participate in any Program, along with the Add Program CTA")
    public void verifyUserShouldBeAbleToViewAMessageSayingThereAreNoReadingProgramsAvailableIfTheyAreNotParticipatingInOrHasNotBeenInvitedToParticipateInAnyProgramAlongWithTheAddProgramCTA() {

    }

    @Then("Click on Book club tab")
    public void clickOnBookClubTab() {
        ClickOnMobileElement(landscreen.getBookClubTab());
    }

    @And("Verify that Book Club screen displayed")
    public void verifyThatBookClubScreenDisplayed() {
        ClickOnMobileElement(landscreen.getBookClubTab());
    }
}
