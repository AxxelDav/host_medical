package com.medical.business.mapper;

import com.medical.domain.dto.response.ProfessionalResponse;
import com.medical.domain.model.Professional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfessionalDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProfessionalResponse toDto(Professional professional) {
        return modelMapper.map(professional, ProfessionalResponse.class);

    }

    public List<ProfessionalResponse> toDto(List<Professional> professionals) {
        return professionals
                .stream()
                .map(user -> toDto(user))
                .collect(Collectors.toList());
    }

}
