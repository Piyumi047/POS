package com.springclass.firstproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private int paymentId;
    private int orderId;
    private double totalAmount;
    private double cash;
    private double balance;
    private LocalDateTime dateTime;
}
