package com.co.choucair.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

public class Hooks {

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());

    }
    @After
    public void close() {
        Serenity.getDriver().close();
    }
}
