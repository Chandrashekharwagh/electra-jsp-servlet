package com.electra.web.model;

import java.util.Date;
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
    private Date orderDate;
}
