package com.medical.business.facade;

import com.medical.domain.dto.WorkingDayDTO;

import java.util.List;

public interface WorkingDayFacade {

    WorkingDayDTO getWorkingDay(Long workingDayId) throws Exception;

    List<WorkingDayDTO> getAllWorkingDay();
}
