package com.medical.business.mapper;

import com.medical.domain.dto.MedicalBranchDTO;
import com.medical.domain.dto.UserDTO;
import com.medical.domain.model.MedicalBranch;
import com.medical.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicalBranchDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MedicalBranchDTO toDto(MedicalBranch medicalBranch) {
        return modelMapper.map(medicalBranch, MedicalBranchDTO.class);

    }

    public List<MedicalBranchDTO> toDto(List<MedicalBranch> medicalBranches) {
        return medicalBranches
                .stream()
                .map(medicalBranch -> toDto(medicalBranch))
                .collect(Collectors.toList());
    }

}
