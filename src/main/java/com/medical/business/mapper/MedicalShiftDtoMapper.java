package com.medical.business.mapper;

import com.medical.domain.dto.response.MedicalShiftResponse;
import com.medical.domain.model.MedicalShift;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicalShiftDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MedicalShiftResponse toDto(MedicalShift medicalShift) {
        return modelMapper.map(medicalShift, MedicalShiftResponse.class);

    }

    public List<MedicalShiftResponse> toDto(List<MedicalShift> medicalShifts) {
        return medicalShifts
                .stream()
                .map(medicalShift -> toDto(medicalShift))
                .collect(Collectors.toList());
    }

}
