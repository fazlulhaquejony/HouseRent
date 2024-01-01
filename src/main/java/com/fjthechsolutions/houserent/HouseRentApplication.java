package com.fjthechsolutions.houserent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@EntityScan(basePackages = {"com.fjthechsolutions.houserent.model"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class HouseRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseRentApplication.class, args);
	}

}
