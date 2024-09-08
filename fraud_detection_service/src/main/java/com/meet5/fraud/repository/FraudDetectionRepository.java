package com.meet5.fraud.repository;

import com.meet5.fraud.model.FraudDetection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudDetectionRepository extends JpaRepository<FraudDetection, Long> {

}
