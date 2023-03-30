package com.springclass.firstproject.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "suppliers")
@TypeDefs(
        {
                @TypeDef(name = "json",typeClass = JsonType.class)
        }
)
public class Supplier {

    @Id
    @Column(name = "supplier_id",length = 45)
    private int supplierId;

    @Column(name = "supplier_name",nullable = false)
    private String supplierName;

    @Column(name = "no_of_items")
    private int noOfItems;

    @Type(type = "json")
    @Column(name = "supplier_contacts",columnDefinition = "json")
    private ArrayList supplierContacts;

    @Column(name = "active_status")
    private boolean activeStatus;

}
