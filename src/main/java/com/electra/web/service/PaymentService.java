package com.electra.web.service;

import com.electra.web.model.Payment;
import com.electra.web.repository.PaymentRepository;

import java.sql.SQLException;

public class PaymentService {
    private static PaymentRepository paymentRepository = new PaymentRepository();


    public static boolean insertPayment(Payment payment) throws SQLException {
        if (paymentRepository.insertPayment(payment)) {
            System.out.println("Payment inserted successfully!");
        } else {
            System.out.println("Failed to insert Payment.");
            return false;
        }
        return true;
    }

}
