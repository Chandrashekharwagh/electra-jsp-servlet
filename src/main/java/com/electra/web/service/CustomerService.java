package com.electra.web.service;

import com.electra.web.model.Customer;
import com.electra.web.repository.CustomerRepository;
import java.sql.SQLException;

public class CustomerService {
    private static CustomerRepository customerRepository = new CustomerRepository();


    public static boolean insertCustomer(Customer customer) throws SQLException {
        if (customerRepository.insertCustomer(customer)) {
            System.out.println("Customer inserted successfully!");
        } else {
            System.out.println("Failed to insert Customer.");
            return false;
        }
        return true;
    }
}

