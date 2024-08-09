package com.electra.web.repository;


import com.electra.web.model.Address;
import com.electra.web.service.ConnectionService;

import java.sql.*;

public class AddressRepository {

    public AddressRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/electra", "root", "chandu@2323");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean insertAddress(Address address) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO address VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getState());
            preparedStatement.setString(5, address.getCountry());
            preparedStatement.setLong(6, address.getPostalCode());

            System.out.println("inserting address object to address table: " + address);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
