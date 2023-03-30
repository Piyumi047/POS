package com.springclass.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplierDTO {
    private int supplierId;
    private String supplierName;
    private int noOfItems;
    private ArrayList supplierContacts;
    private boolean activeStatus;
}
