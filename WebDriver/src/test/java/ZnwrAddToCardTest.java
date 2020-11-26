import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ZnwrAddToCardTest
{
    private WebDriver driver;
    @Test
    public void AddToCard() throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://znwr.ru");
        WebElement SearchClick = WaitForElementLocatedBy(driver, By.id("header__search-btn"));
        SearchClick.click();
        WebElement SearchInput = WaitForElementLocatedBy(driver, By.xpath("//*[@id=\"catalog\"]/div[1]/div/form/input"));
        SearchInput.click();
        SearchInput.sendKeys("Вчера работало");
        WebElement SearchButton = WaitForElementLocatedBy(driver, By.xpath("//*[@id=\"catalog\"]/div[1]/div/form/button"));
        SearchButton.click();
        WebElement Product = WaitForElementLocatedBy(driver, By.xpath("//*[@id=\"catalog__card-list\"]/div/div[1]/div[1]/div[2]/a/picture/img"));
        Product.click();
        WebElement SelectProductColor = WaitForElementLocatedBy(driver, By.xpath("//*[@id=\"product\"]/div[1]/div[2]/div/div/div[2]/div/div/a"));
        SelectProductColor.click();
        WebElement SelectProductSize = WaitForElementLocatedBy(driver, By.xpath("//*[@id=\"product\"]/div[1]/div[2]/div/div/div[3]/div[1]/div[1]/div/div[2]"));
        SelectProductSize.click();
        WebElement AddProductToOrder = WaitForElementLocatedBy(driver, By.xpath("//*[@id=\"product__add-cart-btn\"]"));
        AddProductToOrder.click();
        WebElement Order = WaitForElementLocatedBy(driver, By.xpath("//*[@id=\"product__success-modal\"]/div[2]/a"));
        Order.click();
        WebElement Card = WaitForElementLocatedBy(driver, By.xpath("//*[@id=\"header\"]/div[3]/div[2]/a"));
        Assert.assertTrue(Card.isEnabled(), "FAILED TEST");
    }
    private static WebElement WaitForElementLocatedBy(WebDriver driver, By by)
    {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    @AfterMethod(alwaysRun = true)
    public void BrowserTearDown()
    {
        driver.quit();
    }
}
