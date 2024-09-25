package com.co.choucair.tasks;

import static com.co.choucair.userinterfaces.ChromeHomePage.USER_INPUT;
import static com.co.choucair.utils.GlobalData.URL;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class OpenTheBrowser implements Task {

    private final String url;

    public OpenTheBrowser(String url) {
        this.url = url;
    }

    public static OpenTheBrowser onTheHomePage() {
        return Tasks.instrumented(OpenTheBrowser.class, URL);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}
