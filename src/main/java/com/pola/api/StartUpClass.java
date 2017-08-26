package com.pola.api;

/**
 * Hello world!
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "controller","dao","com.pola.api","processor","validator","bean"})

public class StartUpClass {

	public static void main(String[] args) {
		SpringApplication.run(StartUpClass.class, args);
	}
}