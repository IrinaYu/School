import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Mail {
    private WebDriver driver;
    private String baseUrl;
    private String searchWord;





    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com.ua/";
        searchWord = "theme";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testMail() throws Exception {
        driver.get(baseUrl);

        driver.findElement(By.linkText("Почта")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("some_mail");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("Passwd")).clear();
        driver.findElement(By.id("Passwd")).sendKeys("parolqwerty");
        driver.findElement(By.id("signIn")).click();
        driver.findElement(By.xpath("//div[@id=':32']/div/div")).click();
        driver.findElement(By.id(":89")).clear();
        driver.findElement(By.id(":89")).sendKeys("some_mail2@gmail.com");
        driver.findElement(By.id(":7t")).click();
        driver.findElement(By.id(":7t")).clear();
        driver.findElement(By.id(":7t")).sendKeys(searchWord);
        driver.findElement(By.id(":8v")).click();
        driver.findElement(By.id(":7j")).click();
        driver.findElement(By.linkText("Отправленные")).click();
        driver.findElement(By.cssSelector("span.y2")).click();
        List<WebElement> resultList = driver.findElements(By.id("nH nn"));
        for (WebElement letter: resultList){
            assertTrue("Letter is not sent", letter.getText().contains(searchWord.toLowerCase()));

        }

    }
        @After
        public void tearDown() throws Exception {
            driver.quit();
        }


}
