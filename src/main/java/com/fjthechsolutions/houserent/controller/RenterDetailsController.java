package com.fjthechsolutions.houserent.controller;

import com.fjthechsolutions.houserent.dto.RenterDetailsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenterDetailsController {

    @GetMapping("/getRenterDetails")
    public RenterDetailsDto getRenterDetails()
    {
        return null;
    }
}
