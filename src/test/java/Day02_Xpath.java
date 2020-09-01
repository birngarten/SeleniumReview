import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
//        a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
//        b. Locate email textbox
//        c. Locate password textbox ve
//        d. Locate signin button
//        e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
//        i. Username :  testtechproed@gmail.com
//        ii. Password : Test1234!

        driver.get("http://a.testaddressbook.com/");
        WebElement signInLinki = driver.findElement(By.id("sign-in"));
        signInLinki.click();

        Thread.sleep(3000);
        List<WebElement> tumLinkler = driver.findElements(By.tagName("a"));
        for(WebElement w: tumLinkler){
            System.out.println(w.getText());
        }
        //         NOT: cssSelector kullanarak elementleri locate ediniz.
        WebElement emailBox = driver.findElement(By.cssSelector("#session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        WebElement passBox = driver.findElement((By.cssSelector("#session_password")));
        passBox.sendKeys("Test1234!");

        WebElement signInButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        signInButton.click();

//        sayfadaki tum text'leri yazdirin
//        List<WebElement> tumTextler = driver.findElements(By.xpath("//*"));
//        for (WebElement t: tumTextler){
//            System.out.println(t.getText()); }

        WebElement tumTextler = driver.findElement(By.tagName("body"));
            System.out.println(tumTextler.getText());


    }
}
