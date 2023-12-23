package com.fjthechsolutions.houserent.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="owner_coop_details")
public class OwnerCooperative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ownerCoopId;
    private String phone;
    @JdbcTypeCode(SqlTypes.JSON)
    private String addressDetails;
    private String nameDetails;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH,
                        CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="owner_org_joiner",
              joinColumns = @JoinColumn(name="owner_oid"),
           inverseJoinColumns = @JoinColumn(name="owner_coop_id"))
    List<OwnerDetails> ownerDetailsList ;

    public void addOwnerDetails(OwnerDetails ownerDetails)
    {
        if(ownerDetailsList==null)
        {
            ownerDetailsList = new ArrayList<>();
        }
        ownerDetailsList.add(ownerDetails);
    }



    @OneToMany(fetch = FetchType.LAZY,
        cascade = {CascadeType.REFRESH,CascadeType.DETACH,
                CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="house_id")
    List<HouseDetails> houseDetailsList ;

    public void addHouseDetails(HouseDetails houseDetails)
    {
        if(houseDetailsList ==null)
        {
            houseDetailsList =new ArrayList<>();
        }
        houseDetailsList.add(houseDetails);
    }



}
