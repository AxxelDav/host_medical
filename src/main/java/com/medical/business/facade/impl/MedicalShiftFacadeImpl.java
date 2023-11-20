package com.medical.business.facade.impl;

import com.medical.business.facade.MedicalShiftFacade;
import com.medical.business.mapper.*;
import com.medical.business.service.MedicalShiftService;
import com.medical.business.service.ProfessionalService;
import com.medical.business.service.SpecializationService;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.MedicalShiftResponse;
import com.medical.domain.dto.response.SpecializationResponse;
import com.medical.domain.dto.request.*;
import com.medical.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalShiftFacadeImpl implements MedicalShiftFacade {

    @Autowired
    private MedicalShiftService medicalShiftService;
    @Autowired
    private MedicalShiftDtoMapper medicalBranchDtoMapper;
    @Autowired
    private MedicalShiftRequestMapper medicalShiftRequestMapper;
    @Autowired
    private ProfessionalService professionalService;
    @Autowired
    private ProfessionalRequestMapper professionalRequestMapper;
    @Autowired
    private UserRequestMapper userRequestMapper;
    @Autowired
    private SpecializationRequestMapper specializationRequestMapper;
    @Autowired
    private SpecializationDtoMapper specializationDtoMapper;
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private MedicalShiftDtoMapper medicalShiftDtoMapper;
    @Autowired
    private ModalityRequestMapper modalityRequestMapper;
    @Autowired
    private MedicalBranchRequestMapper medicalBranchRequestMapper;
    @Autowired
    private WorkingMonthRequestMapper workingMonthRequestMapper;
    @Autowired
    private WorkingDayRequestMapper workingDayRequestsMapper;
    @Autowired
    private WorkingShiftRequestMapper workingShiftRequestMapper;


    @Override
    public MedicalShiftResponse findById(Long id) throws NonExistingResourceException {
        MedicalShift medicalShift = medicalShiftService.getMedicalShift(id);
        return medicalBranchDtoMapper.toDto(medicalShift);
    }

    @Override
    public void createMedicalShiftForProfessional(Long professionalId, String registrationProfessionalDate) throws IllegalArgumentException, NonExistingResourceException {
        medicalShiftService.createMedicalShiftForProfessional(professionalId, registrationProfessionalDate);
    }

    @Override
    public void takeMedicalShift(Long medicalShiftId, Long userId) throws NonExistingResourceException, IllegalArgumentException {
        medicalShiftService.takeMedicalShift(medicalShiftId, userId);
    }

    @Override
    public void cancelMedicalShift(Long medicalShiftId) throws NonExistingResourceException {
        medicalShiftService.cancelMedicalShift(medicalShiftId);
    }

    @Override
    public List<MedicalShiftResponse> findAllMedicalShiftBySpecialization(String specialization) throws DataInconsistencyException, IllegalArgumentException {
        List<MedicalShift> medicalShifts = medicalShiftService.findAllMedicalShiftBySpecialization(specialization);
        return medicalShiftDtoMapper.toDto(medicalShifts);
    }

    @Override
    public List<MedicalShiftResponse> requestMedicalShift(Long specializationId,
                                                          Long professionalId,
                                                          Long medicalBranchId,
                                                          Long workingMonthId,
                                                          Long workingShiftId,
                                                          List<Long> workingDayIds) throws DataInconsistencyException, IllegalArgumentException {

        List<MedicalShift> medicalShifts = medicalShiftService.requestMedicalShift(specializationId,
                                                                                   professionalId,
                                                                                   medicalBranchId,
                                                                                   workingMonthId,
                                                                                   workingShiftId,
                                                                                   workingDayIds);
        return medicalShiftDtoMapper.toDto(medicalShifts);
    }
}
