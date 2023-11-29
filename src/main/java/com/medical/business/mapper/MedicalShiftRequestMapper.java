package com.medical.business.mapper;

import com.medical.domain.dto.request.MedicalShiftRequest;
import com.medical.domain.model.MedicalShift;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicalShiftRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MedicalShift toDomain(MedicalShiftRequest request) {
        return modelMapper.map(request, MedicalShift.class);

    }

    public List<MedicalShift> toDomain(List<MedicalShiftRequest> requests) {
        return requests
                .stream()
                .map(request -> toDomain(request))
                .collect(Collectors.toList());
    }

}
