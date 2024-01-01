package com.fjthechsolutions.houserent.dto;

import lombok.Data;
import java.util.Date;

@Data
public class RenterDetailsDto {

    private int renterId;
    private Date startDate;
    private Date endDate;
    private String addressDetails;

}
