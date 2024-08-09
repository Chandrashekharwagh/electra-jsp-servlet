package com.electra.web.repository;


import com.electra.web.model.Address;
import com.electra.web.service.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressRepository {

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

    public List<Address> retrieveAddress() throws SQLException {
        this.initConnection();
        List<Address> addresses = new ArrayList<>();
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM address");

            // Iterate over the result set
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String country = resultSet.getString("country");
                Long postalCode = resultSet.getLong( "postal_code");

                Address address = new Address(id,street,state,city,country,postalCode);
                addresses.add(address);

            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return addresses;
    }
}
