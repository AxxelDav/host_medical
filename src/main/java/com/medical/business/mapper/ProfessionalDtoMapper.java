package com.medical.business.mapper;

import com.medical.domain.dto.ProfessionalDTO;
import com.medical.domain.dto.UserDTO;
import com.medical.domain.model.Professional;
import com.medical.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfessionalDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProfessionalDTO toDto(Professional professional) {
        return modelMapper.map(professional, ProfessionalDTO.class);

    }

    public List<ProfessionalDTO> toDto(List<Professional> professionals) {
        return professionals
                .stream()
                .map(user -> toDto(user))
                .collect(Collectors.toList());
    }

}
