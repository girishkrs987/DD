package com.pom_RWD;


import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;

import java.security.cert.X509Certificate;
import java.util.List;

public class RWD_BookClub_Program_createRPDetailsScreen extends CapabilitiesAndWebDriverUtils {

    public RWD_BookClub_Program_createRPDetailsScreen() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()=\"HOME\"]")
    public WebElement RWD_homePage;

    @FindBy(xpath="//*[contains(text(),'My Programs')]")
    private WebElement RWD_myProgramTab;

    @FindBy(xpath = "//*[contains(text(),\"Open Programs\")]")
    private WebElement RWD_openPrograms;

    @FindBy(id = "tab-chalge-list")
    public WebElement RWD_challengeTab;

    @FindBy(xpath = "//*[@id=\"create-openprg\"]")
    private WebElement RWD_CreateProgramLink;

    @FindBy(xpath = "//*[contains(text(),'Create Reading Program')]")
    private WebElement RWD_createReadingProgramHeader;

    @FindBy(xpath = "//*[@formcontrolname=\"programName\"]")
    private WebElement RWD_enterProgramName;

    @FindBy(xpath = "//*[@formcontrolname=\"description\"]")
    private WebElement RWD_Description;

    @FindBy(xpath = "//div[contains(text(),\"Private\")]")
    private WebElement RWD_privateRadiobutton;

    @FindBy(xpath = "//div[contains(text(),\"Public\")]")
    private WebElement RWD_publicRadiobutton;

    @FindBy(xpath = "//*[@formcontrolname=\"programType\"]")
    private WebElement RWD_selectProgramType;

    @FindBy(xpath = "//*[contains(text(),\"Books in Order\")]")
    public WebElement RWD_booksInOrder;

    @FindBy(xpath = "(//*[contains(text(),\"X of Y Books\")])")
    public WebElement RWD_xAndYBooks;

    @FindBy(xpath = "//*[@placeholder=\"Number of Books\"]")
    public WebElement RWD_numberOfBooksDropDown;

    @FindBy(xpath = "(//*[@role=\"option\"])[1]")
    public WebElement RWD_oneBookSelection;

    @FindBy(xpath = "(//*[@role=\"option\"])[2]")
    public WebElement RWD_oneBookSelection2;

    @FindBy(xpath = "//*[@formcontrolname=\"remainderDuration\"]")
    private WebElement RWD_setReminder;

    @FindBy(xpath = "//*[contains(text(),\"Daily\")]")
    private WebElement RWD_setDailyreminder;

    @FindBy(xpath = "//*[contains(text(),\"Weekly\")]")
    public WebElement RWD_setWeeklyReminder;

    @FindBy(xpath = "//*[contains(text(),\"Monthly\")]")
    public WebElement RWD_setMonthlyReminder;

    @FindBy(xpath = "(//*[@aria-label=\"Example icon button with a delete icon\"])[1]")
    private WebElement RWD_addStudentsButton;

    @FindBy(xpath = "//*[contains(text(),'Search Students')]")
    private WebElement RWD_searchFriendsHeaderText;

    @FindBy(xpath = "//*[@placeholder=\"Search student's name\"]")
    private WebElement RWD_searchStudentName;

    @FindBy(xpath = "(//*[@class=\"student-invite\"])[1]")
    private WebElement RWD_inviteButton;

    @FindBy(xpath = "//*[contains(text(),\"Invite to Program\")]")
    private WebElement RWD_inviteToProgramButton;

    @FindBy(xpath = "(//*[@aria-label=\"Example icon button with a delete icon\"])[2]")
    private WebElement RWD_addTitleButton;

    @FindBy(xpath = "//*[@placeholder=\"Search title, author or topic\"]")
    private WebElement RWD_searchTitleAuthorBox;

    @FindBy(xpath = "(//*[@aria-label=\"Open calendar\"])[1]")
    private WebElement RWD_startDateCalendarIcon;

    @FindBy(xpath = "//*[@class=\"mat-calendar-body-cell-content mat-calendar-body-today\"]")
    private WebElement RWD_startDateCalender;

    @FindBy(xpath = "(//*[@aria-label=\"Open calendar\"])[2]")
    private WebElement RWD_endDateCalendarIcon;

    @FindBy(xpath = "//*[@aria-label=\"Next month\"]")
    private WebElement RWD_CalendarNextbutton;

    @FindBy(xpath = "(//*[@class=\"mat-calendar-body-cell-content\"])[2]")
    private WebElement RWD_endDateCalender;

    @FindBy(xpath = "//*[@class=\"title-subtext\"]")
    private WebElement RWD_AddTitleHeaderText;

    @FindBy(xpath = "(//*[@class=\"searchlist\"])[1]")
    private WebElement RWD_SearchResultsList;

    @FindBy(xpath = "(//*[contains(text(),\"more_vert\")])[1]")
    private WebElement RWD_moreBookButton;

    @FindBy(xpath = "//*[contains(text(),\"Include in\")]")
    private WebElement RWD_addToProgramButton;

    @FindBy(xpath = "//*[contains(text(),\"Save\")]")
    private WebElement RWD_saveProgramButton;

    @FindBy(xpath = "(//*[contains(text(),\"Publish Program\")])")
    private WebElement RWD_publishProgramButton;

    @FindBy(xpath = "//*[@formcontrolname=\"startDate\"]")
    private WebElement RWD_startDateSelectCalender;

    @FindBy(xpath = "//*[@formcontrolname=\"endDate\"]")
    private WebElement RWD_endDateSelectCalender;

    @FindBy (xpath = "//*[contains(text(),\"Reading Program\")]")
    private WebElement RWD_readingProgramHeader;

    @FindBy(xpath = "//h5[contains(text(),'Reading Program')]")
    private WebElement RWD_readingProgramType;

    @FindBy(xpath = "//div/h1")
    private WebElement RWD_readingProgramName;

    @FindBy(xpath = "(//div/p)[4]")
    private WebElement RWD_programDescription;

    @FindBy(xpath = "//div/a[contains(text(),'EDIT PROGRAM ')]")
    private WebElement RWD_editProgramOption;

    @FindBy(xpath = "//div/a[contains(text(),'DUPLICATE PROGRAM ')]")
    private WebElement RWD_duplicateProgramOption;

    @FindBy(xpath = "//div/a[contains(text(),'UNPUBLISH ')]")
    private WebElement RWD_unPublishOption;

    @FindBy(xpath = "//span[@class='createon']")
    private WebElement RWD_programCreatedDate;

    @FindBy(xpath = "//span[@class='createinfo']")
    private WebElement RWD_programInfo;

    @FindBy(xpath = "//div/h4[contains(text(),'START DATE')]")
    private WebElement RWD_startDateText;

    @FindBy(xpath = "//div/h4[contains(text(),'END DATE')]")
    private WebElement RWD_endDateText;

    @FindBy(xpath = "//div/h4[contains(text(),'STATUS')]")
    private WebElement RWD_statusText;

    @FindBy(xpath = "//div/h4[contains(text(),'PROGRAM TYPE')]")
    private WebElement RWD_programTypeText;

    @FindBy(xpath = "//div/h4[contains(text(),'VISIBILITY')]")
    private WebElement RWD_visibilityText;

    @FindBy(xpath="//div/h4[contains(text(),'REMINDERS')]")
    private WebElement RWD_remindersText;

    @FindBy(xpath="(//div/p)[5]")
    private WebElement RWD_startDate;

    @FindBy(xpath="(//div/p)[6]")
    private WebElement RWD_endDate;

    @FindBy(xpath="(//div/p)[7]")
    private WebElement RWD_status;

    @FindBy(xpath="(//div/p)[8]")
    private WebElement RWD_visibility;

    @FindBy(xpath="(//div/p)[9]")
    private WebElement RWD_programType;

    @FindBy(xpath="(//div/p)[10]")
    private WebElement RWD_reminder;

    @FindBy(xpath="(//div/h2)[3]")
    private WebElement RWD_readingListText;

    @FindBy(xpath="//mat-icon[contains(text(),'more_vert')]")
    private List<WebElement> RWD_titleMoreIcon;

    @FindBy(xpath="//button/span[@class='ui-carousel-next-icon pi pi-chevron-right']")
    private WebElement RWD_carouselRight;

    @FindBy(xpath="//button/span[@class='ui-carousel-prev-icon pi pi-chevron-left']")
    private WebElement RWD_carouselLeft;

    @FindBy(xpath = "//*[contains(text(),\"Book Club\")]")
    private WebElement RWD_bookClubTab;

    @FindBy(xpath = "//*[@class=\"mat-card-title header-title txt-elipsishead\"]")
    private List<WebElement> RWD_programHeaderValidation;

    @FindBy(xpath = "//*[@class=\"dd-desc-txt txt-elipsis\"]")
    private List<WebElement> RWD_ProgramDescriptionValidation;

    @FindBy(xpath = "//*[contains(text(),\"DELETE PROGRAM\")]")
    private WebElement RWD_deleteProgramButton;

    @FindBy(xpath = "(//*[text()='close'])[1]")
    private WebElement RWD_closeButton;

    @FindBy(xpath = "//div[contains(text(),\"sure you want\")]")
    public WebElement RWD_DiscardConfirmationText;

    @FindBy(xpath = "//*[text()='Ok']")
    public WebElement RWD_okButton;

    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement RWD_CancelButton;

    @FindBy(xpath = "//*[@class=\"readchallenge\"]/h1")
    private WebElement RWD_programNameDetailsPage;

    @FindBy(xpath = "//*[contains(text(),\" info_outline \")]")
    private WebElement RWD_publicTooltipButton;

    @FindBy(xpath = "//*[contains(text(),\"Select Private to only\")]")
    private WebElement RWD_publicTooltipText;

    @FindBy(xpath = "//*[@id=\"cp-nofbook-optn\"]")
    public List<WebElement> RWD_numberOfBookDropDown;

    @FindBy(xpath = "//*[text()=\"DRAFT PROGRAMS \"]")
    public WebElement RWD_draftProgram;

    @FindBy(xpath = "//*[text()=\"ACTIVE PROGRAMS \"]")
    public WebElement RWD_activeProgram;

    @FindBy(xpath = "//*[@class=\"mat-card-header-text\"]/mat-card-title")
    public List<WebElement> RWD_ListofProgramsDisplayed;



    public WebElement getRWD_publicTooltipButton(){ return RWD_publicTooltipButton;}

    public WebElement getRWD_RWD_publicTooltipText(){return RWD_publicTooltipText;}

    public WebElement getRWD_programNameDetailsPage(){return RWD_programNameDetailsPage;}

    public WebElement getRWD_closeButton(){
        return RWD_closeButton;
    }

    public WebElement getRWD_deleteProgramButton(){
        return RWD_deleteProgramButton;
    }

    public WebElement getRWD_openPrograms(){return RWD_openPrograms;}

    public WebElement getRWD_myProgramTab() {
        return RWD_myProgramTab;
    }

    public WebElement getRWD_CreateProgramLink() {
        return RWD_CreateProgramLink;
    }

    public WebElement getRWD_createReadingProgramHeader() {
        return RWD_createReadingProgramHeader;
    }

    public WebElement getRWD_enterProgramName() {
        return RWD_enterProgramName;
    }

    public WebElement getRWD_Description() {
        return RWD_Description;
    }

    public WebElement getRWD_privateRadiobutton() {
        return RWD_privateRadiobutton;
    }

    public WebElement getRWD_publicRadiobutton() {
        return RWD_publicRadiobutton;
    }

    public WebElement getRWD_selectProgramType(){return RWD_selectProgramType;}

    public WebElement getRWD_setReminder() {
        return RWD_setReminder;
    }
    public WebElement getRWD_setDailyreminder(){return RWD_setDailyreminder;}

    public WebElement getRWD_addStudentsButton() { return RWD_addStudentsButton; }

    public WebElement getRWD_searchFriendsHeaderText() {
        return RWD_searchFriendsHeaderText;
    }

    public WebElement getRWD_searchStudentName() { return RWD_searchStudentName; }

    public WebElement getRWD_inviteButton() {
        return RWD_inviteButton;
    }

    public WebElement getRWD_inviteToProgramButton() {
        return RWD_inviteToProgramButton;
    }

    public WebElement getRWD_addTitleButton() {
        return RWD_addTitleButton;
    }

    public WebElement getRWD_searchTitleAuthorBox() {
        return RWD_searchTitleAuthorBox;
    }

    public WebElement getRWD_startDateCalenderIcon(){return RWD_startDateCalendarIcon;}

    public WebElement getRWD_startSateCalender() { return RWD_startDateCalender;}

    public WebElement getRWD_endDateCalendarIcon(){return RWD_endDateCalendarIcon;}

    public WebElement getRWD_Nextbutton(){ return RWD_CalendarNextbutton;}

    public WebElement RWD_endDateCalender() { return RWD_endDateCalender;
    }

    public WebElement getRWD_AddTitleHeaderText() { return RWD_AddTitleHeaderText; }

    public WebElement getRWD_SearchResultsList() {
        return RWD_SearchResultsList;
    }

    public WebElement getRWD_moreBookButton() {
        return RWD_moreBookButton;
    }

    public WebElement getRWD_addToProgramButton() { return RWD_addToProgramButton; }

    public WebElement getRWD_saveProgramButton() {
        return RWD_saveProgramButton;
    }

    public WebElement getRWD_publishProgramButton() {
        return RWD_publishProgramButton;
    }

    public WebElement getRWD_startDateSelectCalender() {
        return RWD_startDateSelectCalender;
    }

    public WebElement getRWD_endDateSelectCalender() {
        return RWD_endDateSelectCalender;
    }

    public WebElement getRWD_readingProgramHeader() {
        return RWD_readingProgramHeader;
    }

    public WebElement getRWD_readingProgramType() {
        return RWD_readingProgramType;
    }

    public WebElement getRWD_readingProgramName() {
        return RWD_readingProgramName;
    }

    public WebElement getRWD_programDescription() {
        return RWD_programDescription;
    }

    public WebElement getRWD_editProgramOption() {
        return RWD_editProgramOption;
    }

    public WebElement getRWD_duplicateProgramOption() {
        return RWD_duplicateProgramOption;
    }

    public WebElement getRWD_unPublishOption() { return RWD_unPublishOption; }

    public WebElement getRWD_programCreatedDate() {
        return RWD_programCreatedDate;
    }

    public WebElement getRWD_programInfo() {
        return RWD_programInfo;
    }

    public WebElement getRWD_startDateText() {
        return RWD_startDateText;
    }

    public WebElement getRWD_endDateText() {
        return RWD_endDateText;
    }

    public WebElement getRWD_statusText() {
        return RWD_statusText;
    }

    public WebElement getRWD_programTypeText() {
        return RWD_programTypeText;
    }

    public WebElement getRWD_visibilityText() {
        return RWD_visibilityText;
    }

    public WebElement getRWD_remindersText() {
        return RWD_remindersText;
    }

    public WebElement getRWD_startDate() {
        return RWD_startDate;
    }

    public WebElement getRWD_endDate() {
        return RWD_endDate;
    }

    public WebElement getRWD_status() {
        return RWD_status;
    }

    public WebElement getRWD_visibility() {
        return RWD_visibility;
    }

    public WebElement getRWD_programType() {
        return RWD_programType;
    }

    public WebElement getRWD_reminder() { return RWD_reminder; }

    public WebElement getRWD_readingListText() {
        return RWD_readingListText;
    }

    public List<WebElement> getRWD_titleMoreIcon() {
        return RWD_titleMoreIcon;
    }

    public WebElement getRWD_carouselRight() {
        return RWD_carouselRight;
    }

    public WebElement getRWD_carouselLeft() {
        return RWD_carouselLeft;
    }

    public WebElement getRWD_bookClubTab() {
        return RWD_bookClubTab;
    }

    public List<WebElement> getRWD_programHeaderValidation() {
        return RWD_programHeaderValidation;
    }

    public List<WebElement> getRWD_ProgramDescriptionValidation() {
        return RWD_ProgramDescriptionValidation;
    }

    public void landingScreen(){
        Assert.assertTrue(RWD_homePage.isEnabled());
    }

    public void program_AddTitle(String AddTitle){
        waitFor(4000);
        ClickOnWebElement(getRWD_addTitleButton());
        waitFor(4000);
        SendKeysOnWebElement(getRWD_searchTitleAuthorBox(),AddTitle);
        waitFor(2000);
        ClickOnWebElement(getRWD_SearchResultsList());
        waitFor(2000);
        ClickOnWebElement(getRWD_moreBookButton());
        waitFor(2000);
        ClickOnWebElement(getRWD_addToProgramButton());
        waitFor(2000);
    }
}
