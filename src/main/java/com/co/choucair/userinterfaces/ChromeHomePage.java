package com.co.choucair.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;


public class ChromeHomePage extends PageObject {
    public static final Target USER_INPUT = Target.the("User Name Input")
            .located(By.id("user-name"));

    public static final Target PASSWORD_INPUT = Target.the("Password Input")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("Login Button")
            .located(By.id("login-button"));

    public static final Target PRODUCT_LABEL = Target.the("Product Validation")
            .located(By.xpath("//span[@class='title']"));
    public static final Target ERROR_MESSAGE = Target.the("Error Message")
            .located(By.xpath("//h3[@data-test='error']"));

    public static Target productWithName(String productName) {
        return Target.the("Product with name " + productName)
                .locatedBy("//div[@class='inventory_item_name ' and text()='{0}']")
                .of(productName);
    }

    public static final Target CART_BUTTON = Target.the("Cart Button")
            .located(By.xpath("//a[@class='shopping_cart_link']"));

    public static final Target CART_ITEMS = Target.the("Cart items")
            .locatedBy(".cart_item"); // Seleccionamos cada producto en el carrito

    public static final Target ITEM_TITLE = Target.the("Item title")
            .locatedBy(".cart_item_label a"); // Título del producto

    // Mapeo del botón REMOVE correspondiente a un producto
    public static Target REMOVE_BUTTON(String productName) {
        return Target.the("Remove button for product")
                .locatedBy("//div[@class='inventory_item_name' and contains(text(), '{0}')]/ancestor::div[@class='cart_item']//button[contains(@id, 'remove')]")
                .of(productName);
    }


}
