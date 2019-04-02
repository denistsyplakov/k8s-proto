package com.dataart.dt.proto.k8s.front.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * GCP PubSub repository.
 */
@Service
public class PubSub {

    private Logger log = LoggerFactory.getLogger(PubSub.class);

    private String topicName = "k8s-proto";

    final private PubSubTemplate pubsubTemplate;

    public PubSub(PubSubTemplate pubsubTemplate) {
        this.pubsubTemplate = pubsubTemplate;
    }

    @PostConstruct
    private void start() {
        assert topicName != null;
        log.info("PubSub sender initialized for topic {}", topicName);
    }

    public void sendToPubSub(int payload) {
        log.info("PubSub {} -> {}", payload, topicName);
        pubsubTemplate.publish(topicName, "" + payload);
    }
}
