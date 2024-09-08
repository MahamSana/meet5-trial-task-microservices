package com.meet5.fraud.controller;

import com.meet5.fraud.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/fraud")
public class FraudDetectionController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    // endpoint to manually trigger fraud detection (could also be event-driven in real scenarios)
    @PostMapping("/detect")
    public void detectFraud(@RequestParam Long userId, @RequestParam String actionType) {
        fraudDetectionService.detectFraud(userId, actionType, LocalDateTime.now());
    }
}
