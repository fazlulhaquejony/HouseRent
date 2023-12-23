package com.fjthechsolutions.houserent.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;


@Entity
@Data
@Table(name="payment_details")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private int rentAmt;
    private int rentPaid;
    private int paidBy;
    private int serviceChargeAmt;
    private int serviceChargePaid;
    //@Type(JsonType.class)
   // @Column(columnDefinition = "jsonb",name="misc_info")
    @JdbcTypeCode(SqlTypes.JSON)
    private String utilityBill;
    private boolean isPaid;

    @ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.REFRESH,
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "house_payment_joining",
        joinColumns=@JoinColumn(name="house_id"),
    inverseJoinColumns = @JoinColumn(name="payment_id"))
    private List<HouseDetails> houseDetailsList;

    @ManyToMany(fetch= FetchType.LAZY, cascade = {CascadeType.REFRESH,
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "owner_payment_joining",
    joinColumns = @JoinColumn(name="owner_id"),
    inverseJoinColumns = @JoinColumn(name="payment_id"))
    private List<OwnerDetails> ownerDetailsList;


    @ManyToMany(fetch= FetchType.LAZY, cascade = {CascadeType.REFRESH,
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "renter_payment_joining",
            joinColumns = @JoinColumn(name="renter_id"),
            inverseJoinColumns = @JoinColumn(name="payment_Id"))
    private List<RenterDetails> renterDetailsList;

    @ManyToMany(fetch= FetchType.LAZY, cascade = {CascadeType.REFRESH,
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "flat_payment_joining",
            joinColumns = @JoinColumn(name="flat_id"),
            inverseJoinColumns = @JoinColumn(name="payment_Id"))
    private List<FlatDetails> flatDetailsList;

    @ManyToMany(fetch= FetchType.LAZY, cascade = {CascadeType.REFRESH,
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "room_payment_joining",
            joinColumns = @JoinColumn(name="room_id"),
            inverseJoinColumns = @JoinColumn(name="payment_Id"))
    private List<RoomDetails> roomDetailsList;



}
