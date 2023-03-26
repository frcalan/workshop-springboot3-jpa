package io.productdemo.demo.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersioonUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
