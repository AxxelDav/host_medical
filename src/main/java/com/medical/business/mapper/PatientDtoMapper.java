package com.medical.business.mapper;

import com.medical.domain.dto.response.PatientResponse;
import com.medical.domain.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PatientResponse toDto(Patient patient) {
        return modelMapper.map(patient, PatientResponse.class);

    }

    public List<PatientResponse> toDto(List<Patient> patients) {
        return patients
                .stream()
                .map(patient -> toDto(patient))
                .collect(Collectors.toList());
    }

}
