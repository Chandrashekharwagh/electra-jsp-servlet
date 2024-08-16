package com.electra.web.controller;

import com.electra.web.model.Payment;
import com.electra.web.service.OrderService;
import com.electra.web.service.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PaymentController extends HttpServlet {
    private final OrderService orderService = new OrderService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("PaymentForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String amount = request.getParameter("amount");
        String paymentDate = request.getParameter("payment_date");
        String customerId = request.getParameter("customer_id");
        String orderId = request.getParameter("order_id");

        Payment payment = new Payment();
        payment.setId(Long.valueOf(id));
        payment.setAmount(Double.valueOf(amount));
        payment.setCustomerId(Long.valueOf(customerId));
        payment.setOrderId(Long.valueOf(orderId));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

        try {
            // Parse the orderDate using the formatter
            LocalDate localDate = LocalDate.parse(paymentDate, formatter);
            payment.setPaymentDate(localDate);
        } catch (DateTimeParseException e) {
            // Handle the exception if the date cannot be parsed
            e.printStackTrace();
            // You might want to send an error response or set a default date
        }


        try {
            boolean isInserted = PaymentService.insertPayment(payment);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (isInserted) {
                out.println("<h1> Payment object inserted to db</h1>");
            } else {
                out.println("<h1> Payment object in NOT inserted to db</h1>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("confirmation.jsp").forward(request, response);


    }
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--------------- inside the service() method ---------------");
        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else {
            this.doGet(request, response);
        }
    }

    public void destroy() {
        System.out.println("--------------- inside the destroy() method ---------------");
    }
}
