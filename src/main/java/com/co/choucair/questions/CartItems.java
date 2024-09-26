package com.co.choucair.questions;

import static com.co.choucair.userinterfaces.ChromeHomePage.*;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class CartItems implements Question<Boolean> {
    private String expectedProductTitle;

    public CartItems(String expectedProductTitle) {
        this.expectedProductTitle = expectedProductTitle;
    }

    public static CartItems matchesSelectedProduct(String expectedProductTitle) {
        return new CartItems(expectedProductTitle);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> cartItems = CART_ITEMS.resolveAllFor(actor);

        // Comparar el tamaño de la lista
        if (cartItems.size() != 1) {
            return false; // Si hay más de un producto o ninguno, retornamos false
        }

        // Ahora validamos el título del producto en el carrito
        String actualProductTitle = ITEM_TITLE.resolveFor(actor).getText();
        return actualProductTitle.equals(expectedProductTitle);
    }

}

