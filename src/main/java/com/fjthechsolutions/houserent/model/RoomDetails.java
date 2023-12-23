package com.fjthechsolutions.houserent.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@Table(name="room_details")
public class RoomDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomId;
    private int roomAmt;
    private int noOfMember;
    private boolean isWashSeparate;
    private int noOfBalcony;
    private int roomSize;
    //@Type(JsonType.class)
    // @Column(columnDefinition = "jsonb",name="misc_info")
    @JdbcTypeCode(SqlTypes.JSON)
    private String addressDetails;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="room_id")
    private RenterDetails renterDetails;



}
