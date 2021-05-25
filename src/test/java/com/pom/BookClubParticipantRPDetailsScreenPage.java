package com.pom;

import com.base.CapabilitiesAndWebDriverUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookClubParticipantRPDetailsScreenPage extends CapabilitiesAndWebDriverUtils {
    public BookClubParticipantRPDetailsScreenPage() { PageFactory.initElements(new AppiumFieldDecorator(driver), this); }
    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,\"READING\")])[1]")
    private MobileElement readByHeaderText;

    @AndroidFindBy(id = "Needed")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Join Program\"]")
    private List<MobileElement> ListjoinProgramButton;

    @AndroidFindBy(id = "Needed")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Join Program\"]")
    private MobileElement joinProgramButton;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar['index=0'])[4]")
    private MobileElement programDetailsHeaderText;

    @AndroidFindBy(id = "LocatoreNeeded")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"CREATED\")]")
    private MobileElement createdByRDDetailsText;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell/XCUIElementTypeStaticText['@index=1'])[5]")
    private MobileElement creatorNameDetailsScreen;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[1]/XCUIElementTypeStaticText['@index=1'])[1]")
    private MobileElement descriptionDetailsScreen;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"READ BY\")]")
    private MobileElement readingProgramReadByDetailsScreen;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Reading List\"]")
    private MobileElement readingListHeaderDetailsScreen;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Participants \")]")
    private MobileElement ParticipantsHeaderDetailsScree;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Go to Program\"]")
    private MobileElement goToProgramButton;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"CREATED\")]")
    private MobileElement createdDetailsScreen;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther/XCUIElementTypeNavigationBar/XCUIElementTypeStaticText['index=1'])[2]")
    private MobileElement programDetailsHeader;

    @AndroidFindBy(id = "LocatarNeeded")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage[4]['index=4'])[1]")
    private MobileElement AvatarImageDetailsScreen;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText['index=4'])[5]")
    private MobileElement ProgramNameDetailsScreen;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText['index=2'])[3]")
    private MobileElement descriptionProgramDetailsScreen;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText['index=0'])[1]")
    private MobileElement EndDateProgramDetailsScreen;

    @AndroidFindBy(id = "LocatorNeeded")
    @iOSXCUITFindBy(xpath = "(///XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText['index=5'])[7]")
    private MobileElement startDateProgramDetails;

    @AndroidFindBy(id = "LocatorNeede")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]['index=3']")
    private List<MobileElement> BookList;

    public MobileElement getprogramDetailsHeaderText() {
        return programDetailsHeaderText;
    }
    public MobileElement getcreatedByRDDetailsText() {
        return createdByRDDetailsText;
    }
    public MobileElement getcreatorNameDetails() {
        return creatorNameDetailsScreen;
    }
    public MobileElement getdescriptionDetails() {
        return descriptionDetailsScreen;
    }
    public MobileElement getreadingProgramReadByDetails() {
        return readingProgramReadByDetailsScreen;
    }
    public MobileElement getreadingListHeaderDetails() {
        return readingListHeaderDetailsScreen;
    }
    public MobileElement getParticipantsHeaderDetails() {
        return ParticipantsHeaderDetailsScree;
    }
    public MobileElement getreadByHeaderText(){return readByHeaderText;}
    public MobileElement getJoinProgramDatailsButt0n(){return joinProgramButton;}
    public List<MobileElement> getJoinPrgmLists(){return ListjoinProgramButton;}
    public MobileElement getgoToProgramButton(){ return goToProgramButton;}
    public MobileElement getcreatedDetailsScreen(){ return createdDetailsScreen;}
    public MobileElement getprogramDetailsHeader(){return programDetailsHeader;}
    public MobileElement getAvatarImageDetailsScreen(){return AvatarImageDetailsScreen;}
    public MobileElement getProgramNameDetailsScreen(){return ProgramNameDetailsScreen;}
    public MobileElement getdescriptionProgramDetailsScreen(){return descriptionProgramDetailsScreen;}
    public MobileElement getstartDateProgramDetails(){return startDateProgramDetails;}
    public MobileElement getEndDateProgramDetailsScreen(){return EndDateProgramDetailsScreen;}
    public List<MobileElement> GetBookList(){return BookList;}

}
