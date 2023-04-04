package com.springclass.firstproject.dto.request;

import com.springclass.firstproject.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IteamUpdateDTO {
    private int itemId;
    private double blanceQty;
    private double supplierPrice;
    private double sellerPrice;
}
