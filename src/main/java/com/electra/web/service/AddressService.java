package com.electra.web.service;

import com.electra.web.model.Address;
import com.electra.web.repository.AddressRepository;
import java.sql.SQLException;

public class AddressService {

    private AddressRepository addressRepository = new AddressRepository();

    public boolean insertAddress(Address address) throws SQLException {
        if (addressRepository.insertAddress(address)) {
            System.out.println("Address inserted successfully!");
        } else {
            System.out.println("Failed to insert Address.");
            return false;
        }
        return true;
    }
}
