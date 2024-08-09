package com.electra.web.exceptions;



public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(Long id) {
        super("Brand not found with id: " + id);
    }
}

