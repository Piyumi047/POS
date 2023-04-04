package com.springclass.firstproject.dto.request;

import com.springclass.firstproject.entity.Item;
import com.springclass.firstproject.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderItemSaveDTO {

    private int noOfQTY;
    private int priceOfAllQTY;
    private int items;
    private int orders;
}
