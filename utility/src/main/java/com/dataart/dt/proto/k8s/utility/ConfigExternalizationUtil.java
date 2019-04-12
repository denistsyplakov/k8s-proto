package com.dataart.dt.proto.k8s.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Logger;

public class ConfigExternalizationUtil {

    private static Logger log = Logger.getLogger(ConfigExternalizationUtil.class.getName());

    public static void externalizeConfig() throws IOException {
        log.info("Trying to externalize config for a project started from dir: " +
                new File(".").getAbsolutePath());
        var extConfig = new File("/config/application.properties");
        if (extConfig.exists()) {
            log.info("Found externalized config file " + extConfig.toPath() +
                    ", copying it to /application.properties");
            Files.copy(extConfig.toPath(), new File("/application.properties").toPath());
        } else {
            log.info("Externalized config " + extConfig.toPath() + " not found" );
        }
    }

}
