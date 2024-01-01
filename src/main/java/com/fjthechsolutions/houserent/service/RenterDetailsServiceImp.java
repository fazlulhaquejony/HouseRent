package com.fjthechsolutions.houserent.service;

import com.fjthechsolutions.houserent.dto.RenterDetailsDto;
import com.fjthechsolutions.houserent.model.RenterDetails;
import com.fjthechsolutions.houserent.repository.RenterDetailsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenterDetailsServiceImp implements RenterDetailsService{


    RenterDetailsRepo renterDetailsRepo;

    @Autowired
    public RenterDetailsServiceImp(RenterDetailsRepo renterDetailsRepo)
    {
        this.renterDetailsRepo = renterDetailsRepo;
    }
    @Override
    public RenterDetailsDto getRenterDetails() {

        ModelMapper modelMapper = new ModelMapper();
        RenterDetails renterDetails = renterDetailsRepo.getRenterDetails();
        return modelMapper.map(renterDetails, RenterDetailsDto.class);

    }
}
