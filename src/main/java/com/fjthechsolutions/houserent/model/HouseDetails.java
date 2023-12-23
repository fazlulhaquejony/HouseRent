package com.fjthechsolutions.houserent.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@Table(name="house_details")
public class HouseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int houseId;
    private int rentAmt;
    private int noOfFloor;
    private int noOfFlat;
    private String careTakerName;
    private int flatId;
    //@Type(JsonType.class)
    // @Column(columnDefinition = "jsonb",name="misc_info")
    @JdbcTypeCode(SqlTypes.JSON)
    private String addressDetails;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="house_id")
    private RenterDetails renterDetails;



}
