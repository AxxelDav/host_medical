package com.medical.business.mapper;

import com.medical.domain.dto.response.MedicalBranchResponse;
import com.medical.domain.model.MedicalBranch;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicalBranchDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MedicalBranchResponse toDto(MedicalBranch medicalBranch) {
        return modelMapper.map(medicalBranch, MedicalBranchResponse.class);

    }

    public List<MedicalBranchResponse> toDto(List<MedicalBranch> medicalBranches) {
        return medicalBranches
                .stream()
                .map(medicalBranch -> toDto(medicalBranch))
                .collect(Collectors.toList());
    }

}
