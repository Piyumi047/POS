package com.springclass.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    private int paymentId;

    @Column(name = "order-id")
    private int orderId;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "cash")
    private double cash;

    @Column(name = "balance")
    private double balance;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
