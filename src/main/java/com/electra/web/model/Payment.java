package com.electra.web.model;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Payment{
    private Long id;
    private Double amount;
    private Date paymentDate;
    private Long customerId;
    private Long orderId;
}
