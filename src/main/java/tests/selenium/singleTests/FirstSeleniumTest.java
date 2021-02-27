package tests.selenium.singleTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class FirstSeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/home/monia/Downloads/geckodriver-v0.27.0-linux64/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); IMPLICIT WAIT GLOBALY
        WebDriverWait w = new WebDriverWait(driver,5);//explicit wait
        String[] productNeeded = {"Brocolli","Cucumber","Tomato"};
        Thread.sleep(3000);
        addToCard(driver,productNeeded);
        driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        //explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
        driver.close();
    }

    public static void addToCard(WebDriver driver, String[] productNeeded) {
        int j = 0;
        List<WebElement> productNames = driver.findElements(By.xpath("//h4[@class='product-name']"));
        for (int i = 0; i < productNames.size(); i++) {

            String[] name = productNames.get(i).getText().split("-");
            String formattedName = name[0].trim();

            List itemsNeededList = Arrays.asList(productNeeded);

            if (itemsNeededList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == productNeeded.length) {
                    break;
                }
            }


        }
    }
}
