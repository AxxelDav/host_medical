package com.medical.business.mapper;

import com.medical.domain.dto.request.MedicalBranchRequest;
import com.medical.domain.model.MedicalBranch;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicalBranchRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MedicalBranch toDomain(MedicalBranchRequest request) {
        return modelMapper.map(request, MedicalBranch.class);

    }

    public List<MedicalBranch> toDomain(List<MedicalBranchRequest> requests) {
        return requests
                .stream()
                .map(request -> toDomain(request))
                .collect(Collectors.toList());
    }

}
