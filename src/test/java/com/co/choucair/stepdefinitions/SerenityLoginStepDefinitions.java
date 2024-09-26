package com.co.choucair.stepdefinitions;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.Login;
import com.co.choucair.tasks.OpenTheBrowser;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.choucair.userinterfaces.ChromeHomePage.*;
import static com.co.choucair.utils.GlobalData.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;

public class SerenityLoginStepDefinitions {

    @Given("^the user is on the SwagLabs page$")
    public void theUserIsOnTheSwagLabsPage() {
        //OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
        OnStage.theActorCalled(ACTOR).wasAbleTo(OpenTheBrowser.onTheHomePage());
    }
    @When("^attempts to log in$")
    public void attemptsToLogIn(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.onTheSite(UserLoombokData.setData(dataTable).get(0))
        );
    }
    @Then("^validate the text on screen (.*)$")
    public void validateTheTextOnScreenDashboard(String text) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PRODUCT_LABEL, isVisible()).forNoMoreThan(30).seconds()
        );
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(PRODUCT_LABEL), containsString(text)));
    }

    @Then("^validate error text on screen (.*)$")
    public void validateErrorTextOnScreenMessage(String text) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ERROR_MESSAGE, isVisible()).forNoMoreThan(30).seconds()
        );
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(ERROR_MESSAGE), containsString(text)));
    }
}
