package com.electra.web.service;

import com.electra.web.model.Order;
import com.electra.web.repository.OrderRepository;
import java.sql.SQLException;

public class OrderService {
    private static OrderRepository orderRepository = new OrderRepository();


    public static boolean insertOrder(Order order) throws SQLException {
        if (orderRepository.insertOrder(order)) {
            System.out.println("Order inserted successfully!");
        } else {
            System.out.println("Failed to insert Order.");
            return false;
        }
        return true;
    }
}
