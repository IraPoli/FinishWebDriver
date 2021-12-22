package buisness;

import pages.CurtPage;
import pages.SearchResultPage;

public class CartData {
    private static final long DEFAULT_WAITING_TIME = 90;

    CurtPage curtPage;

    public int getSumOrder() throws InterruptedException {

        curtPage = new CurtPage();
        curtPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        //curtPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME,curtPage.getSumWebElement());
        int sumPrice = curtPage.getSumPrice();
        // curtPage.takeSnapShot("./screenshots/testParallel_" + testId + ".png");
        return sumPrice;
    }
}
