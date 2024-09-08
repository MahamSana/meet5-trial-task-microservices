package com.meet5.fraud.service;

import com.meet5.fraud.model.FraudDetection;
import com.meet5.fraud.repository.FraudDetectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class FraudDetectionService {

    @Autowired
    private FraudDetectionRepository fraudDetectionRepository;

    // this method detects fraudulent behavior based on recent interaction patterns
    public void detectFraud(Long userId, String actionType, LocalDateTime actionTime) {
        // example criteria: More than 100 actions in 10 minutes
        List<FraudDetection> recentActions = fraudDetectionRepository.findRecentActions(userId, actionType, LocalDateTime.now().minus(10, ChronoUnit.MINUTES));

        if (recentActions.size() > 100) {
            FraudDetection fraud = new FraudDetection();
            fraud.setUserId(userId);
            fraud.setActionType(actionType);
            fraud.setDescription("User exceeded action limit within 10 minutes.");
            fraudDetectionRepository.save(fraud);
        }
    }
}
