package com.fjthechsolutions.houserent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Connection;
import java.sql.DriverManager;
@SpringBootTest
class HouseRentApplicationTests
{

	@Test
	void contextLoads() {

		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/house_rent";
		String user = "root";
		String pass = "1623";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection successful!!!");

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}



}
