package com.electra.web.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Customer {
    private Long id;
    private String name;
    private String email;
}
