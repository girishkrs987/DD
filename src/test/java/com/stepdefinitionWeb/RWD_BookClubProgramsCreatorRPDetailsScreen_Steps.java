package com.stepdefinitionWeb;


import com.base.CapabilitiesAndWebDriverUtils;
import com.pom_RWD.RWD_BookClub_Program_createRPDetailsScreen;
import com.pom_RWD.RWD_CreateaChallenge_AddTitles;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;

public class RWD_BookClubProgramsCreatorRPDetailsScreen_Steps extends CapabilitiesAndWebDriverUtils {
    String programType = "X of Y Books";
    String ReminderSet = "Weekly";
    String ProgramName = "Automation_Program_" + RandomStringUtils.randomAlphanumeric(5);
    RWD_BookClub_Program_createRPDetailsScreen createBasicProgram = new RWD_BookClub_Program_createRPDetailsScreen();
    RWD_CreateaChallenge_AddTitles createChallenge = new RWD_CreateaChallenge_AddTitles();

    @Then("Click on Open program tab")
    public void clickOnOpenProgramTab() {
        ClickOnWebElement(createBasicProgram.getRWD_openPrograms());
    }

    @Then("Click on create program link")
    public void clickOnCreateProgramLink() {
        waitFor(4000);
        ClickOnWebElement(createBasicProgram.getRWD_CreateProgramLink());
    }

