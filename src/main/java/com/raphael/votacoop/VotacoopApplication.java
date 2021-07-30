package com.raphael.votacoop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VotacoopApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VotacoopApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
