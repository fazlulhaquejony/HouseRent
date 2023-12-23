package com.fjthechsolutions.houserent.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@Table(name="flat_details")
public class FlatDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int flatId;
    private int rentAmt;
    private int noOfRoom;
    private int noOfDrawingDining;
    private boolean isDrawingDiningSeparate;
    private int noOfWashRoom;
    private int noOfBalcony;
    private int flatSize;
    //@Type(JsonType.class)
    // @Column(columnDefinition = "jsonb",name="misc_info")
    @JdbcTypeCode(SqlTypes.JSON)
    private String addressDetails;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="flat_id")
    private  OwnerDetails ownerDetails;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="flat_id")
    private  HouseDetails houseDetails;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="flat_id")
    private RenterDetails renterDetails;


}
