package com.electra.web.service;

import com.electra.web.model.Brand;
import com.electra.web.repository.BrandRepository;
import java.sql.SQLException;

public class BrandService {

    private BrandRepository brandRepository = new BrandRepository();


    public boolean insertBrands(Brand brand) throws SQLException {
        if (brandRepository.insertBrands(brand)) {
            System.out.println("Brand inserted successfully!");
        } else {
            System.out.println("Failed to insert Brand.");
            return false;
        }
        return true;
    }
}
