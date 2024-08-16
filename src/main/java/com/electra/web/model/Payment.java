package com.electra.web.model;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Payment{
    private Long id;
    private Double amount;
    private LocalDate paymentDate;
    private Long customerId;
    private Long orderId;
}
