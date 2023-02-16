package org.acme.kafka.processor;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.smallrye.reactive.messaging.annotations.Blocking;


@ApplicationScoped
public class MessagesProcessor {

    private static final Logger LOG = Logger.getLogger(MessagesProcessor.class);

    @ConfigProperty(name = "consumer.delay.ms") 
    Integer delay;

    @Incoming("requests")
    @Blocking
    public void process(String message) throws InterruptedException {
        Thread.sleep(delay);

        LOG.info("Message Content: " + message);
    }
}
