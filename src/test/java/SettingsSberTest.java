import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;


public class SettingsSberTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    protected String insuranceXpath = "//span[contains(text(),'Страхование')]";
    protected String mainPage = "https://www.sberbank.ru/ru/person";
    protected String clickInsuranceXpath = "//div[@class = 'kit-col kit-col_lg_5 lg-menu__col']//a[contains(text(),'Страхование путешественников')]";
    protected String waitElementInsuranceXpath = "//div[@class = 'kit-col_xs_12 kit-col_md_0 kit-col_lg_6 "
            + "kit-col_xs-bottom_20 kit-col_lg-bottom_10 kit-col_xs-top_20 kit-col_lg-top_40']//h2";
    protected String buttonOnlineCheckOut = "//div[@class = 'product-teaser-full-width__button']//b";
    protected String minCostXpath = "//div[@class = 'online-card-program']//h3[contains(text(), 'Минимальная')]";
    protected String buttonCheckOut = "//div[@class = 'col-12 centered-col']//button";
    protected String inputLastName = "//input[@placeholder = 'Surname']";
    protected String inputName = "//input[@placeholder = 'Name']";
    protected String dateBirth = "//span[@class = 'form-control__icon']//input[@id = 'birthDate_vzr_ins_0']";
    protected String insLastNameXpath = "//input[@id = 'person_lastName']";
    protected String insNameXpath = "//input[@id = 'person_firstName']";
    protected String insMiddleNameXpath = "//input[@id = 'person_middleName']";
    protected String inputDateIns = "//span[@class = 'form-control__icon']//input[@id = 'person_birthDate']";
    protected String inputPasSer = "//input[@placeholder = 'Серия']";
    protected String inputPasNam = "//input[@placeholder = 'Номер']";
    protected String giveDatePas = "//input[@id = 'documentDate']";
    protected String givePas = "//input[@id = 'documentIssue']";
    protected String sex = "//label[contains(text(),'Мужской')]";
    protected String ru = "//label[contains(text(),'гражданин РФ')]";
    protected String butCon = "//button[@class = 'btn btn-primary page__btn']";
    protected String wrongMes = "//div[@class = 'alert-form alert-form-error']";



    @BeforeClass
    public static void setUp() {

        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

        }

        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void endTest() {
        driver.quit();
    }


    protected void toPage(String page) {
        driver.get(page);
    }

    protected void clickXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    protected void waitUtilVisible(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    protected void waitUtilClick(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected boolean isDisplayed(String xpath) {
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    protected void sendKey(String xpath, String text) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(text);
    }

    protected String getAttribute(String xpath, String attribute) {
        return driver.findElement(By.xpath(xpath)).getAttribute(attribute);

    }


}


