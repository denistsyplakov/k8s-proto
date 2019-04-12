package com.dataart.dt.proto.k8s.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ConfigExternalizationUtil {

    private static Logger log = LoggerFactory.getLogger(ConfigExternalizationUtil.class);

    private static void externalizeConfig() throws IOException {
        var extConfig = new File("/config/application.properties");
        if (extConfig.exists()) {
            log.info("Found externalized config file {}, copying it to /application.properties", extConfig.toPath());
            Files.copy(extConfig.toPath(), new File("/application.properties").toPath());
        } else {
            log.info("Externalized config {} not found", extConfig.toPath());
        }
    }

}
