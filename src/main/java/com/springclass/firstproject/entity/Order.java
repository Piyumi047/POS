package com.springclass.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id",length = 45)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "no_of_items")
    private int noOfItems;

    @Column(name = "bill_amount")
    private double billAmount;

    @Column(name = "discount")
    private int discount;

    @Column(name = "total_amount")
    private double totalAmount;


}
