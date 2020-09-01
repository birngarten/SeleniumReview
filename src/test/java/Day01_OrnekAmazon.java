import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {// 1. Amazon.com'a gideceğiz.
// 2. Arama kutusuna "baby stroller"
// 3. 2. Sıradaki ürüne tıklayacağız.
// 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
// 5. Ürünün ortalama puanını (5 üzerinden) alacağız.

    WebDriver driver;
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // 2. Arama kutusuna "baby stroller"
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby stroller"+ Keys.ENTER);

        // 3. 2. Sıradaki ürüne tıklayacağız.
        WebElement ikinciUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        ikinciUrun.click();

// 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
        WebElement urunFiyati = driver.findElement(By.xpath("((//span[@class='a-size-base a-color-base'])[57]"));
//        WebElement urunFiyati = driver.findElement(By.id("priceblock_ourprice_row")); ->HAMZA HOCADAN
        System.out.println(urunFiyati.getText());

//// 5. Ürünün ortalama puanını (5 üzerinden) alacağız.
//        WebElement urunPuani = driver.findElement(By.id("averageCustomerReviews"));
//        System.out.println(urunPuani.getText());
//// 6. Google gecis yap
//        driver.navigate().to("https://www.google.com/");
//// 7. searchBoc'a "Frankfurt" gonder
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("Frankfurt"+Keys.ENTER);
//
//// 8. sonuc sayisini console'de yaziniz
//        WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
//        System.out.println(sonucSayisi.getText());

    }



}
