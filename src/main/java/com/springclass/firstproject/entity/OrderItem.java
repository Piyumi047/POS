package com.springclass.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderItem {

    @Id
    private int orderItemId;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "no_of_qty")
    private int noOfQTY;

    @Column(name = "price_of_all_qty")
    private int priceOfAllQTY;
}
