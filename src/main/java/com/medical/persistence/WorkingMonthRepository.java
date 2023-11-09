package com.medical.persistence;

import com.medical.domain.model.WorkingMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingMonthRepository extends JpaRepository<WorkingMonth, Long> {

    @Query(value = "SELECT * FROM MES_LABORAL ml WHERE ml.MES_LABORAL_ID IN (:monthIds)", nativeQuery = true)
    List<WorkingMonth> getWorkingMonths(List<Integer> monthIds);

}
