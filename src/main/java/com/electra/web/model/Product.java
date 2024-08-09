package com.electra.web.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String brand;
    private String supplier;
}
