package com.medical.persistence;

import com.medical.domain.model.TimeConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeConsultationRepository extends JpaRepository<TimeConsultation, Long> {
}
