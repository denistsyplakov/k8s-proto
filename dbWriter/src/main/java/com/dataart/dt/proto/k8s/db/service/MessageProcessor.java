package com.dataart.dt.proto.k8s.db.service;

import com.dataart.dt.proto.k8s.db.repository.DataWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {

    private Logger log = LoggerFactory.getLogger(MessageProcessor.class);

    private final DataWriter wrt;

    public MessageProcessor(DataWriter wrt) {
        this.wrt = wrt;
    }

    public void processMessage(String value) {
        wrt.writeValue(Integer.parseInt(value));
    }
}
