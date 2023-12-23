package com.fjthechsolutions.houserent.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;

@Data
@Entity
@Table(name="renter_details")
public class RenterDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int renterId;
    private Date startDate;
    private Date endDate;
    @JdbcTypeCode(SqlTypes.JSON)
    private String addressDetails;

}
