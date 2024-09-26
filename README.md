# Swag Lab Automation Project

## Objetivo

El objetivo de este plan es garantizar que la aplicación Swag Lab funcione correctamente en todos los navegadores y tamaños de pantalla, enfocándose en la experiencia del usuario en dispositivos móviles (65%) y de escritorio (35%). Se cubrirán las funcionalidades críticas de login, interfaz de catálogo, carrito de compras y checkout: overview.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- `src/main/java`: Contiene el código fuente principal.
- `src/test/java`: Contiene las pruebas automatizadas.
- `resources/features`: Contiene los archivos de características de Cucumber.

## Funcionalidades Críticas

### Login

- Pruebas de login exitoso y fallido.
- Validación de mensajes de error y éxito.

### Interfaz de Catálogo

- Navegación y visualización de productos.
- Validación de la correcta visualización de los productos.

### Carrito de Compras

- Adición y remoción de productos del carrito.
- Validación de la correcta actualización del carrito.

### Checkout: Overview

- Proceso de checkout.
- Validación de la correcta finalización de la compra.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Gradle**: Herramienta de automatización de construcción.
- **Appium**: Herramienta de automatización de pruebas.
- **Serenity BDD**: Framework para pruebas automatizadas.
- **Cucumber**: Framework para pruebas basadas en comportamiento (BDD).

## Ejecución de Pruebas

Para ejecutar las pruebas, utiliza el siguiente comando:

```sh
gradle clean test