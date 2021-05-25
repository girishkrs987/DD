package com.stepdefinition;

import com.base.CapabilitiesAndWebDriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestReference {
    public WebDriver driver ;
    public TestReference(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(CapabilitiesAndWebDriverUtils.driver,this);
    }

    @FindBy(xpath="//*[@id=\"outer1\"]/div[1]/text()")
    public static WebElement RWDaddCTAWeb;

    public TestReference() {

    }

    public static void Browser_Launch(String browser,WebDriver driver) throws InterruptedException {
        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();
        } else if (browser.contains("firefox")) {

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/DriverJenkins/geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            driver.manage().deleteAllCookies();
        } else if (browser.contains("safari")) {

            SafariOptions options = new SafariOptions();
            if (browser.contains("headless")) {
            }
            driver = new SafariDriver(options);
            driver.manage().deleteAllCookies();
        }

        String URL = "https://dd-rc-webappfb.web.app/113074/bookclub/user1/challenges";
        driver.get(URL);
        Thread.sleep(5000);
        RWDaddCTAWeb.click();
    }
        public static void main(String[] args) throws InterruptedException {
            TestReference test = new TestReference();
Browser_Launch("chrome", test.driver);

    }
}
