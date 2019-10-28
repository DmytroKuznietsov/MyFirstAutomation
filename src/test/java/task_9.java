import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class task_9 {
    private WebDriver driver;
    private TestPage testPage;
    private static final String PATH_TO_CHROMEDRIVER = "C:\\chromedriver_win32\\chromedriver.exe";

    @Before
    public void setting() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROMEDRIVER);
        // win mac linux
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testPage = new TestPage(this.driver);
    }


    @Test
    public void Test1() {

        testPage.openMainPage();
        testPage.doSearch("Blouse");
        testPage.pressList();
        testPage.addToCard();

        Assert.assertEquals("$54.00",testPage.getTotalProd());
        Assert.assertEquals("$2.00",testPage.getTotalShipping());
        Assert.assertEquals("$56.00",testPage.getPrice());
        Assert.assertEquals("$0.00",testPage.getTax());
    }


}

