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
        WebElement SearchInput = WaitForElementLocatedBy(driver, By.xpath("//div[@class='catalog__search']//input"));
        SearchInput.click();
        SearchInput.sendKeys("Вчера работало");
        WebElement SearchButton = WaitForElementLocatedBy(driver, By.xpath("//div[@class='catalog__search']//button"));
        SearchButton.click();
        WebElement Product = WaitForElementLocatedBy(driver, By.xpath("//div[@class='card__content']//a"));
        Product.click();
        WebElement SelectProductColor = WaitForElementLocatedBy(driver, By.xpath("//a[@title='Черный']"));
        SelectProductColor.click();
        WebElement SelectProductSize = WaitForElementLocatedBy(driver, By.xpath("//div[@data-variant-id='2']"));
        SelectProductSize.click();
        WebElement AddProductToOrder = WaitForElementLocatedBy(driver, By.xpath("//button[@id='product__add-cart-btn']"));
        AddProductToOrder.click();
        WebElement Order = WaitForElementLocatedBy(driver, By.xpath("//div[@class='product__success-modal-btn']//a "));
        Order.click();
        WebElement Card = WaitForElementLocatedBy(driver, By.xpath("//a[@class='header__cart-btn']"));
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
