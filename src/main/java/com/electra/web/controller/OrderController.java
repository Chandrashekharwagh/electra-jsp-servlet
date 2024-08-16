package com.electra.web.controller;


import com.electra.web.model.Order;
import com.electra.web.service.OrderService;
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


public class OrderController extends HttpServlet {
    private final OrderService orderService = new OrderService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("OrderForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String productId = request.getParameter("product_id");
        String customerId = request.getParameter("customer_id");
        String orderDate = request.getParameter("order_date");

        Order order = new Order();
        order.setId((long) Integer.parseInt(id));
        order.setProductId(Integer.parseInt(productId));
        order.setCustomerId(Integer.parseInt(customerId));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

        try {
            // Parse the orderDate using the formatter
            LocalDate localDate = LocalDate.parse(orderDate, formatter);
            order.setOrderDate(localDate);
        } catch (DateTimeParseException e) {
            // Handle the exception if the date cannot be parsed
            e.printStackTrace();
            // You might want to send an error response or set a default date
        }


        try {
            boolean isInserted = orderService.insertOrder(order);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (isInserted) {
                out.println("<h1> Order object inserted to db</h1>");
            } else {
                out.println("<h1> Order object in NOT inserted to db</h1>");
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
