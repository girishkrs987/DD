package com.stepdefinition;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubParticipantRPDetailsScreenPage;
import com.pom.BookClubProgramsLandingScreenPage;
import cucumber.api.java.en.And;

public class BookClubProgramsParticipantRPDetailsScreenStepsDef extends CapabilitiesAndWebDriverUtils {
    BookClubProgramsLandingScreenPage landscreen=new BookClubProgramsLandingScreenPage();
    BookClubParticipantRPDetailsScreenPage ProgramDetailsScreen=new BookClubParticipantRPDetailsScreenPage();
    @And("User taps on a program that they are enrolled in")
    public void userTapsOnAProgramThatTheyAreEnrolledIn() {
        ClickOnMobileElement(landscreen.getProgramsTab());
        ClickOnMobileElement(ProgramDetailsScreen.getreadByHeaderText());
    }

    @And("User should be navigated to the Program details screen")
    public void userShouldBeNavigatedToTheProgramDetailsScreen() throws InterruptedException {
       Thread.sleep(2000);
        if(ProgramDetailsScreen.getJoinPrgmLists().size()>=1){
            ClickOnMobileElement(ProgramDetailsScreen.getJoinProgramDatailsButt0n());
            ClickOnMobileElement(ProgramDetailsScreen.getgoToProgramButton());
            WaitForMobileElement(ProgramDetailsScreen.getcreatedDetailsScreen());

        }else {
            ClickOnMobileElement(ProgramDetailsScreen.getJoinProgramDatailsButt0n());
            WaitForMobileElement(ProgramDetailsScreen.getcreatedDetailsScreen());
        }
    }

    @And("Verify User should be able view program name as header")
    public void verifyUserShouldBeAbleViewProgramNameAsHeader() throws InterruptedException {
        ProgramDetailsScreen.getprogramDetailsHeader().isDisplayed();
        Thread.sleep(2000);
        System.out.println("Program Header is displayed as :"+ ProgramDetailsScreen.getprogramDetailsHeader().getText());
    }

    @And("Verify ser should be able to view details of the creator such as their Avatar, Name and Created date for the Program")
    public void verifySerShouldBeAbleToViewDetailsOfTheCreatorSuchAsTheirAvatarNameAndCreatedDateForTheProgram() {
        ProgramDetailsScreen.getAvatarImageDetailsScreen().isDisplayed();
        WaitForMobileElement(ProgramDetailsScreen.getProgramNameDetailsScreen());
        System.out.println("Program Name is displayed :"+ ProgramDetailsScreen.getProgramNameDetailsScreen().getText());
        WaitForMobileElement(ProgramDetailsScreen.getcreatedDetailsScreen());
        System.out.println("Program created by is displayed :"+ ProgramDetailsScreen.getcreatedDetailsScreen().getText());


    }

    @And("Verify User should be able to view Reading Program details such as Reading Program Icon, Name, Description, Start Date, End date, Status, Visibility and Reminders, Program Type")
    public void verifyUserShouldBeAbleToViewReadingProgramDetailsSuchAsReadingProgramIconNameDescriptionStartDateEndDateStatusVisibilityAndRemindersProgramType() {
        WaitForMobileElement(ProgramDetailsScreen.getProgramNameDetailsScreen());
        System.out.println("Program Name is displayed :"+ ProgramDetailsScreen.getProgramNameDetailsScreen().getText());
        WaitForMobileElement(ProgramDetailsScreen.getdescriptionProgramDetailsScreen());
        System.out.println("Program description by is displayed :"+ ProgramDetailsScreen.getdescriptionProgramDetailsScreen().getText());
        WaitForMobileElement(ProgramDetailsScreen.getreadByHeaderText());
        System.out.println("Program read by is displayed :"+ ProgramDetailsScreen.getreadByHeaderText().getText());
        WaitForMobileElement(ProgramDetailsScreen.getstartDateProgramDetails());
        System.out.println("Program Start by is displayed :"+ ProgramDetailsScreen.getstartDateProgramDetails().getText());
        WaitForMobileElement(ProgramDetailsScreen.getEndDateProgramDetailsScreen());
        System.out.println("Program End date by is displayed :"+ ProgramDetailsScreen.getEndDateProgramDetailsScreen().getText());

    }
    @And("Verify User should be able to view list of books added to the reading program")
    public void verifyUserShouldBeAbleToViewListOfBooksAddedToTheReadingProgram() {
        WaitForMobileElement(ProgramDetailsScreen.getreadingListHeaderDetails());
        System.out.println("List of books displayed :"+ ProgramDetailsScreen.GetBookList().size());
    }

    @And("Verify User Should be able to view users own progress for the each title in that reading program")
    public void verifyUserShouldBeAbleToViewUsersOwnProgressForTheEachTitleInThatReadingProgram() {

    }

    @And("Verify User should not be able to view next book in order until user has completed the preceding book")
    public void verifyUserShouldNotBeAbleToViewNextBookInOrderUntilUserHasCompletedThePrecedingBook() {


    }

    @And("Verify User should be able to view list of Participants for the reading Program")
    public void verifyUserShouldBeAbleToViewListOfParticipantsForTheReadingProgram() {
    }
}
