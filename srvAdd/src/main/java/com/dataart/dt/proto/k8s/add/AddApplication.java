package com.dataart.dt.proto.k8s.add;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddApplication {

	static private Logger log = LoggerFactory.getLogger(AddApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AddApplication.class, args);
	}

}
