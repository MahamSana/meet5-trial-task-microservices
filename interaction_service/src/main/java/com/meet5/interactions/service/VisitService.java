package com.meet5.interactions.service;

import com.meet5.interactions.model.Visit;
import com.meet5.interactions.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public Visit recordVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    public List<Visit> getVisitsByUserId(Long userId) {
        return visitRepository.findAllByVisitorId(userId);
    }
}
