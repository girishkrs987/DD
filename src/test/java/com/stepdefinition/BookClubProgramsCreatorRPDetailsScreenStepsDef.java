package com.stepdefinition;

import com.base.CapabilitiesAndWebDriverUtils;
import com.pom.BookClubProgramsLandingScreenPage;
import com.pom.Login;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.io.IOException;

public class BookClubProgramsCreatorRPDetailsScreenStepsDef extends CapabilitiesAndWebDriverUtils {

	BookClubProgramsLandingScreenPage ls = new BookClubProgramsLandingScreenPage();
	BookClubProgramsLandingScreenPage landscreen = new BookClubProgramsLandingScreenPage();

	@When("Click location dropdown and enter the location and enter the school Name location and SchoolName")
	public void clickLocationDropdownAndEnterTheLocationAndEnterTheSchoolNameLocationAndSchoolName()
			throws IOException {
		Login l = new Login();
		if (getData("platformName").equalsIgnoreCase("android")) {
			ClickOnMobileElement(l.getLocationList());
			SendKeysOnMobileElement(l.getKeyWordEnter(), "New York");
			ClickOnMobileElement(l.getChooseState());
			ClickOnMobileElement(l.getTypeYourSchoolName());
			SendKeysOnMobileElement(l.getTypeYourSchoolName(), "BnT Digital Site");
			ClickOnMobileElement(l.getSelectSchoolName());
			ClickOnMobileElement(l.getThatsMySchool());

		} else {

			ClickOnMobileElement(l.getMenu());
			ClickOnMobileElement(l.getTestingTools());
			ClickOnMobileElement(l.getDLY());
			ClickOnMobileElement(l.getIosDone());
			ClickOnMobileElement(l.getTypeYourSchoolName());
			SendKeysOnMobileElement(l.getTypeYourSchoolName(), "BnT Digital Site");
			ClickOnMobileElement(l.getSelectSchoolName());
			ClickOnMobileElement(l.getThatsMySchool());
			ClickOnMobileElement(l.getIOSContinue());

		}
	}

	@And("Enter the User Name and Password UN and PWD click submit button")
	public void enterTheUserNameAndPasswordUNAndPWDClickSubmitButton() {
		Login l = new Login();
		ClickOnMobileElement(l.getUserName());
		SendKeysOnMobileElement(l.getUserName(), "photon");
		ClickOnMobileElement(l.getPassword());

		SendKeysOnMobileElement(l.getPassword(), "photon");
		ClickOnMobileElement(landscreen.getDoneKeyboadButton());

//        hideMobileKeyboard();
		WaitForMobileElement(l.getSubmit());
		ClickOnMobileElement(l.getSubmit());
//		System.out.println(driver.getContext());

	}

	@And("User taps on a program created by that user")
	public void userTapsOnAProgramCreatedByThatUser() {

	}

	@And("verify User should be navigated to the Program details screen")
	public void verifyUserShouldBeNavigatedToTheProgramDetailsScreen() {

	}

	@And("User should be able view program name as header")
	public void userShouldBeAbleViewProgramNameAsHeader() {

	}

	@And("Verify User should be able to view personal details such as their Avatar, Name and Created date for the Program")
	public void verifyUserShouldBeAbleToViewPersonalDetailsSuchAsTheirAvatarNameAndCreatedDateForTheProgram() {

	}

	@And("verify User should be able to view Reading Program details such as Reading Program Icon, Name, Description, Start Date, End date, Status, Visibility, Reminders and Program type")
	public void verifyUserShouldBeAbleToViewReadingProgramDetailsSuchAsReadingProgramIconNameDescriptionStartDateEndDateStatusVisibilityRemindersAndProgramType() {

	}

	@And("Verify User will not be able to view any information if there was no description available during creation")
	public void verifyUserWillNotBeAbleToViewAnyInformationIfThereWasNoDescriptionAvailableDuringCreation() {

	}

	@And("Verify User should view Start date, End date or Reminders as blank if not set yet")
	public void verifyUserShouldViewStartDateEndDateOrRemindersAsBlankIfNotSetYet() {

	}

	@And("Verify Application should set the program status unpublished as default, if program is not published")
	public void verifyApplicationShouldSetTheProgramStatusUnpublishedAsDefaultIfProgramIsNotPublished() {

	}

	@And("Verify User should be able to view order for the books in the reading list for the program type Books in Order")
	public void verifyUserShouldBeAbleToViewOrderForTheBooksInTheReadingListForTheProgramTypeBooksInOrder() {
	}

	@And("verify User should be able to view list of assignees or participants and Progress status for each one")
	public void verifyUserShouldBeAbleToViewListOfAssigneesOrParticipantsAndProgressStatusForEachOne() {

	}

	@And("Verify User should be able to tap on back button to navigate back to the My Programs tab")
	public void verifyUserShouldBeAbleToTapOnBackButtonToNavigateBackToTheMyProgramsTab() {
	}

}
