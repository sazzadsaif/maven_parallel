package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class NavigationBar {
    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");

    public WebDriver driver;

    public NavigationBar(WebDriver driver){
        this.driver = driver;
    }

    public NavigationBar mouseHoverToRates(){
        LOGGER.debug("Mouse hover to Rates");
        ActOn.element(driver,RatesLink).mouseHover();
        return this;
    }

    public RealApr navigateToRealApr(){
        LOGGER.debug("Navigating to Real Apr rate");
        ActOn.element(driver,RealAprLink).click();
        // Object of the RealApr class
        return new RealApr(driver);
    }

    public Home navigateToHome(){
        LOGGER.debug("Navigating to Mortgage Calculator Home Page");
        ActOn.element(driver,MortgageCalculatorLogo).click();
        return new Home(driver);
    }


}
