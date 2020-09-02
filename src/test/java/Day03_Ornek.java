import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_Ornek {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void amazonDropdownTest() {
        driver.get("http://amazon.com");
// 1. DropDown'da Books kategorisini seçelim.
// 2. Arama kutusuna JAVA yazalım.
// 3. Toplam sonuç sayısını ekrana yazdıralım.
// 4. İlk sıradaki ürüne tıklayalım.
// 5. Back to results linki varsa, testimiz TRUE yoksa FALSE
        //      pass        fail

        // 1. DropDown'da Books kategorisini seçelim.
        WebElement dropDownbooks = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownbooks);
        select.selectByVisibleText("Books");

        // 2. Arama kutusuna JAVA yazalım.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("JAVA"+ Keys.ENTER);

        // 3. Toplam sonuç sayısını ekrana yazdıralım.
        WebElement totalResult = driver.findElement(By.xpath("//span[.='1-16 of over 20,000 results for']"));
        System.out.println("Toplam "+ totalResult.getText() + " var");

        // 4. İlk sıradaki ürüne tıklayalım.
        WebElement ilkUrun = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        ilkUrun.click();

        // 5. Back to results linki varsa, testimiz TRUE yoksa FALSE
        WebElement bactToResult = driver.findElement(By.id("breadcrumb-back-link"));
        boolean varMi = bactToResult.isDisplayed();
        Assert.assertTrue(varMi);

        Assert.assertTrue(bactToResult.isDisplayed());

        //      pass        fail


    }
}