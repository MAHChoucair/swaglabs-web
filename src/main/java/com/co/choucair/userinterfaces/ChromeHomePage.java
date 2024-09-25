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
}
