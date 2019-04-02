package com.dataart.dt.proto.k8s.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DBWriterApplication {

    static private Logger log = LoggerFactory.getLogger(DBWriterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DBWriterApplication.class, args);
    }

}
