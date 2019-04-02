package com.dataart.dt.proto.k8s.mul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MulApplication {

	static private Logger log = LoggerFactory.getLogger(MulApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MulApplication.class, args);
	}

}
