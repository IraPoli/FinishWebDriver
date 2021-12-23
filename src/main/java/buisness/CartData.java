package buisness;

import pages.CurtPage;

public class CartData {
    private static final long DEFAULT_WAITING_TIME = 90;

    CurtPage curtPage;

    public int getSumOrder(int id) throws Exception {

        curtPage = new CurtPage();
        curtPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        curtPage.waitVisibilityOfElementTest(DEFAULT_WAITING_TIME,curtPage.getSumWebElement());
        int sumPrice = curtPage.getSumPrice();
        curtPage.takeSnapShot("./screenshots/testParallel_" + id + ".png");
        return sumPrice;
    }
}
