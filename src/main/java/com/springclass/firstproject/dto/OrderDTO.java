package com.springclass.firstproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {
    private int orderId;
    private int noOfItems;
    private double billAmount;
    private int discount;
    private double totalAmount;
}
