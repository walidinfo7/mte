package com.wf.mte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MteApplication.class, args);
	}

}
