package com.co.choucair.tasks;

import static com.co.choucair.userinterfaces.ChromeHomePage.productWithName;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Compra implements Task {
    private String producto;

    public Compra(String producto) {
        this.producto = producto;
    }

    public static Compra deProductos(String producto) {
        return Tasks.instrumented(Compra.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(productWithName(producto), isVisible()).forNoMoreThan(30).seconds()
        );

        // Busca el botón "add-to-cart" dentro del contenedor encontrado usando el nombre del producto
        Target ADD_CART_BUTTON = Target.the("botón de agregar al carrito")
                .locatedBy("//div[@class='inventory_item' and .//div[contains(text(), '{0}')]]//button[contains(@id, 'add-to-cart')]")
                .of(producto);

        // Busca el precio del producto
        Target PRODUCT_PRICE = Target.the("precio del producto")
                .locatedBy("//div[@class='inventory_item' and .//div[contains(text(), '{0}')]]//div[@class='inventory_item_price']")
                .of(producto);

        // Realiza las acciones sobre el contenedor y el botón del producto
        actor.attemptsTo(
                // WaitUntil.the(PRODUCTO_CONTENEDOR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ADD_CART_BUTTON, isVisible()).forNoMoreThan(30).seconds(),  // Asegura que el contenedor esté visible y seleccionado
                Click.on(ADD_CART_BUTTON)                        // Haz clic en el botón de "ADD TO CART"
        );

        // Almacena el precio del producto en una variable de sesión con un identificador único
        String precio = PRODUCT_PRICE.resolveFor(actor).getText().replace("$", "");
        Serenity.setSessionVariable(producto + "-PRECIO").to(precio);

    }
}
