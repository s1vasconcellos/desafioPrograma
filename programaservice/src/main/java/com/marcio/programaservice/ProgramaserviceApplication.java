package com.marcio.programaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProgramaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramaserviceApplication.class, args);
	}

}
