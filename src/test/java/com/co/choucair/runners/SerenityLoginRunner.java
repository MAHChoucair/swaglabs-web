package com.co.choucair.runners;


import io.appium.java_client.AppiumDriver;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/serenityLogin.feature",
        glue = "com.co.choucair.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class SerenityLoginRunner {

}
