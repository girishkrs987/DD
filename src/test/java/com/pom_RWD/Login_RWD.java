package com.pom_RWD;

import com.base.CapabilitiesAndWebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_RWD extends CapabilitiesAndWebDriverUtils {

 public Login_RWD() {PageFactory.initElements(driver, this);}





	@FindBy(xpath = ".//*[@class=\"profileIcon\"]")
	private WebElement RWD_DLX_Login_button;

	@FindBy(id = "userName")
	private WebElement RWD_DLX_UserName;

	@FindBy(id = "userPassword")
	private WebElement RWD_DLX_Password;

	@FindBy(xpath = ".//*[@name=\"login-submit\" or text()=\"Submit\"]")
	private  WebElement RWD_DLX_Submit;

	@FindBy(xpath = ".//*[contains(@class,\"mat-focus-indicator mat-badge menuIcon\")]")
	private WebElement RWD_DLX_Hambugermenu;

	@FindBy(xpath=".//*[@class=\"itemLabel\" and contains(.,\"DD-Bookclub\")]")
	private  WebElement RWD_DD_BookClub;



	public WebElement getRWD_DLX_Login_button() { return RWD_DLX_Login_button; }

	public WebElement getRWD_DLX_UserName() { return RWD_DLX_UserName; }

	public WebElement getRWD_DLX_Password() { return RWD_DLX_Password; }

	public WebElement getRWD_DLX_Submit() { return RWD_DLX_Submit; }

	public WebElement getRWD_DLX_Hambugermenu() { return RWD_DLX_Hambugermenu; }

	public WebElement getRWD_DD_BookClub() { return RWD_DD_BookClub; }


}
