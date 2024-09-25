package com.co.choucair.utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class AlertUtils {

    private static final Logger logger = Logger.getLogger(AlertUtils.class.getName());

    public static Task acceptAlert() {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
                try {
                    driver.switchTo().alert().accept();
                } catch (NoAlertPresentException e) {
                    logger.info("No native alert found.");
                }
            }
        };
    }
}
