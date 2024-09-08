package com.meet5.interactions.controller;

import com.meet5.interactions.model.Visit;
import com.meet5.interactions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @PostMapping
    public Visit recordVisit(@RequestBody Visit visit) {
        return visitService.recordVisit(visit);
    }

    @GetMapping("/{visitorId}")
    public List<Visit> getVisitsByUser(@PathVariable Long visitorId) {
        return visitService.getVisitsByUserId(visitorId);
    }
}
