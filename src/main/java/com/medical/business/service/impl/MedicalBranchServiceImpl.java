package com.medical.business.service.impl;

import com.medical.business.service.MedicalBranchService;
import com.medical.domain.model.MedicalBranch;
import com.medical.persistence.MedicalBranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalBranchServiceImpl implements MedicalBranchService {

    private MedicalBranchRepository medicalBranchRepository;

    public MedicalBranchServiceImpl(MedicalBranchRepository medicalBranchRepository) {
        this.medicalBranchRepository = medicalBranchRepository;
    }

    @Override
    public MedicalBranch createMedicalBranch(MedicalBranch medicalBranch) {
        return medicalBranchRepository.save(medicalBranch);
    }

    @Override
    public MedicalBranch getMedicalBranch(Long id) throws Exception {
        return medicalBranchRepository.findById(id).orElseThrow(() -> new Exception("No existe Sucursal con id " + id));
    }

    @Override
    public MedicalBranch updateMedicalBranch(MedicalBranch medicalBranch) throws Exception {
        getMedicalBranch(medicalBranch.getId());
        return medicalBranchRepository.save(medicalBranch);
    }

    @Override
    public void deleteMedicalBranch(Long id) throws Exception {
        getMedicalBranch(id);
        medicalBranchRepository.deleteById(id);
    }

    @Override
    public MedicalBranch findByLocaleAndNumberAndStreet(String locale, String streetNumber, String street) {
        return medicalBranchRepository.findByLocaleAndNumberAndStreet(locale, streetNumber, street);
    }

    @Override
//    public List<MedicalBranch> findMedicalBranchBySpecializationAndProfessional(Specialization specialization, Professional professional) {
//        Long specializationId = specialization.getId();
//        Long professionalId = professional != null ? professional.getId() : null;
//        return medicalBranchRepository.findMedicalBranchBySpecializationAndProfessional(specializationId, professionalId);
    public List<MedicalBranch> findMedicalBranchBySpecializationAndProfessional(Long specializationId, Long professionalId) {
        return medicalBranchRepository.findMedicalBranchBySpecializationAndProfessional(specializationId, professionalId);
    }




}
