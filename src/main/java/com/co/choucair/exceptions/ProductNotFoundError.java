package com.co.choucair.exceptions;

public class ProductNotFoundError extends AssertionError {
    public ProductNotFoundError(String message, Throwable cause) {
        super(message, cause);
    }
}

