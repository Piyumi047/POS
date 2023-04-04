package com.springclass.firstproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date orderDate;

    @Column(name = "total_amount")
    private double totalAmount;

    @OneToMany(mappedBy="orders")
    private Set<OrderItem> orderItems;

    public Order(Customer customer, Date orderDate, double totalAmount) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
}
