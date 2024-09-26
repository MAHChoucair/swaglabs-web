package com.co.choucair.tasks;

import static com.co.choucair.userinterfaces.ChromeHomePage.REMOVE_BUTTON;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class RemoveProduct implements Task {
    private final String productName;

    public RemoveProduct(String productName) {
        this.productName = productName;
    }

    public static RemoveProduct fromTheCart(String productName) {
        return Tasks.instrumented(RemoveProduct.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(REMOVE_BUTTON(productName), isCurrentlyVisible()),
                Click.on(REMOVE_BUTTON(productName))
        );
    }
}