    @And("Click on the Public program radio button")
    public void clickOnThePublicProgramRadioButton() {
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_publicRadiobutton());
    }

    @And("Enter the description")
    public void enterTheDescription() {
        SendKeysOnWebElement(createBasicProgram.getRWD_Description(), "Automation Testing program Description box");
    }

    @And("user should be able to enter the required details")
    public void userShouldBeAbleToEnterTheRequiredDetails() {
        waitFor(2000);
        SendKeysOnWebElement(createBasicProgram.getRWD_enterProgramName(), ProgramName);
//        SendKeysOnWebElement(createBasicProgram.getRWD_Description(), 20, 2,"Automation Testing program Description box");
        waitFor(2000);
//        ClickOnWebElement(createBasicProgram.getRWD_publicRadiobutton(), 30, 2);
        ClickOnWebElement(createBasicProgram.getRWD_selectProgramType());
        if (programType.equalsIgnoreCase("Books in Order")) {
            ClickOnWebElement(createBasicProgram.RWD_booksInOrder);
        } else {
            ClickOnWebElement(createBasicProgram.RWD_xAndYBooks);
            waitFor(2000);
            ClickOnWebElement(createBasicProgram.RWD_numberOfBooksDropDown);
            ClickOnWebElement(createBasicProgram.RWD_oneBookSelection);
        }
        ClickOnWebElement(createBasicProgram.getRWD_startDateCalenderIcon());
        ClickOnWebElement(createBasicProgram.getRWD_startSateCalender());
        ClickOnWebElement(createBasicProgram.getRWD_endDateCalendarIcon());
        ClickOnWebElement(createBasicProgram.getRWD_Nextbutton());
        ClickOnWebElement(createBasicProgram.RWD_endDateCalender());
        ClickOnWebElement(createBasicProgram.getRWD_setReminder());
        if (ReminderSet.equalsIgnoreCase("Daily")) {
            ClickOnWebElement(createBasicProgram.getRWD_setDailyreminder());
        } else if (ReminderSet.equalsIgnoreCase("Weekly")) {
            ClickOnWebElement(createBasicProgram.RWD_setWeeklyReminder);
        } else {
            ClickOnWebElement(createBasicProgram.RWD_setMonthlyReminder);
        }
        waitFor(5000);
        javascriptScroll(createBasicProgram.getRWD_addStudentsButton());
        ClickOnWebElement(createBasicProgram.getRWD_addStudentsButton());
        ClickOnWebElement(createBasicProgram.getRWD_inviteButton());
        ClickOnWebElement(createBasicProgram.getRWD_inviteToProgramButton());
        waitFor(4000);
        ClickOnWebElement(createBasicProgram.getRWD_addTitleButton());
        waitFor(4000);
        SendKeysOnWebElement(createBasicProgram.getRWD_searchTitleAuthorBox(), "Herry Potter");
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_SearchResultsList());
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_moreBookButton());
        ClickOnWebElement(createBasicProgram.getRWD_addToProgramButton());
        waitFor(2000);
    }

    @Then("Click on Publish program")
    public void clickOnPublishProgram() {
        waitFor(4000);
        ClickOnWebElement(createBasicProgram.getRWD_publishProgramButton());
        waitFor(2000);
    }


    @And("Click on the private program radio button")
    public void clickOnThePrivateProgramRadioButton() {
        ClickOnWebElement(createBasicProgram.getRWD_privateRadiobutton());
        String visibility = createBasicProgram.getRWD_privateRadiobutton().getText();
    }

    @Then("Click on Save program")
    public void clickOnSaveProgram() {
        waitFor(4000);
        ClickOnWebElement(createBasicProgram.getRWD_saveProgramButton());
        waitFor(6000);
        Assert.assertTrue(createBasicProgram.getRWD_myProgramTab().isDisplayed());
        waitFor(10000);
    }

    @And("Verify user is navigated back to My program screen")
    public void verifyUserIsNavigatedBackToMyProgramScreen() {
        Assert.assertTrue(createBasicProgram.getRWD_myProgramTab().isEnabled());
        waitFor(4000);
        String myProgramTab = createBasicProgram.getRWD_myProgramTab().getText();
        if (myProgramTab.equalsIgnoreCase("My Programs")) {
            System.out.println("User is navigated to My ProgramTab is screen");
        }
    }

    @Then("User tap on the Delete Program CTA to discard the changes made")
    public void userTapOnTheDeleteProgramCTAToDiscardTheChangesMade() {
        javascriptScroll(createBasicProgram.getRWD_deleteProgramButton());
        ClickOnWebElement(createBasicProgram.getRWD_deleteProgramButton());
    }

    @Then("User tap on the the ‘X’ icon to discard the changes made")
    public void userTapOnTheTheXIconToDiscardTheChangesMade() {
        waitFor(5000);
        ClickOnWebElement(createBasicProgram.getRWD_closeButton());
        String actualText = createBasicProgram.RWD_DiscardConfirmationText.getText();
        System.out.println("Actual Text is: " + actualText);
        Assert.assertEquals(actualText, "Are sure you want to discard");
        Assert.assertTrue(createBasicProgram.RWD_CancelButton.isEnabled());
        ClickOnWebElement(createBasicProgram.RWD_okButton);

    }

    @And("Verify that User is navigated to the details screen")
    public void verifyThatUserIsNavigatedToTheDetailsScreen() {
        waitFor(5000);
        String ActualPgmName = createBasicProgram.getRWD_programNameDetailsPage().getText();
        if (ProgramName.equalsIgnoreCase(ActualPgmName)) {
            Assert.assertEquals(ActualPgmName, ProgramName);
            System.out.println("expected Program Name:- " + ProgramName);
            System.out.println("Actual Program Name:- " + ActualPgmName);
            System.out.println("Actual and expected program names are matched;");
        }
    }

    @And("User taps on tooltip explaining what is a public program")
    public void userTapsOnTooltipExplainingWhatIsAPublicProgram() {
        waitFor(5000);
        ClickOnWebElement(createBasicProgram.getRWD_publicTooltipButton());
        waitFor(5000);


    }

    @And("Verify the CT is is displayed")
    public void verifyTheCTIsIsDisplayed() {
        String toolTipText = "Select Private to only allow participants you invite to join. Select Public if anyone can join.";
        String ActualtoolText = createBasicProgram.getRWD_RWD_publicTooltipText().getText();
        if (ActualtoolText.equalsIgnoreCase(toolTipText)) {
            Assert.assertEquals(toolTipText, ActualtoolText);
            System.out.println("expected tool tip text:- " + toolTipText);
            System.out.println("Actual tool tip tex:- " + ActualtoolText);
            System.out.println("Actual and expected program names are matched;");
        }
    }

    @Then("User should be able to enter the Program Name")
    public void userShouldBeAbleToEnterTheProgramName() {
        waitFor(2000);
        SendKeysOnWebElement(createBasicProgram.getRWD_enterProgramName(), ProgramName);
    }

    @Then("User should be able to select the Program Type")
    public void userShouldBeAbleToSelectTheProgramType() {
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_selectProgramType());
        if (programType.equalsIgnoreCase("Books in Order")) {
            ClickOnWebElement(createBasicProgram.RWD_booksInOrder);
        } else {
            ClickOnWebElement(createBasicProgram.RWD_xAndYBooks);
            waitFor(2000);
            ClickOnWebElement(createBasicProgram.RWD_numberOfBooksDropDown);
            ClickOnWebElement(createBasicProgram.RWD_oneBookSelection);
        }
    }

    @And("User should be able to select the Start date and End date")
    public void userShouldBeAbleToSelectTheStartDateAndEndDate() {
        ClickOnWebElement(createBasicProgram.getRWD_startDateCalenderIcon());
        ClickOnWebElement(createBasicProgram.getRWD_startSateCalender());
        ClickOnWebElement(createBasicProgram.getRWD_endDateCalendarIcon());
        ClickOnWebElement(createBasicProgram.getRWD_Nextbutton());
        ClickOnWebElement(createBasicProgram.RWD_endDateCalender());
    }

    @Then("User should be able to set reminders for the challenge")
    public void userShouldBeAbleToSetRemindersForTheChallenge() {
        javascriptScroll(createBasicProgram.getRWD_setReminder());
        ClickOnWebElement(createBasicProgram.getRWD_setReminder());
        if (ReminderSet.equalsIgnoreCase("Daily")) {
            ClickOnWebElement(createBasicProgram.getRWD_setDailyreminder());
        } else if (ReminderSet.equalsIgnoreCase("Weekly")) {
            ClickOnWebElement(createBasicProgram.RWD_setWeeklyReminder);
        } else {
            ClickOnWebElement(createBasicProgram.RWD_setMonthlyReminder);
        }
        waitFor(5000);
    }

    @And("User should be able to add students to the Program")
    public void userShouldBeAbleToAddStudentsToTheProgram() {
        javascriptScroll(createBasicProgram.getRWD_addStudentsButton());
        ClickOnWebElement(createBasicProgram.getRWD_addStudentsButton());
        ClickOnWebElement(createBasicProgram.getRWD_inviteButton());
        ClickOnWebElement(createBasicProgram.getRWD_inviteToProgramButton());
        waitFor(4000);
    }

    @And("User should be able to add Title to the Program")
    public void userShouldBeAbleToAddTitleToTheProgram() {
        waitFor(4000);
        ClickOnWebElement(createBasicProgram.getRWD_addTitleButton());
        waitFor(4000);
        SendKeysOnWebElement(createBasicProgram.getRWD_searchTitleAuthorBox(), "Herry Potter");
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_SearchResultsList());
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_moreBookButton());
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_addToProgramButton());
        waitFor(2000);
    }

    @And("Verify that System should throw the error message")
    public void verifyThatSystemShouldThrowTheErrorMessage() {
//        Here we need to update the code once the Duplicate program is fixed
        System.out.println("A program already exists with this name.");

    }

    @Then("Verify user is not able to publish program with user added")
    public void verifyUserIsNotAbleToPublishProgramWithUserAdded() {
        waitFor(4000);
        System.out.println("The Return Value is: " + createBasicProgram.getRWD_publishProgramButton().isEnabled());
        Assert.assertTrue(createBasicProgram.getRWD_publishProgramButton().isEnabled());
//        ClickOnWebElement(createBasicProgram.getRWD_publishProgramButton(), 30, 2);
    }

    @Given("User is logged in as Admin")
    public void userIsLoggedInAsAdmin() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(createChallenge.getRWD_Logo().isEnabled());
        Assert.assertTrue(createChallenge.getRWD_BookClubText().isDisplayed());
    }

    @And("Verify User is able to see two types of program")
    public void verifyUserIsAbleToSeeTwoTypesOfProgram() {
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_selectProgramType());
        Assert.assertTrue(createBasicProgram.RWD_booksInOrder.isDisplayed());
        Assert.assertTrue(createBasicProgram.RWD_xAndYBooks.isDisplayed());
    }

    @When("User clicks on Select Program Type dropdown")
    public void userClicksOnSelectProgramTypeDropdown() {
        if (programType.equalsIgnoreCase("Books in Order")) {
            ClickOnWebElement(createBasicProgram.RWD_booksInOrder);
        } else {
            ClickOnWebElement(createBasicProgram.RWD_xAndYBooks);
            waitFor(2000);
            ClickOnWebElement(createBasicProgram.RWD_numberOfBooksDropDown);
            ClickOnWebElement(createBasicProgram.RWD_oneBookSelection);
        }
    }

    @Then("user should be able to view option to select number of required books")
    public void userShouldBeAbleToViewOptionToSelectNumberOfRequiredBooks() {
        Assert.assertTrue(createBasicProgram.RWD_numberOfBooksDropDown.isDisplayed());
//        ClickOnWebElement(createBasicProgram.RWD_numberOfBooksDropDown,20,2);
    }

    @Then("Verify user should be able to click on “Number of required Books” to view the list of numbers")
    public void verifyUserShouldBeAbleToClickOnNumberOfRequiredBooksToViewTheListOfNumbers() {
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.RWD_numberOfBooksDropDown);
        System.out.println("The number of books displayed in the drop down: " + createBasicProgram.RWD_numberOfBookDropDown.size());
    }

    @And("Verify that user should be able to select a number from the drop down to set the number of books")
    public void verifyThatUserShouldBeAbleToSelectANumberFromTheDropDownToSetTheNumberOfBooks() {
        ClickOnWebElement(createBasicProgram.RWD_oneBookSelection2);
    }

    @And("Select the Program type as Book in order option from the drop down")
    public void selectTheProgramTypeAsBookInOrderOptionFromTheDropDown() {
        ClickOnWebElement(createBasicProgram.RWD_booksInOrder);
    }

    @And("verify that user should not see the option to select the number of required books if program type selected is not X out of Y Books\"")
    public void verifyThatUserShouldNotSeeTheOptionToSelectTheNumberOfRequiredBooksIfProgramTypeSelectedIsNotXOutOfYBooks() throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        waitFor(2000);
        if (createBasicProgram.RWD_numberOfBookDropDown.size()>=1){
            waitFor(2000);
            ClickOnWebElement(createBasicProgram.RWD_numberOfBooksDropDown);
            System.out.println("The number of books displayed in the drop down: " + createBasicProgram.RWD_numberOfBookDropDown.size());
        }else
        {
            System.out.println("Option to select the number of required books if program type selected is not X out of Y Books");
        }
    }

    @And("verify that Application should remove the option number of books required when Program Type is changed to “Books in Order”")
    public void verifyThatApplicationShouldRemoveTheOptionNumberOfBooksRequiredWhenProgramTypeIsChangedToBooksInOrder() {
        waitFor(2000);
        if (createBasicProgram.RWD_numberOfBookDropDown.size()>=1){
            waitFor(2000);
            ClickOnWebElement(createBasicProgram.RWD_numberOfBooksDropDown);
            System.out.println("The number of books displayed in the drop down: " + createBasicProgram.RWD_numberOfBookDropDown.size());
        }else
        {
            System.out.println("Application is remove the option number of books required when Program Type is changed to “Books in Order");
        }
    }

    @Then("User should not be able to publish the program if the total number of books in the reading list are less than “Number of Books” set")
    public void userShouldNotBeAbleToPublishTheProgramIfTheTotalNumberOfBooksInTheReadingListAreLessThanNumberOfBooksSet() {
        waitFor(4000);
        ClickOnWebElement(createBasicProgram.getRWD_addTitleButton());
        waitFor(4000);
        SendKeysOnWebElement(createBasicProgram.getRWD_searchTitleAuthorBox(), "Herry Potter");
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_SearchResultsList());
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_moreBookButton());
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_addToProgramButton());
    }

    @And("Verify that Publish Program button is disabled")
    public void verifyThatPublishProgramButtonIsDisabled() {
        waitFor(4000);
        Assert.assertFalse(createBasicProgram.getRWD_publishProgramButton().isEnabled());
    }

    @Then("Click on My program tab")
    public void clickOnMyProgramTab() {
        waitFor(2000);
        ClickOnWebElement(createBasicProgram.getRWD_myProgramTab());
    }

    @Then("verify that UI validation of My Programs - Landing Page Screen")
    public void verifyThatUIValidationOfMyProgramsLandingPageScreen() {
        waitFor(4000);
        Assert.assertTrue(createBasicProgram.RWD_activeProgram.isDisplayed());
        waitFor(6000);
        javascriptScroll(createBasicProgram.RWD_draftProgram);
        waitFor(10000);
        Assert.assertTrue(createBasicProgram.RWD_draftProgram.isDisplayed());

    }

    @And("Verify that User should be able to view the programs listed")
    public void verifyThatUserShouldBeAbleToViewTheProgramsListed() throws Exception {
        waitFor(6000);
        if(createBasicProgram.RWD_ListofProgramsDisplayed.size()>=1){
            System.out.println("The list of programs displayed in Opne program Tab : "+createBasicProgram.RWD_ListofProgramsDisplayed.size());
            for (int i=0;i<createBasicProgram.RWD_ListofProgramsDisplayed.size();i++){
                System.out.println(createBasicProgram.RWD_ListofProgramsDisplayed.get(i).getText());
            }
        }else {
            throw new Exception("No program results for user is not displayed");
        }
    }

    @And("verify that user should be able to view the Challenges, My Programs and Open Programs tabs")
    public void verifyThatUserShouldBeAbleToViewTheChallengesMyProgramsAndOpenProgramsTabs() {
        waitFor(4000);
        Assert.assertTrue(createBasicProgram.getRWD_myProgramTab().isDisplayed());
        Assert.assertTrue(createBasicProgram.getRWD_openPrograms().isDisplayed());
        Assert.assertTrue(createBasicProgram.RWD_challengeTab.isDisplayed());

    }
}
