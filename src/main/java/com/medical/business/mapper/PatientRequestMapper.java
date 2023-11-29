package com.medical.business.mapper;

import com.medical.domain.dto.request.PatientRequest;
import com.medical.domain.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Patient toDomain(PatientRequest request) {
        return modelMapper.map(request, Patient.class);

    }

    public List<Patient> toDomain(List<PatientRequest> requests) {
        return requests
                .stream()
                .map(request -> toDomain(request))
                .collect(Collectors.toList());
    }

}
