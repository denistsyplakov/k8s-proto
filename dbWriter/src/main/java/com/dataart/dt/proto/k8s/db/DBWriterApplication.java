package com.dataart.dt.proto.k8s.db;

import com.dataart.dt.proto.k8s.utility.ConfigExternalizationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DBWriterApplication {

    static private Logger log = LoggerFactory.getLogger(DBWriterApplication.class);

    public static void main(String[] args) throws IOException {
        ConfigExternalizationUtil.externalizeConfig();
        SpringApplication.run(DBWriterApplication.class, args);
    }

}
