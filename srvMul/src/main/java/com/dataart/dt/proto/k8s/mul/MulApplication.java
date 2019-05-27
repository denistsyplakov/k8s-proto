package com.dataart.dt.proto.k8s.mul;

import com.dataart.dt.proto.k8s.utility.ConfigExternalizationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MulApplication {

    static private Logger log = LoggerFactory.getLogger(MulApplication.class);

    public static void main(String[] args) throws IOException {
        ConfigExternalizationUtil.externalizeConfig();
        SpringApplication.run(MulApplication.class, args);
    }

}
