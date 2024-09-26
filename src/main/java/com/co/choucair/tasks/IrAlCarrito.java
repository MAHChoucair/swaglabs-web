package com.co.choucair.tasks;

import static com.co.choucair.userinterfaces.ChromeHomePage.CART_BUTTON;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class IrAlCarrito implements Task {
    public static IrAlCarrito deCompras() {
        return Tasks.instrumented(IrAlCarrito.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                 Click.on(CART_BUTTON)
        );
    }
}
