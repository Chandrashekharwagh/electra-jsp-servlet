package com.electra.web.exceptions;

public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(Long id) {
        super("Supplier not found with id: " + id);
    }
}

