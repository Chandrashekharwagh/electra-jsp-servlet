package com.electra.web.service;

import com.electra.web.model.Address;
import com.electra.web.repository.AddressRepository;
import java.sql.SQLException;
import java.util.List;

public class AddressService {

    private AddressRepository addressRepository = new AddressRepository();

    public boolean insertAddress(Address address) throws SQLException {
        if (addressRepository.insertAddress(address)) {
            System.out.println("Student inserted successfully!");
        } else {
            System.out.println("Failed to insert Student.");
            return false;
        }
        return true;
    }

    public List<Address> retrieveAddress() throws SQLException {
        return addressRepository.retrieveAddress();
    }
}
