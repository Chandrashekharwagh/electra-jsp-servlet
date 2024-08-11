package com.electra.web.repository;


import com.electra.web.model.Brand;
import com.electra.web.service.ConnectionService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BrandRepository {
    private Connection connection;

    public BrandRepository() {
        try {
            // Assuming you're using MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean insertBrands(Brand brand) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO brand VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, brand.getId());
            preparedStatement.setString(2, brand.getName());
            preparedStatement.setString(3, brand.getDescription());

            System.out.println("inserting brand object to brand table: " + brand);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
