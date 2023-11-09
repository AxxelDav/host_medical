package com.medical.business.mapper;

import com.medical.domain.dto.MedicalShiftDTO;
import com.medical.domain.dto.UserDTO;
import com.medical.domain.model.MedicalShift;
import com.medical.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicalShiftDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MedicalShiftDTO toDto(MedicalShift medicalShift) {
        return modelMapper.map(medicalShift, MedicalShiftDTO.class);

    }

    public List<MedicalShiftDTO> toDto(List<MedicalShift> medicalShifts) {
        return medicalShifts
                .stream()
                .map(medicalShift -> toDto(medicalShift))
                .collect(Collectors.toList());
    }

}
