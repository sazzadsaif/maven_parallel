package automationPageObjectModel;

import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities.DateUtils;
import utilities.RetryFailedTests;

public class CalculateMortgageRatePOM extends BaseClassUITests {

    @Test(retryAnalyzer = RetryFailedTests.class)
    public void calculateMonthlyPayment(){

        String date = DateUtils.returnNextMonth();
        String[] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];

        new NavigationBar(driver)
                .navigateToHome()
                .typeHomePrice("300000")
                .typeDownPayment("60000")
                .clickDownPaymentToDollar()
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTermYear("30")
                .selectMonth(month)
                .typeYear(year)
                .typePropertyTax("5000")
                .typePmi("0.5")
                .typeHomeIns("1000")
                .TypeHoa("100")
                .selectLoanType("FHA")
                .selectBuyOrRefi("Buy")
                .clickOnCalculateRateButton()
                .validateTotalMonthlyPayment("$1,611.85");

    }

}
