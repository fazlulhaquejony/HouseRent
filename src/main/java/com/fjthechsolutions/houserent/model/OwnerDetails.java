package com.fjthechsolutions.houserent.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name="owner_details")
public class OwnerDetails {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int ownerId;
    private String phone;
    @JdbcTypeCode(SqlTypes.JSON)
    private String addressDetails;
    private String nameDetails;
   // private int flatId;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="owner_org_joiner",
            joinColumns = @JoinColumn(name="owner_coop_id"),
            inverseJoinColumns = @JoinColumn(name="owner_oid"))
    List<OwnerCooperative> ownerCooperativeList ;

    public void addOwnerCooperative(OwnerCooperative ownerCooperative)
    {
        if(ownerCooperativeList ==null)
        {
            ownerCooperativeList =  new ArrayList<>();
        }
        ownerCooperativeList.add(ownerCooperative);
    }

}
