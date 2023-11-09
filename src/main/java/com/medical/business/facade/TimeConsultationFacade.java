package com.medical.business.facade;

import com.medical.domain.dto.TimeConsultationDTO;
import com.medical.domain.dto.request.TimeConsultationRequest;

public interface TimeConsultationFacade {

    TimeConsultationDTO createTimeConsultation(TimeConsultationRequest request);

    TimeConsultationDTO getTimeConsultation(Long id) throws Exception;

    TimeConsultationDTO updateTimeConsultation(TimeConsultationRequest request) throws Exception;

    void deleteTimeConsultation(Long id) throws Exception;
}
