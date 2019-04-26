package com.dataart.dt.proto.k8s.db.controller;

import com.dataart.dt.proto.k8s.db.service.MessageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PubSub {

    static private Logger log = LoggerFactory.getLogger(PubSub.class);

    private final PubSubTemplate pubSubTemplate;

    private final MessageProcessor proc;

    @Value("${subscription.name}")
    private String subscriptionName;

    public PubSub(PubSubTemplate pubSubTemplate, MessageProcessor proc) {
        this.pubSubTemplate = pubSubTemplate;
        this.proc = proc;
    }

    @PostConstruct
    private void init() {
        pubSubTemplate.subscribe(subscriptionName, msg -> {
            String value = pubSubTemplate.getMessageConverter().fromPubSubMessage(msg.getPubsubMessage(), String.class);
            proc.processMessage(value);
            msg.ack();
        });
    }

}
