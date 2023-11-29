package laptopsandnotebooks;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));

        //1.2 Click on “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        verifyElements("Matched", "Price (High > Low)", By.xpath("//select[@id='input-sort']"));

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));

        //2.2 Click on “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));

        //2.5 Verify the text “MacBook”
        verifyElements("Matched", "MacBook", getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']")));

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyElements("Matched", "Success: You have added MacBook to your shopping cart!×", getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.9 Verify the text "Shopping Cart"
        verifyElements("Matched", "Shopping Cart         (0.00kg) ", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));

        //2.10 Verify the Product name "MacBook"
        verifyElements("Matched", "MacBook", getTextFromElement(By.xpath("(//a[contains(text(),'MacBook')])[2]")));

        //2.11 Change Quantity "2"


        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyElements("Matched", "Success: You have modified your shopping cart!", By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //2.14 Verify the Total £737.45
        verifyElements("Matched", "$1,204.00", By.xpath("(//td[contains(text(),'$1,204.00')])[4]"));

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //2.16 Verify the text “Checkout”
        verifyElements("Matched", "Checkout", By.xpath("//h1[normalize-space()='Checkout']"));

        //2.17 Verify the Text “New Customer”
        verifyElements("Matched", "New Customer", By.xpath("//h2[normalize-space()='New Customer']"));

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Danny");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Daniels");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "dannydaniels100@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "1234567890");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "111 High Street");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "HA11SS");
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='input-payment-zone']"), "Surrey");

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Drop at the door");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required!”

    }
}
