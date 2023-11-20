package com.medical.business.service.impl;

import com.medical.business.service.MedicalBranchService;
import com.medical.common.exception.DataInconsistencyException;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.common.util.ValidateTypeOfIdParameter;
import com.medical.domain.model.MedicalBranch;
import com.medical.persistence.MedicalBranchRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MedicalBranchServiceImpl implements MedicalBranchService {

    private MedicalBranchRepository medicalBranchRepository;

    public MedicalBranchServiceImpl(MedicalBranchRepository medicalBranchRepository) {
        this.medicalBranchRepository = medicalBranchRepository;
    }

    @Override
    public MedicalBranch create(MedicalBranch medicalBranch) throws IllegalArgumentException {
        if (Objects.isNull(medicalBranch)) {
            throw new IllegalArgumentException("Error creating medical-branch", "MedicalBranch can´t be null");
        }
        return medicalBranchRepository.save(medicalBranch);
    }


    @Override
    public MedicalBranch getMedicalBranch(Long medicalBranchId) throws NonExistingResourceException {
        return medicalBranchRepository.findById(medicalBranchId).orElseThrow(() -> new NonExistingResourceException("No existe Sucursal con id " + medicalBranchId));
    }

    @Override
    public MedicalBranch updateMedicalBranch(MedicalBranch medicalBranch) throws IllegalArgumentException {
        if (Objects.isNull(medicalBranch)) {
            throw new IllegalArgumentException("Error: with medicalBranch", "MedicalBranch can´t be null");
        }
        return medicalBranchRepository.save(medicalBranch);
    }

    @Override
    public void deleteMedicalBranch(Long id) throws NonExistingResourceException {
        getMedicalBranch(id);
        medicalBranchRepository.deleteById(id);
    }

    @Override
    public MedicalBranch findByLocaleAndNumberAndStreet(String locale, String streetNumber, String street) throws IllegalArgumentException, DataInconsistencyException  {
        if (Objects.isNull(locale) || Objects.isNull(streetNumber) || !ValidateTypeOfIdParameter.isNumeric(streetNumber)) {
            throw new IllegalArgumentException("Error: locale, streetNumber, and street must not be null, and streetNumber must be a valid number", "All the Arguments can´t be null");
        }
        try {
            return medicalBranchRepository.findByLocaleAndNumberAndStreet(locale, streetNumber, street);
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }

    @Override
    public List<MedicalBranch> findMedicalBranchBySpecializationAndProfessional(Long specializationId, Long professionalId) throws IllegalArgumentException, DataInconsistencyException {
        if (Objects.isNull(specializationId)) {
            throw new IllegalArgumentException("Error specializationId can´t be null", "specializationId can´t be null");
        }
        try {
            return medicalBranchRepository.findMedicalBranchBySpecializationAndProfessional(specializationId, professionalId);
        } catch (DataAccessException ex) {
            throw new DataInconsistencyException("Error executing query in database", ex);
        }
    }




}
