package com.co.choucair.stepdefinitions;

import static com.co.choucair.userinterfaces.ChromeHomePage.CART_ITEMS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;

import static org.hamcrest.core.IsEqual.equalTo;

import com.co.choucair.exceptions.ProductNotFoundError;
import com.co.choucair.questions.CartItems;
import com.co.choucair.tasks.Compra;
import com.co.choucair.tasks.IrAlCarrito;
import com.co.choucair.tasks.RemoveProduct;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.util.logging.Logger;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDefinitions {
    @When("^decide to buy the product '(.*)'$")
    public void selectTheProduct(String product) {
        theActorInTheSpotlight().attemptsTo(
                Compra.deProductos(product)

        );
        Logger.getAnonymousLogger().info("Selecciono el producto: " + product);
        Serenity.setSessionVariable("productosValidos").to(product);

    }

    @Then("^should see my selected product in the shopping cart$")
    public void shouldSeeMySelectedProductInTheShoppingCart() {
        String expectedProduct = Serenity.sessionVariableCalled("productosValidos");
        theActorInTheSpotlight().attemptsTo(
                IrAlCarrito.deCompras()
        );

        theActorInTheSpotlight().should(
                seeThat(CartItems.matchesSelectedProduct(expectedProduct),
                        equalTo(true)).orComplainWith(ProductNotFoundError.class,
                        "El producto en el carrito no coincide con el producto seleccionado")
        );
    }

    @When("^remove the product from the cart$")
    public void removeTheProductFromTheCart() {
        String expectedProduct = Serenity.sessionVariableCalled("productosValidos");
        theActorInTheSpotlight().attemptsTo(
                IrAlCarrito.deCompras()
        );
        theActorInTheSpotlight().attemptsTo(
                RemoveProduct.fromTheCart(expectedProduct)
        );
    }

    @Then("^should see the shopping cart should be empty$")
    public void shouldSeeTheShoppingCartShouldBeEmpty() {
        theActorInTheSpotlight().should(
                seeThat("the cart is empty", WebElementQuestion.the(CART_ITEMS), isNotCurrentlyVisible())
                        .orComplainWith(ProductNotFoundError.class, "The cart is not empty!")
        );
    }
}
