package selenium_grid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;



public class SeleniumGrid_Test3 {
    @Test
    public void executeInAwsDocker() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.get("https://www.yahoo.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
