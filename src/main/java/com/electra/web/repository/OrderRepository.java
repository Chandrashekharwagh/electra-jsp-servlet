package com.electra.web.repository;

import com.electra.web.model.Order;
import com.electra.web.service.ConnectionService;
import java.sql.*;

public class OrderRepository {
    private static Connection connection;

    public OrderRepository() {
        try {
            // Assuming you're using MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/electra", "root", "chandu@2323");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean insertOrder(Order order) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO orders VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, order.getId());
            preparedStatement.setInt(2, order.getProductId());
            preparedStatement.setInt(3, order.getCustomerId());
            preparedStatement.setDate(4 , Date.valueOf(order.getOrderDate()));

            System.out.println("inserting order object to order table: " + order);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
