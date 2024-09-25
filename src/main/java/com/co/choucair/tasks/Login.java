package com.co.choucair.tasks;

import static com.co.choucair.userinterfaces.ChromeHomePage.*;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.utils.AlertUtils;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Login implements Task {

    UserLoombokData userLoombokData;

    public Login(UserLoombokData userLoombokData) {
        this.userLoombokData = userLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(USER_INPUT, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(userLoombokData.getUser()).into(USER_INPUT),
                Enter.theValue(userLoombokData.getPass()).into(PASSWORD_INPUT),
                Click.on(LOGIN_BUTTON)
        );

        // Continue with the normal flow
        actor.attemptsTo(
                AlertUtils.acceptAlert(),
                WaitUntil.the(PRODUCT_LABEL, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    public static Login onTheSite(UserLoombokData userLoombokData){
        return Instrumented.instanceOf(Login.class).withProperties(userLoombokData);
    }
}
