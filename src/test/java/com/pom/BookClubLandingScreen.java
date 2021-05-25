package com.pom;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BookClubLandingScreen extends CapabilitiesAndWebDriverUtils {

	public BookClubLandingScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/nav_title")
	private MobileElement bntDigitalSitetext;

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/library_ebooks_header_view")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"eBooks\"]")
	private MobileElement eBooktext;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='BOOK CLUB']")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"DD BookClub\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther")
	@iOSXCUITFindBy(accessibility = "BOOK CLUB")
	private MobileElement bookClubOption;

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/nav_logo_image")
	private MobileElement logo;

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/nav_filter_image")
	private MobileElement filter;

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/search_src_text")
	private MobileElement searchTab;

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/nav_search_image")
	@iOSXCUITFindBy(id = "//XCUIElementTypeNavigationBar[@name=\"Book Club\"]/XCUIElementTypeButton[1]")
	private MobileElement searchIcon;

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/nav_main_menu")
	private MobileElement navButton;

	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/nav_title")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Book Club\"]")
	private MobileElement breadCrumBookClub;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Challenges\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Challenges\"]")
	private MobileElement challenges;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Programs\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Programs\"]")
	private MobileElement programs;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Public Programs\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Public Programs\"]")
	private MobileElement publicPrograms;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/imageView\"])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"illustrationsReadingChallenge\"])[1]")
	private MobileElement readChallengeDefaultIcon;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/textView\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Reading challenge: Read by 01/16/2021\"]")
	private MobileElement readTextone;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/textView\"])[1]")
	private MobileElement bookNameone;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/imageView3\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"DD BookClub\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeImage[2]")
	private MobileElement bookImageone;

	@AndroidFindBy(xpath = "(//*[@resource-id='com.follett.fss.searchread.stage:id/iv_challege'])[1]")
	private MobileElement challengeImageone;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/hoursspent\"])[1]")
	private MobileElement challengeTextone;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/description_books\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"The September 11 attacks, often referred to as 9/11, were a series of four coordinated terrorist attacks by the Wahhabi terrorist group Al-Qaeda against the United States on the morning of Tuesday, September\"]")
	private MobileElement bookDescriptionone;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/progressBar2\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"DD BookClub\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther")
	private MobileElement progressbartwo;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/percentagetext\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"50%\"]")
	private MobileElement progressTexttwo;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/tv_hoursspent\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"07:00 hrs spent\"]")
	private MobileElement hoursSpenttwo;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/description_books\"])[2]")
	private MobileElement bookDescriptiontwo;

	@AndroidFindBy(xpath = "(//*[@resource-id=\\\"com.follett.fss.searchread.stage:id/textView\\\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"11 de septembere\"]")
	private MobileElement challengeName;
	
	@AndroidFindBy(id = "com.follett.fss.searchread.stage:id/tv_header_desc")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"11 de septembere\"]")
	public static  List<MobileElement> challengeNameList;
	@iOSXCUITFindBy(xpath = "//*[@name=\"iconsCoreMore\"]")
	public static MobileElement moreBtn;
		@iOSXCUITFindBy(id = "HOME")
	public static MobileElement homeBtn;
	@iOSXCUITFindBy(xpath = "//*[@name=\"Log out\"]")
	public static MobileElement logout;

	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/hoursspent\"])[2]")
	private MobileElement hoursSpentthree;

	// @AndroidFindBy(xpath =
	// "//android.widget.ImageButton[@Resource-Id=\"com.follett.fss.searchread.stage:id/floatingActionButton\"]")
	// @AndroidFindBy(id =
	// "com.follett.fss.searchread.stage:id/floatingActionButton")
	// @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Create
	// Challenge\"]")
	@AndroidFindBy(xpath = "//*[contains(@content-desc,'Create Challenge')]")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"controlsButtonsFab\"]")
	@iOSXCUITFindBy(id="controlsButtonsFab")
	private MobileElement addCTA;

	@iOSXCUITFindBy(id = "//XCUIElementTypeNavigationBar[@name=\"Book Club\"]/XCUIElementTypeButton[2]")
	private MobileElement iosnotification;
	
	@FindBy(xpath="//a[text()=\"Book Club\"]")
	private WebElement RWDbookClubOptionWeb;

	@FindBy(xpath="//mat-icon[text()=\"add \"]")
//	@FindBy(xpath="//div[text()=\"CREATE CHALLENGE \"]")
	private WebElement RWDaddCTAWeb;

	public WebElement getRWDbookClubOptionWeb() {
		return RWDbookClubOptionWeb;
	}

	public WebElement getRWDaddCTAWeb() {
		return RWDaddCTAWeb;
	}


	public MobileElement getBntDigitalSitetext() {
		return bntDigitalSitetext;
	}

	public MobileElement geteBooktext() {
		return eBooktext;
	}

	public MobileElement getBookClubOption() {
		return bookClubOption;
	}

	public MobileElement getLogo() {
		return logo;
	}

	public MobileElement getFilter() {
		return filter;
	}

	public MobileElement getSearchTab() {
		return searchTab;
	}

	public MobileElement getSearchIcon() {
		return searchIcon;
	}

	public MobileElement getNavButton() {
		return navButton;
	}

	public MobileElement getBreadCrumBookClub() {
		return breadCrumBookClub;
	}

	public MobileElement getChallenges() {
		return challenges;
	}

	public MobileElement getPrograms() {
		return programs;
	}

	public MobileElement getPublicPrograms() {
		return publicPrograms;
	}

	public MobileElement getReadChallengeDefaultIcon() {
		return readChallengeDefaultIcon;
	}

	public MobileElement getReadTextone() {
		return readTextone;
	}

	public MobileElement getBookNameone() {
		return bookNameone;
	}

	public MobileElement getBookImageone() {
		return bookImageone;
	}

	public MobileElement getChallengeImageone() {
		return challengeImageone;
	}

	public MobileElement getChallengeTextone() {
		return challengeTextone;
	}

	public MobileElement getBookDescriptionone() {
		return bookDescriptionone;
	}

	public MobileElement getProgressbartwo() {
		return progressbartwo;
	}

	public MobileElement getProgressTexttwo() {
		return progressTexttwo;
	}

	public MobileElement getHoursSpenttwo() {
		return hoursSpenttwo;
	}

	public MobileElement getBookDescriptiontwo() {
		return bookDescriptiontwo;
	}

	public MobileElement getChallengeName() {
		return challengeName;
	}

	public MobileElement getHoursSpentthree() {
		return hoursSpentthree;
	}

	public MobileElement getAddCTA() {
		return addCTA;
	}

	public MobileElement getIosnotification() {
		return iosnotification;
	}

	

}
