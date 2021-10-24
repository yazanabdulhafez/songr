package com.ASAC.songr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "Controllers","Models"} )
public class SongrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongrApplication.class, args);
	}

}
