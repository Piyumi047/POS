package com.springclass.firstproject.entity;

import com.springclass.firstproject.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 100,nullable = false)
    //@Getter(AccessLevel.NONE)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length = 100,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty",length = 100,nullable = false)
    private double blanceQty;

    @Column(name = "supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name = "seller_price",length = 100,nullable = false)
    private double sellerPrice;

    @Column(name = "active_states",columnDefinition = "TINYINT DEFAULT 0")
    private boolean activeStates;

}
