package com.bits.dda.insurancemanagement

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.CrossOrigin

@SpringBootApplication
@CrossOrigin(origins = "*")
class InsuranceManagementApiApplication {

	static void main(String[] args) {
		SpringApplication.run(InsuranceManagementApiApplication, args)
	}

}
