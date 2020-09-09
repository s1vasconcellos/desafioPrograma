package com.marcio.programareserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProgramareservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramareservaApplication.class, args);
	}

}
