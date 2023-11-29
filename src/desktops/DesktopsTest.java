package desktops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.time.Duration;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabaticalOrder() {

        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));

        //2.2 Click on “Show All Desktops
        selectMenu("Show AllDesktops");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //2.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));

        //2.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //2.5 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");

        //2.6 Select product “HP LP3065”
        mouseHoverAndClick(By.xpath("//a[normalize-space()='HP LP3065']"));

        //2.7 Verify the Text "HP LP3065"
        Assert.assertEquals("Matched", "HP LP3065", getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']")));

        //2.8 Select Delivery Date "2022-11-30"
        WebElement dataTextField = findElementFromWebPage(By.cssSelector("#input-option225"));
        dataTextField.click();
        dataTextField.sendKeys(Keys.CONTROL, "a");
        dataTextField.sendKeys(Keys.DELETE);
        dataTextField.sendKeys("2022-11-30");

        //2.9.Enter Qty "1” using Select class.


        //2.10 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        verifyElements("Matched", "Success: You have added HP LP3065 to your shopping cart!×", getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        //2.12 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[@id='cart-total']"));

        //2.13 Verify the text "Shopping Cart"
        verifyElements("Matched", "Shopping Cart (1.00kg)", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));

        //2.14 Verify the Product name "HP LP3065"
        verifyElements("Matched", "HP LP3065", getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")));

        //2.15 Verify the Delivery Date "2023-11-27"
        verifyElements("Matched", "Delivery Date:2022-11-30", getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']")));

        //2.16 Verify the Model "Product21"
        verifyElements("Matched", "Product 21", getTextFromElement(By.xpath("//td[normalize-space()='Product 21']")));

        //2.17 Verify the Total "£74.73"
        verifyElements("Matched", "$122.00", getTextFromElement(By.xpath("(//td[@class='text-right'][normalize-space()='$122.00'])[3]")));


    }
}

