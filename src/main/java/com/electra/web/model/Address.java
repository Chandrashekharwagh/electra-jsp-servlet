package com.electra.web.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private Long postalCode;
}

