package com.medical.business.facade;

import com.medical.domain.dto.WorkingMonthDTO;

import java.util.List;

public interface WorkingMonthFacade {

    WorkingMonthDTO getWorkingMonth(Long workingMonthId) throws Exception;

    List<WorkingMonthDTO> getWorkingMonths();
}
