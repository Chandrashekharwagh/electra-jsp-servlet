package com.electra.web.model;


import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    private Long id;
    private int productId;
    private int customerId;
    private LocalDate orderDate;
}
