package com.medical.business.facade.impl;

import com.medical.business.facade.MedicalShiftFacade;
import com.medical.business.mapper.*;
import com.medical.business.service.MedicalShiftService;
import com.medical.business.service.ProfessionalService;
import com.medical.business.service.SpecializationService;
import com.medical.domain.dto.MedicalShiftDTO;
import com.medical.domain.dto.SpecializationDTO;
import com.medical.domain.dto.request.*;
import com.medical.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public MedicalShiftDTO getMedicalShift(Long id) throws Exception {
        MedicalShift medicalShift = medicalShiftService.getMedicalShift(id);
        return medicalBranchDtoMapper.toDto(medicalShift);
    }

    @Override
    public void createSchedules(LocalDateTime registrationProfessionalDate, ProfessionalRequest request) {
        Professional professional = professionalRequestMapper.toDomain(request);
        medicalShiftService.createSchedules(registrationProfessionalDate, professional);
    }

    @Override
    public void takeMedicalShift(Long medicalShiftId, UserRequest request) throws Exception {
        User user = userRequestMapper.toDomain(request);
        medicalShiftService.takeMedicalShift(medicalShiftId, user);
    }

    @Override
    public void cancelMedicalShift(Long medicalShiftId) throws Exception {
        medicalShiftService.cancelMedicalShift(medicalShiftId);
    }

    @Override
    public List<MedicalShiftDTO> findAllForProfessionalBySpecialization(SpecializationRequest request) {
        Specialization specialization = specializationRequestMapper.toDomain(request);
        List<MedicalShift> medicalShifts = medicalShiftService.findAllForProfessionalBySpecialization(specialization);
        return medicalShiftDtoMapper.toDto(medicalShifts);
    }

    @Override
    public List<SpecializationDTO> findAllSpecializationByModality(ModalityRequest request) {
        Modality modality = modalityRequestMapper.toDomain(request);
        List<Specialization> specializations = medicalShiftService.findAllSpecializationByModality(modality);
        return specializationDtoMapper.toDto(specializations);
    }

    @Override
    public List<MedicalShiftDTO> requestMedicalShift(SpecializationRequest specializationRequest,
                                                     ProfessionalRequest professionalRequest,
                                                     MedicalBranchRequest medicalBranchRequest,
                                                     WorkingMonthRequest workingMonthRequest,
                                                     List<WorkingDayRequest> workingDayRequests,
                                                     WorkingShiftRequest workingShiftRequest) throws Exception {

        Specialization specialization = specializationRequestMapper.toDomain(specializationRequest);
        Professional professional = professionalRequestMapper.toDomain(professionalRequest);
        MedicalBranch medicalBranch = medicalBranchRequestMapper.toDomain(medicalBranchRequest);
        WorkingMonth workingMonth = workingMonthRequestMapper.toDomain(workingMonthRequest);
        List<WorkingDay> workingDays = workingDayRequestsMapper.toDomain(workingDayRequests);
        WorkingShift workingShift = workingShiftRequestMapper.toDomain(workingShiftRequest);
        List<MedicalShift> medicalShifts = medicalShiftService.requestMedicalShift(specialization, professional, medicalBranch, workingMonth, workingDays, workingShift);
        return medicalShiftDtoMapper.toDto(medicalShifts);
    }
}
