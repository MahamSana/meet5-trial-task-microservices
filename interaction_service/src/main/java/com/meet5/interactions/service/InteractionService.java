package com.meet5.interaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InteractionService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public InteractionService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // records a visit from one user to another and publishes an event to Kafka.
    public void recordVisit(Long visitorId, Long visitedId) {
        // logic to save visit (if applicable)
        String visitEvent = String.format("User %d visited user %d", visitorId, visitedId);
        kafkaTemplate.send("interaction-events", visitEvent);
        System.out.println("Published visit event: " + visitEvent);
    }

    // records a like from one user to another and publishes an event to Kafka.

    public void recordLike(Long likerId, Long likedId) {
        // logic to save like (if applicable)
        String likeEvent = String.format("User %d liked user %d", likerId, likedId);
        kafkaTemplate.send("interaction-events", likeEvent);
        System.out.println("Published like event: " + likeEvent);
    }
}
