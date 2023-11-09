package com.medical.persistence;

import com.medical.domain.model.WorkingShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkShiftRepository extends JpaRepository<WorkingShift, Long> {
}
