package com.springclass.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemDTO {
    private int orderItemId;
    private String itemId;
    private int orderId;
    private int noOfQTY;
    private int priceOfAllQTY;
}
