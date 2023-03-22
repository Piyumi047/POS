package com.springclass.firstproject.dto;

import com.springclass.firstproject.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {

    private String itemId;
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double blanceQty;
    private double supplierPrice;
    private double sellerPrice;
    private boolean activeStates;
}
