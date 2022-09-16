package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class APITest {
    APIPage apiPage = new APIPage();

    @Test(priority = 1)
    public void getAPITest() {
        apiPage.verifyGetAPI();
    }

    @Test(priority = 2)
    public void postAPITest() {
        apiPage.verifyPostAPI();
    }

    @Test(priority = 3)
    public void putAPITest() {
        apiPage.verifyPutAPI();
    }

    @Test(priority = 4)
    public void deleteAPITest() {
        apiPage.verifyDeleteAPI();
    }
}
