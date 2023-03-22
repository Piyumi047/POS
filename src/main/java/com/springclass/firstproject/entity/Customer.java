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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customers")
@TypeDefs(
        {
                @TypeDef(name = "json",typeClass = JsonType.class)
        }
)
public class Customer {

    @Id
    @Column(name = "customer_id",length = 45)
    private int customerId;

    @Column(name = "customer_name",nullable = false)
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;


    @Type(type = "json")
    @Column(name = "contact_numbers",columnDefinition = "json")
    private ArrayList contactNumbers;

    @Column(name = "Nic")
    private String nic;

    @Column(name = "active_states",columnDefinition = "TINYINT DEFAULT 0")
    private boolean activeStates;


}
