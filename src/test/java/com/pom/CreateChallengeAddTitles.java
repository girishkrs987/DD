package com.pom;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.base.CapabilitiesAndWebDriverUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CreateChallengeAddTitles extends CapabilitiesAndWebDriverUtils {

	public CreateChallengeAddTitles()  {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
public static void addTitleToChallenge(String titleName) {
	ClickOnMobileElement(CreateAChallengeBasicChallengeDetails.addTitlesCTA);
	SendKeysOnMobileElement(CreateaChallengeSearchTitleResultsListView.searchTextBox, titleName);
	ClickOnMobileElement(CreateaChallengeSearchTitleResultsListView.iosHorryPotter);
	ClickOnMobileElement(CreateAChallengeSearchTitleResultsTileView.listView);
	logger.info("Adding titles to the challenge");
	List<MobileElement> moreOptions = CreateChallengeSearchTitleResultsMoreCTA.moreOptions;
	for (int j = 0; j < 1; j++) {
		swipeDown();
		for (int i = 0; i < moreOptions.size(); i++) {
			moreOptions.get(i).click();
			ClickOnMobileElement(CreateChallengeSearchTitleResultsMoreCTA.AddToChallenge);
		}
	}
	ClickOnMobileElement(CreateaChallengeSearchTitleResultsListView.iosdoneBtn);
	ClickOnMobileElement(titleSearchPageBackbtn);
	swipeDown();
	logger.info("Validating the title display in create challenge page");
	horizontalSwipe(CreateAChallengeBasicChallengeDetails.addedBooks);
	for (int i = 0; i < CreateAChallengeBasicChallengeDetails.addedBooks.size(); i++) {
		Assert.assertEquals(CreateAChallengeBasicChallengeDetails.addedBooks.get(i).isDisplayed(), true);	
	}			
		
	}
public static void removeTitleFromChallenge() {
	swipeDown();
	for (int i = 0; i <= 1; i++) {
		CreateAChallengeBasicChallengeDetails.removeTitleXIcon.get(i).click();
		logger.info("Handling title remove confirmation popup");
		CreateAChallengeBasicChallengeDetails.TitesRemoveBtn.click();
}
	logger.info("Title Removed Sucessfully");
}
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/etSearch\"]")
	@iOSXCUITFindBy(xpath ="Search title, author or subject")
	public static MobileElement iosSearchTitle;
	
	@iOSXCUITFindBy(id = "(//XCUIElementTypeButton[@name=\"iconsCoreRemove\"])[1]")
	public static MobileElement iosXIcon;
	
	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/ivMore\"])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"controlsButtonsCardsMore\"])[1]")
	public static MobileElement moreOptions;

	@iOSXCUITFindBy(id = "(//XCUIElementTypeImage[@name=\"iconsContentBook\"])[2]")
	public static MobileElement iosMaterialType;

	@iOSXCUITFindBy(id = "(//XCUIElementTypeStaticText[@name=\"J.K. Rowling Mary GrandPre\"])[1]")
	public static MobileElement iosauthorName;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Harry Porter and the Chamber of Secrets\"])[1]")
	public static MobileElement iosBookName;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"iconsCoreRatingsSolid\"])[1]")
	public static MobileElement iosFavIcon;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/tvResultsHead\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"RECENTLY SEARCHED\"]")
	public static MobileElement iosRecentlySearchedText;
	
	@AndroidFindBy(xpath = "(//*[@resource-id=\"com.follett.fss.searchread.stage:id/tvTitle\"])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Harry Potter\"]")
	public static MobileElement iosRecentlySearchedTitles;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/tvRecommendationsHead\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Recommendations\"]]")
	public static MobileElement iosRecommendationsText;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"com.follett.fss.searchread.stage:id/tvFavouritesHead\"]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"From Your Favorites\"]")
	public static MobileElement iosYourFavorite;

	@AndroidFindBy(id="com.follett.fss.searchread.stage:id/nav_navigation_icon")
	public static MobileElement titleSearchPageBackbtn;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@content-desc=\"Search\"]")
	public static MobileElement addTitleSearchHeader;
	
	@AndroidFindBy(id ="com.follett.fss.searchread.stage:id/ivBook")
	public static List<MobileElement> favTitleBooklist;
	
	@AndroidFindBy(id ="com.follett.fss.searchread.stage:id/book_image")
	public static List<MobileElement> recommendTitleBooklist;
	
	public MobileElement getIosSearchTitle() {
		return iosSearchTitle;
	}


	public MobileElement getTitleSearchPageBackbtn() {
		return titleSearchPageBackbtn;
	}


	public MobileElement getAddTitleSearchHeader() {
		return addTitleSearchHeader;
	}


	public MobileElement getIosXIcon() {
		return iosXIcon;
	}


	public MobileElement getMoreOptions() {
		return moreOptions;
	}


	public MobileElement getIosMaterialType() {
		return iosMaterialType;
	}


	public MobileElement getIosauthorName() {
		return iosauthorName;
	}


	public MobileElement getIosBookName() {
		return iosBookName;
	}


	public MobileElement getIosFavIcon() {
		return iosFavIcon;
	}


	public MobileElement getIosRecentlySearchedText() {
		return iosRecentlySearchedText;
	}


	public MobileElement getIosRecentlySearchedTitles() {
		return iosRecentlySearchedTitles;
	}


	public MobileElement getIosRecommendationsText() {
		return iosRecommendationsText;
	}


	public MobileElement getIosYourFavorite() {
		return iosYourFavorite;
	}
	
	
}
