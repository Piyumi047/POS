package com.springclass.firstproject.dto.request;

import com.springclass.firstproject.entity.Customer;
import com.springclass.firstproject.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customer;
    private Date orderDate;
    private double totalAmount;
    private List<RequestOrderItemSaveDTO> orderItems;
}
