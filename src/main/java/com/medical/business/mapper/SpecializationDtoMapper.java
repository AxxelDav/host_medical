package com.medical.business.mapper;

import com.medical.domain.dto.SpecializationDTO;
import com.medical.domain.dto.UserDTO;
import com.medical.domain.model.Specialization;
import com.medical.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpecializationDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public SpecializationDTO toDto(Specialization specialization) {
        return modelMapper.map(specialization, SpecializationDTO.class);

    }

    public List<SpecializationDTO> toDto(List<Specialization> specializations) {
        return specializations
                .stream()
                .map(user -> toDto(user))
                .collect(Collectors.toList());
    }

}
