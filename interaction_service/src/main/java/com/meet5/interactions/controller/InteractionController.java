package com.meet5.interaction.controller;

import com.meet5.interaction.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class InteractionController {

    private final InteractionService interactionService;

    @Autowired
    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping("/visit")
    public ResponseEntity<String> recordVisit(@RequestParam Long visitorId, @RequestParam Long visitedId) {
        interactionService.recordVisit(visitorId, visitedId);
        return ResponseEntity.ok("Visit recorded successfully.");
    }

    @PostMapping("/like")
    public ResponseEntity<String> recordLike(@RequestParam Long likerId, @RequestParam Long likedId) {
        interactionService.recordLike(likerId, likedId);
        return ResponseEntity.ok("Like recorded successfully.");
    }
}
