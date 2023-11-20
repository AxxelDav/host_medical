package com.medical.business.mapper;

import com.medical.domain.dto.response.SpecializationResponse;
import com.medical.domain.model.Specialization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpecializationDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public SpecializationResponse toDto(Specialization specialization) {
        return modelMapper.map(specialization, SpecializationResponse.class);

    }

    public List<SpecializationResponse> toDto(List<Specialization> specializations) {
        return specializations
                .stream()
                .map(user -> toDto(user))
                .collect(Collectors.toList());
    }

}
