package com.dataart.dt.proto.k8s.db.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PubSub {

    static private Logger log = LoggerFactory.getLogger(PubSub.class);

    private final PubSubTemplate pubSubTemplate;

    public PubSub(PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
    }

    @PostConstruct
    private void init() {
        pubSubTemplate.subscribe("k8s-proto-2db", msg -> {
            log.info("Msg {} : {}",
                    msg.getPubsubMessage().getMessageId(),
                    pubSubTemplate.getMessageConverter().fromPubSubMessage(msg.getPubsubMessage(), String.class));
            msg.ack();
        });
    }

}
